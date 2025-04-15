package Enumerations;

import Utilities.Randomizer;

public enum LootType {
    BULLET, POINTS;

    private static final LootType[] VALUES = values();
    private static final int SIZE = VALUES.length;

    public static LootType getRandom() {
        return VALUES[Randomizer.getRandomIntBetween(0, SIZE - 1)];
    }
}
