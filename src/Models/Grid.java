package Models;

import Enumerations.CellType;
import Interfaces.Displayable;
import Utilities.Constants;
import Utilities.Randomizer;

import java.util.List;

public class Grid implements Displayable {
    private final Cell[][] cells = new Cell[Constants.GRID_AREA][Constants.GRID_AREA];

    public Grid() {
        populateCells();
        createShip();
        createShip();
        createShip();
        createShip();
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
                cells[row][column] = new Cell(row, column);
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
        }
    }
}
