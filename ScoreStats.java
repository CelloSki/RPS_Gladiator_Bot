package src;

public class ScoreStats {
    private int score = 1;
    private int wins = 0;
    private int losses = 0;

    public void increaseScore() {
        this.score = +score * 5;
    }

    public void decreaseScore() {
        this.score = -score * 5;
        if (score < 0) this.score = 0;
    }

    public void setWins(int wins) {
        this.wins = +wins;
    }

    public void setLosses() {
     this.losses = +losses;
    }

    //----------------------------------------------------------------------------------------
    // Method to print the Score Statics for this a player.
    //----------------------------------------------------------------------------------------
    public void printResults() {
        System.out.println("You won: " + wins);
        System.out.println("You final score is : " + score);
        System.out.println("You took " + losses + " loss");
        System.out.println("After Round: " + GameLogic.rounds);
    }
}
