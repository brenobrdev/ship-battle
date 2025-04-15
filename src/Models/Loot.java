package Models;

import Enumerations.LootType;
import Interfaces.Hittable;
import Utilities.Randomizer;

public class Loot implements Hittable {
    private final LootType type;

    public Loot(LootType type) {
        this.type = type;
    }

    public void hit() {
        switch (type) {
            case BULLET -> {
                int numberOfBullets = Randomizer.getRandomIntBetween(3, 8);
                GameManager.addBullets(numberOfBullets);
                GameManager.setCurrentMessage("You got " + numberOfBullets + " more bullets!");
            }
            case POINTS -> {
                GameManager.addScore(100);
                GameManager.setCurrentMessage("You got " + 100 + " extra points!");
            }
        }
    }
}
