import Models.Cell;
import Models.Grid;
import Models.Vector2;
import Utilities.Input;

import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Grid grid = new Grid();
        Scanner input = new Scanner(System.in);
        Cell selectedCell = null;

        while (true) {
            System.out.println("Score: " + 100 + "   Bullets: " + 200);

            grid.display();

            System.out.println("Pick a cell to shoot:");

            Vector2 coordinates = Input.parse(input.next().trim().toUpperCase());
            if (coordinates == null) {
                System.out.println("Please enter coordinates in the format: A1.");
                continue;
            }

            selectedCell = grid.getCell(coordinates);
            if (selectedCell == null) {
                System.out.println("Please enter coordinates for a valid cell (between A1 and J10).");
                continue;
            }

            selectedCell.reveal();
        }
    }
}
