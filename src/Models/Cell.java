package Models;

import Enumerations.CellType;
import Interfaces.Displayable;

public class Cell implements Displayable {
    private final Vector2 position;
    private CellType type = CellType.FOG;

    public Cell(int x, int y) {
        this.position = new Vector2(x, y);
    }

    @Override
    public void display() {
        String suffix;

        if (position.getY() == 10)
            suffix = "\n";
        else
            suffix = " ";

        if (position.getX() == 0) {
            System.out.print(position.getY() + suffix);
        } else if (position.getY() == 0) {
            System.out.print(Character.toString(position.getX() + 64) + suffix);
        } else {
            System.out.print(type.toString() + suffix);
        }
    }

    public Vector2 getPosition() {
        return position;
    }

    public CellType getType() {
        return type;
    }

    public void setType(CellType type) {
        this.type = type;
    }

    public boolean isEmpty() {
        return this.type == CellType.EMPTY || this.type == CellType.FOG;
    }
}
