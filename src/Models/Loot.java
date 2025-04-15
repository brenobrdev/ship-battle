package Models;

import Enumerations.LootType;
import Interfaces.Hittable;
import Utilities.Randomizer;

public class Loot implements Hittable {
    private LootType type;

    public Loot(LootType type) {
        this.type = type;
    }

    public void hit(GameManager gm) {
        switch (type) {
            case BULLET -> {
                int numberOfBullets = Randomizer.getRandomIntBetween(3, 8);
                gm.addBullets(numberOfBullets);
                gm.setCurrentMessage("You got " + numberOfBullets + " more bullets!");
            }
            case POINTS -> {
                gm.addScore(100);
                gm.setCurrentMessage("You got " + 100 + " extra points!");
            }
        }
    }
}
