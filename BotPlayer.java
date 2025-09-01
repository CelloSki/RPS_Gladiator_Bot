package src;

import java.util.Random;

public class BotPlayer extends Player{
    private ScoreStats scoreStats;
    private Object object;

    Random rand = new Random();
    int randomNumber = (rand.nextInt(3) + 1);

    public BotPlayer() {
        super("Bot");
        this.scoreStats = new ScoreStats();
        this.object = new Object();
    }

    @Override
    public void setPlayerObjects() {
        object.setGameObject(randomNumber);
    }

    @Override
    public Object.GameObject getPlayerObject() {
        return object.getGameObject();
    }

    @Override
    public ScoreStats getScoreStats() {
        return scoreStats;
    }
}
