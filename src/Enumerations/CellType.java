package Enumerations;

public enum CellType {
    WATER('~'),
    LOOT('L'),
    SHIP('O'),
    EMPTY(' '),
    FOG('.');

    private final char displayCharacter;

    CellType(char displayCharacter) {
        this.displayCharacter = displayCharacter;
    }

    @Override
    public String toString() {
        return Character.toString(displayCharacter);
    }
}
