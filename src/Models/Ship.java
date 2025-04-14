package Models;

public class Ship {
    private final int MAX_LENGTH = 4;

    private int[] startingCoordinate = new int[2];
    private int length = 2;
    private boolean isHorizontal = false;

    private Ship() {

    }

    public static Ship createShip() {
        return new Ship();
    }

    private int getShipLength() {
        return (int) Math.floor(Math.random() * (MAX_LENGTH + 1));
    }
}
