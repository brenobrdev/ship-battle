package Models;

import Interfaces.Displayable;
import Utilities.Constants;

public class Grid implements Displayable {
    private final Cell[][] cells = new Cell[Constants.GRID_AREA][Constants.GRID_AREA];

    public Grid() {
        populateCells();
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

    public Cell getCell(Vector2 coordinates) {
        if (coordinates.getX() > 0 && coordinates.getX() < Constants.GRID_AREA
                && coordinates.getY() > 0 && coordinates.getY() < Constants.GRID_AREA) {
            return cells[coordinates.getX()][coordinates.getY()];
        }

        return null;
    }
}
