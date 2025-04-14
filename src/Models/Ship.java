package Models;

import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class Ship {
    private final Set<Vector2> coordinates = new HashSet<>();

    public Ship(List<Vector2> coordinates) {
        this.coordinates.addAll(coordinates);
    }

    public boolean checkHit(Vector2 coordinate) {
        return coordinates.remove(coordinate);
    }

    public boolean isAlive() {
        return !coordinates.isEmpty();
    }
}
