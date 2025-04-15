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
    public void hit() {
        hitPoints--;
        if (isDestroyed()) {
            GameManager.getGrid().destroyOneShip();
            GameManager.setCurrentMessage("You destroyed a ship! Only " + GameManager.getGrid().getShipsAlive() + " ships remaining. \n+50 points");
            GameManager.addScore(50);
        } else {
            GameManager.setCurrentMessage("+10 points");
            GameManager.addScore(10);
        }
    }
}
