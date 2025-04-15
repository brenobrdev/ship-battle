package Models;

import Interfaces.Hittable;

public class Ship implements Hittable {
    private int hitPoints;

    public Ship( int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public boolean isDestroyed() {
        return hitPoints <= 0;
    }

    @Override
    public void hit(GameManager gm) {
        hitPoints--;
        if (isDestroyed()) {
            gm.getGrid().destroyOneShip();
            gm.setCurrentMessage("You destroyed a ship! Only " + gm.getGrid().getShipsAlive() + " ships remaining. \n+50 points");
            gm.addScore(50);
        } else {
            gm.setCurrentMessage("+10 points");
            gm.addScore(10);
        }
    }
}
