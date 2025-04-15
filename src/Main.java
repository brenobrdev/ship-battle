import Models.Cell;
import Models.GameManager;
import Models.Vector2;
import Utilities.Input;

import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        GameManager gm = new GameManager();
        Scanner input = new Scanner(System.in);
        Cell selectedCell;
        Input.clearScreen();

        while (gm.getBullets() > 0) {
            System.out.println("Score: " + gm.getScore() + "   Bullets: " + gm.getBullets());

            gm.getGrid().display();

            System.out.println(gm.getCurrentMessage());
            gm.clearCurrentMessage();
            System.out.println("Pick a cell to shoot:");

            Vector2 coordinates = Input.parse(input.next().trim().toUpperCase());
            Input.clearScreen();
            if (coordinates == null) {
                gm.setCurrentMessage("Please enter coordinates in the format \"A1\".");
                continue;
            }

            selectedCell = gm.getGrid().getCell(coordinates);
            if (selectedCell == null) {
                gm.setCurrentMessage("Please enter coordinates for a valid cell.");
                continue;
            }

            selectedCell.processHit(gm);

            if (!gm.getGrid().hasShipsAlive()) {
                gm.startNewGrid();
            }
        }

        System.out.println("Game over. You scored " + gm.getScore() + " points.");
    }
}
