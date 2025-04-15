package Models;

public class GameManager {
    private int score;
    private int bullets = 3;
    private Grid grid;

    public GameManager() {
        startNewGrid();
    }

    public int getScore() {
        return score;
    }

    public void addScore(int amount) {
        score += amount;
    }

    public int getBullets() {
        return bullets;
    }

    public void useBullet() {
        bullets--;
    }

    public Grid getGrid() {
        return grid;
    }

    public void startNewGrid() {
        this.grid = new Grid(this);
    }
}
