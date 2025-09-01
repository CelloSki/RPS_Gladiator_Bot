package src;

import java.util.Scanner;

public class Player {
    private String name;

    //----------------------------------------------------------------------------------------
    // Returns an object which holds the score data about the player.
    //----------------------------------------------------------------------------------------
    public ScoreStats getScoreStats() {
        return scoreStats;
    }

    private ScoreStats scoreStats;
    private src.Object playerObject;

    Scanner input = new Scanner(System.in);

    //----------------------------------------------------------------------------------------
    // Constructor to set up a new player.
    //----------------------------------------------------------------------------------------
    public Player(String name) {
        this.name = name;
        this.playerObject = new src.Object();
        this.scoreStats = new ScoreStats();
    }

    //----------------------------------------------------------------------------------------
    // Method to returns players name
    //----------------------------------------------------------------------------------------
    public String getName() {
        return name;
    }

    //----------------------------------------------------------------------------------------
    // Method to set player objects
    //----------------------------------------------------------------------------------------
    public void setPlayerObjects() {
        System.out.println("\n Choose your game Item");
        System.out.print("\n 1. Rock");
        System.out.print("\n 2. Paper");
        System.out.print("\n 3. Scissors");
        System.out.print("\n Enter choice: ");
        int option = input.nextInt();
        input.nextLine();

        switch (option) {
            case 1:
                playerObject.setGameObject(1);
                break;
            case 2:
                playerObject.setGameObject(2);
                break;
            case 3:
                playerObject.setGameObject(3);
                break;
            default:
                System.out.println("Error in Class Player, line 44");
        }
    }

    public Object.GameObject getPlayerObject() {
        return playerObject.getGameObject();
    }

    public void updateScoreStats(boolean playerWins) {
        if (playerWins) {
            scoreStats.increaseScore();
            scoreStats.setWins(1);
        }
        if (!playerWins) {
            scoreStats.decreaseScore();
            scoreStats.setLosses();
        }
    }
}
