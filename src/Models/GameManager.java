package Models;

public class GameManager {
    private int score;
    private int bullets = 7;
    private Grid grid;
    private String currentMessage = "";

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

    public void addBullets(int amount) {
        bullets += amount;
    }

    public Grid getGrid() {
        return grid;
    }

    public void startNewGrid() {
        this.grid = new Grid();
    }

    public String getCurrentMessage() {
        return currentMessage;
    }

    public void setCurrentMessage(String currentMessage) {
        this.currentMessage = currentMessage;
    }

    public void clearCurrentMessage() {
        setCurrentMessage("");
    }
}
