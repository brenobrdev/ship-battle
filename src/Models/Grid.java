package Models;

import Enumerations.CellType;
import Enumerations.LootType;
import Interfaces.Displayable;
import Utilities.Constants;
import Utilities.Randomizer;

import java.util.ArrayList;
import java.util.List;

public class Grid implements Displayable {
    private final Cell[][] cells = new Cell[Constants.GRID_AREA][Constants.GRID_AREA];
    private final List<Ship> ships = new ArrayList<>();
    private final GameManager gm;

    public Grid(GameManager gm) {
        populateCells();
        createShip();
        createShip();
        createShip();
        createShip();
        createLoot(3);
        this.gm = gm;
    }

    @Override
    public void display() {
        for (int row = 0; row < Constants.GRID_AREA; row++) {
            for (int column = 0; column < Constants.GRID_AREA; column++) {
                cells[row][column].display();
            }
        }
    }

    private void populateCells() {
        for (int row = 0; row < Constants.GRID_AREA; row++) {
            for (int column = 0; column < Constants.GRID_AREA; column++) {
                Cell cell = new Cell(row, column);

                if (row == 0 || column == 0)
                    cell.reveal(); // Reveals the cell if it's a header
                cells[row][column] = cell;
            }
        }
    }

    private Cell getCell(int x, int y) {
        if (x > 0 && x < Constants.GRID_AREA && y > 0 && y < Constants.GRID_AREA) {
            return cells[x][y];
        }

        return null;
    }

    public Cell getCell(Vector2 coordinates) {
        return getCell(coordinates.getX(), coordinates.getY());
    }

    public boolean hasShipsAlive() {
        return !ships.isEmpty();
    }

    public void createLoot(int count) {
        for (int i = 0; i < count; i++) {
            Cell cell = getEmptyCell();
            cell.setType(CellType.LOOT);
            cell.setContent(new Loot(LootType.getRandom()));
        }
    }

    public void createShip() {
        int length = Randomizer.getRandomShipLength();
        List<Vector2> randomCoordinates = Randomizer.getRandomConsecutiveCellCoordinates(length);
        boolean areAllCoordinatesEmptyCells = true;

        for (Vector2 coordinate : randomCoordinates) {
            Cell cell = getCell(coordinate);

            if (!cell.isEmpty()) {
                areAllCoordinatesEmptyCells = false;
                createShip();
            }
        }

        if (areAllCoordinatesEmptyCells) {
            for (Vector2 coordinate : randomCoordinates) {
                Cell freeCell = getCell(coordinate);
                cells[freeCell.getPosition().getX()][freeCell.getPosition().getY()].setType(CellType.SHIP);
            }

            ships.add(new Ship(randomCoordinates));
        }
    }

    public void checkHit(Cell target) {
        target.reveal();
        gm.useBullet();

        switch (target.getType()) {
            case EMPTY -> gm.setCurrentMessage("Water...");
            case LOOT -> target.processHit(gm);
            case SHIP -> ships.stream()
                                .filter(ship -> ship.checkHit(target.getPosition()))
                                .findFirst()
                                .ifPresent(ship -> {
                                    if (!ship.isAlive()) {
                                        ships.remove(ship);
                                        gm.setCurrentMessage("You destroyed a ship! Only " + (ships.size()) + " remaining!\n+50 points");
                                        gm.addScore(50);
                                    } else {
                                        gm.setCurrentMessage("+10 points");
                                        gm.addScore(10);
                                    }
                                });
        }
    }

    public Cell getEmptyCell() {
        while (true) {
            Cell potentialCell = getCell(Randomizer.getRandomCoordinates());
            if (potentialCell.isEmpty()) {
                return potentialCell;
            }
        }
    }
}
