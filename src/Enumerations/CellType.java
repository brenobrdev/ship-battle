package Enumerations;

public enum CellType {
    LOOT('L'),
    SHIP('O'),
    EMPTY('~');

    private final char displayCharacter;

    CellType(char displayCharacter) {
        this.displayCharacter = displayCharacter;
    }

    @Override
    public String toString() {
        return Character.toString(displayCharacter);
    }
}
