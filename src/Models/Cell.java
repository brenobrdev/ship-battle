package Models;

import Enumerations.CellType;
import Interfaces.Displayable;
import Interfaces.Consumable;
import Utilities.Constants;

public class Cell implements Displayable {
    final String PREFIX = "  ";
    final boolean IS_HORIZONTAL_HEADER;
    final boolean IS_VERTICAL_HEADER;
    final boolean IS_AFTER_COLUMN_9;
    final boolean IS_LAST_COLUMN;

    private final Vector2 position;

    private CellType type = CellType.EMPTY;
    private boolean isRevealed = false;
    private Consumable content;

    public Cell(int x, int y) {
        this.position = new Vector2(x, y);
        IS_HORIZONTAL_HEADER = position.getX() == 0;
        IS_VERTICAL_HEADER = position.getY() == 0;
        IS_AFTER_COLUMN_9 = position.getY() > 9;
        IS_LAST_COLUMN = position.getY() == Constants.GRID_AREA - 1;
    }

    @Override
    public void display() {
        String suffix = PREFIX;

        if (IS_AFTER_COLUMN_9 && IS_HORIZONTAL_HEADER)
            suffix = " ";

        if (IS_LAST_COLUMN)
            suffix = "\n";

        if (!isRevealed) {
            System.out.print(PREFIX + "." + suffix);
            return;
        }

        if (IS_HORIZONTAL_HEADER) {
            System.out.print(PREFIX + position.getY() + suffix);
        } else if (IS_VERTICAL_HEADER) {
            System.out.print(PREFIX + Character.toString(position.getX() + 64) + suffix);
        } else {
            System.out.print(PREFIX + type.toString() + suffix);
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
        return this.type == CellType.EMPTY;
    }

    public void reveal() {
        isRevealed = true;
    }

    public void setContent(Consumable content) {
        this.content = content;
    }

    public void processHit(GameManager gm) {
        if (content != null) {
            content.consume(gm);
            content = null;
        }
    }
}
