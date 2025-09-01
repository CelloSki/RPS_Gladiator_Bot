package src;

import java.util.Scanner;

//----------------------------------------------------------------------------------------
// The purpose of this class is to build the logic of this game.
//----------------------------------------------------------------------------------------
public class GameLogic {
    static int rounds = 0;
    Player player1;
    Player player2;

    Scanner input = new Scanner(System.in);

    //----------------------------------------------------------------------------------------
    // Method to Represent the players in the game logic
    //----------------------------------------------------------------------------------------
    public GameLogic(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    //----------------------------------------------------------------------------------------
    // Sets the each players item to initiate the game play.
    //----------------------------------------------------------------------------------------
    private void setPlayerItems() {
        player1.setPlayerObjects();
        player2.setPlayerObjects();
        rounds++;
    }

    //----------------------------------------------------------------------------------------
    // Processes the Results of the game.
    //----------------------------------------------------------------------------------------
    public void ProcessRound() {
        setPlayerItems(); // method to make players select their gameObject;

        System.out.println("\nRound " + rounds + " started");
        // Game processing
        if (player1.getPlayerObject() == player2.getPlayerObject()) {
            System.out.println("Game is a draw");
        } else {

            if ((player1.getPlayerObject() == Object.GameObject.ROCK && player2.getPlayerObject() == Object.GameObject.SCISSORS) || (player1.getPlayerObject() == Object.GameObject.PAPER && player2.getPlayerObject() == Object.GameObject.ROCK) || (player1.getPlayerObject() == Object.GameObject.SCISSORS && player2.getPlayerObject() == Object.GameObject.PAPER)) {
                System.out.println("Player 1 wins");
                player1.updateScoreStats(true);
                player2.updateScoreStats(false);
            } else {
                System.out.println(player2.getName() + " wins");
                player2.updateScoreStats(true);
                player1.updateScoreStats(false);
            }

            System.out.println("\n" + player1.getName() + " chooses : " + player1.getPlayerObject() + " whiles " + player2.getName() + " chooses " + player2.getPlayerObject());
        }
        //Prompt the user if he or she wants to see the stats boards
        System.out.println("Please do you want to view the Score Board");
        System.out.println("1. Yes 2. No");
        int ans = input.nextInt();
        input.nextLine();

        if (ans == 1) {
            player1.getScoreStats().printResults();
            System.out.println("\n");
            player2.getScoreStats().printResults();
        }
    }
}
