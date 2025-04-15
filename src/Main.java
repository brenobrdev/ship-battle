import Models.Cell;
import Models.GameManager;
import Models.Vector2;
import Utilities.Input;

import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        GameManager gm = new GameManager();
        Scanner input = new Scanner(System.in);
        Cell selectedCell = null;
        Input.clearScreen();

        while (gm.getGrid().hasShipsAlive()) {
            System.out.println("Score: " + gm.getScore() + "   Bullets: " + gm.getBullets());

            gm.getGrid().display();

            System.out.println("Pick a cell to shoot:");

            Vector2 coordinates = Input.parse(input.next().trim().toUpperCase());
            Input.clearScreen();
            if (coordinates == null) {
                System.out.println("Please enter coordinates in the format: A1.");
                continue;
            }

            selectedCell = gm.getGrid().getCell(coordinates);
            if (selectedCell == null) {
                System.out.println("Please enter coordinates for a valid cell (between A1 and J10).");
                continue;
            }

            gm.getGrid().checkHit(selectedCell);
        }
    }
}
