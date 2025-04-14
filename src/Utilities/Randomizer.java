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

        int initialCoordinateMax = Constants.GRID_AREA - count;
        int initialCoordinate = random.nextInt(initialCoordinateMax - 1) + 1; // -1 and +1 to avoid coordinates for grid headers.
        int perpendicularCoordinate = random.nextInt(Constants.GRID_AREA - 1) + 1;  // -1 and +1 to avoid coordinates for grid headers.

        for (int i = initialCoordinate; i < initialCoordinate + count; i++) {
            if (isHorizontal)
                randomConsecutiveCoordinates.add(new Vector2(i, perpendicularCoordinate));
            else
                randomConsecutiveCoordinates.add(new Vector2(perpendicularCoordinate, i));
        }

        return randomConsecutiveCoordinates;
    }

    public static int getRandomShipLength() {
        return random.nextInt((Constants.MAX_SHIP_LENGTH + 1) - Constants.MIN_SHIP_LENGTH) + Constants.MIN_SHIP_LENGTH;
    }

    public static boolean getRandomBoolean() {
        return random.nextBoolean();
    }
}
