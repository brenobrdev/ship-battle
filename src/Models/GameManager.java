package Models;

public class GameManager {
    private static int score;
    private static int bullets = 50;
    private static Grid grid;
    private static String currentMessage = "";

    public static int getScore() {
        return score;
    }

    public static void addScore(int amount) {
        score += amount;
    }

    public static int getBullets() {
        return bullets;
    }

    public static void useBullet() {
        bullets--;
    }

    public static void addBullets(int amount) {
        bullets += amount;
    }

    public static Grid getGrid() {
        return grid;
    }

    public static void startNewGrid() {
        grid = new Grid();
    }

    public static String getCurrentMessage() {
        return currentMessage;
    }

    public static void setCurrentMessage(String newMessage) {
        currentMessage = newMessage;
    }

    public static void clearCurrentMessage() {
        setCurrentMessage("");
    }
}
