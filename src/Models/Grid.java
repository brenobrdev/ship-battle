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

    private int shipsAlive = 0;

    public Grid() {
        populateCells();
        createShip(4);
        createLoot(3);
    }

    @Override
    public void display() {
        for (int row = 0; row < Constants.GRID_AREA; row++) {
            for (int column = 0; column < Constants.GRID_AREA; column++) {
                cells[row][column].display();
            }
        }
    }

    public int getShipsAlive() {
        return shipsAlive;
    }

    public boolean hasShipsAlive() {
        return this.shipsAlive > 0;
    }

    public void destroyOneShip() {
        shipsAlive--;
    }

    public Cell getCell(Vector2 coordinates) {
        return getCell(coordinates.getX(), coordinates.getY());
    }

    private void populateCells() {
        for (int row = 0; row < Constants.GRID_AREA; row++) {
            for (int column = 0; column < Constants.GRID_AREA; column++) {
                Cell cell = new Cell(row, column);
                cell.reveal();
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

    private void createLoot(int count) {
        for (int i = 0; i < count; i++) {
            Cell cell = getEmptyCell();
            cell.setType(CellType.LOOT);
            cell.setContent(new Loot(LootType.getRandom()));
        }
    }

    private void createShip(int count) {
        for (int i = 0; i < count; i++) {
            int length = Randomizer.getRandomShipLength();

            List<Cell> consecutiveEmptyCells = getConsecutiveEmptyCells(length);

            Ship ship = new Ship(length);

            for (Cell emptyCell : consecutiveEmptyCells) {
                emptyCell.setContent(ship);
                cells[emptyCell.getPosition().getX()][emptyCell.getPosition().getY()].setType(CellType.SHIP);
            }

            shipsAlive++;
        }
    }

    private Cell getEmptyCell() {
        while (true) {
            Cell potentialCell = getCell(Randomizer.getRandomCoordinates());
            if (potentialCell.isEmpty()) {
                return potentialCell;
            }
        }
    }

    private List<Cell> getConsecutiveEmptyCells(int count) {
        List<Cell> consecutiveEmptyCells = new ArrayList<>();

        while (true) {
            List<Vector2> randomCoordinates = Randomizer.getRandomConsecutiveCellCoordinates(count);

            for (Vector2 coordinate : randomCoordinates) {
                Cell cell = getCell(coordinate);

                if (!cell.isEmpty())
                    break;
                else
                    consecutiveEmptyCells.add(cell);
            }

            if (randomCoordinates.size() != consecutiveEmptyCells.size())
                consecutiveEmptyCells.clear();
            else
                return consecutiveEmptyCells;
        }
    }
}
