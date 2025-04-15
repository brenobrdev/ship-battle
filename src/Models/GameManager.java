package Models;

public class GameManager {
    private int score;
    private int bullets;
    private Grid grid;

    public GameManager() {
        startNewGrid();
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void addScore(int amount) {
        this.score += amount;
    }

    public int getBullets() {
        return bullets;
    }

    public void setBullets(int bullets) {
        this.bullets = bullets;
    }

    public Grid getGrid() {
        return grid;
    }

    public void startNewGrid() {
        this.grid = new Grid(this);
    }
}
