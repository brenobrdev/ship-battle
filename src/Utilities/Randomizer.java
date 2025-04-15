package Utilities;

import Models.Vector2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Randomizer {
    private static final Random random = new Random();

    public static List<Vector2> getRandomConsecutiveCellCoordinates(int count) {
        List<Vector2> randomConsecutiveCoordinates = new ArrayList<>();
        boolean isHorizontal = getRandomBoolean();

        int initialCoordinateMax = (Constants.GRID_AREA - 1) - count;
        int initialCoordinate = getRandomIntBetween(1, initialCoordinateMax);
        int perpendicularCoordinate = getRandomIntBetween(1, (Constants.GRID_AREA - 1));

        for (int i = initialCoordinate; i < initialCoordinate + count; i++) {
            if (isHorizontal)
                randomConsecutiveCoordinates.add(new Vector2(i, perpendicularCoordinate));
            else
                randomConsecutiveCoordinates.add(new Vector2(perpendicularCoordinate, i));
        }

        return randomConsecutiveCoordinates;
    }

    public static int getRandomShipLength() {
        return getRandomIntBetween(Constants.MIN_SHIP_LENGTH, Constants.MAX_SHIP_LENGTH);
    }

    public static boolean getRandomBoolean() {
        return random.nextBoolean();
    }

    public static Vector2 getRandomCoordinates() {
        int x = random.nextInt(Constants.GRID_AREA - 1) + 1;
        int y = random.nextInt(Constants.GRID_AREA - 1) + 1;
        return new Vector2(x, y);
    }

    public static int getRandomIntBetween(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }
}
