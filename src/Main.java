import Models.Cell;
import Models.GameManager;
import Models.Vector2;
import Utilities.Input;

import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        GameManager.startNewGrid();
        Scanner input = new Scanner(System.in);
        Cell selectedCell;
        Input.clearScreen();

        while (GameManager.getBullets() > 0) {
            System.out.println("Score: " + GameManager.getScore() + "   Bullets: " + GameManager.getBullets());

            GameManager.getGrid().display();

            System.out.println(GameManager.getCurrentMessage());
            GameManager.clearCurrentMessage();
            System.out.println("Pick a cell to shoot:");

            Vector2 coordinates = Input.parse(input.next().trim().toUpperCase());
            Input.clearScreen();
            if (coordinates == null) {
                GameManager.setCurrentMessage("Please enter coordinates in the format \"A1\".");
                continue;
            }

            selectedCell = GameManager.getGrid().getCell(coordinates);
            if (selectedCell == null) {
                GameManager.setCurrentMessage("Please enter coordinates for a valid cell.");
                continue;
            }

            selectedCell.processHit();

            if (!GameManager.getGrid().hasShipsAlive()) {
                GameManager.startNewGrid();
            }
        }

        System.out.println("Game over. You scored " + GameManager.getScore() + " points.");
    }
}
