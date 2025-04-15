package Models;

import Enumerations.LootType;
import Interfaces.Consumable;
import Utilities.Randomizer;

public class Loot implements Consumable {
    private LootType type;

    public Loot(LootType type) {
        this.type = type;
    }

    public void consume(GameManager gm) {
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
