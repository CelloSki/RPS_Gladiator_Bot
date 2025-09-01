package src;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
//----------------------------------------------------------------------------------------
// Bot to start the bot.
//----------------------------------------------------------------------------------------
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new BotDomain());
            System.out.println("Bot started successfully!");
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

        //----------------------------------------------------------------------------------------
        // Console Implementation of the Rock Paper Scissors Game.
        //----------------------------------------------------------------------------------------

        boolean quit = false;
        printGameMenu();

        while (!quit) {
            System.out.print("\nPlease choose an option( Press 4 to see main menu ): ");
            int option = input.nextInt();
            input.nextLine();

            switch (option) {
                case 1:
                    showGameRules();
                    break;
                case 2:
                    singlePlayerMode();
                    break;
                case 3:
                   multiPlayerMode();
                    break;
                case 4:
                    printGameMenu();
                    break;
                case 5:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
    }

    //----------------------------------------------------------------------------------------
    // Method to engage the multiplayer mode
    //----------------------------------------------------------------------------------------
    private static void multiPlayerMode() {
        System.out.println("Multiplayer Mode is still under development");
    }

    //----------------------------------------------------------------------------------------
    // Method to Print the Game Menu to the User.
    //----------------------------------------------------------------------------------------
    private static void printGameMenu() {
        System.out.println("Press ");
        System.out.print("\n1. Read Game Rules");
        System.out.print("\n2. Single Player Mode");
        System.out.print("\n3. Multiplayer Mode");
        System.out.print("\n4. Print Game List.");
        System.out.print("\n5. Exit");
    }

    //----------------------------------------------------------------------------------------
    // Displays the game rules to the user.
    //----------------------------------------------------------------------------------------a
    private static void showGameRules() {
        System.out.println("\n Rock beats Scissors");
        System.out.println("\n Paper beats Rock");
        System.out.println("\n Scissors beats Paper");
    }

    //----------------------------------------------------------------------------------------
    // This is a method to activate the single game mode for the computer user.
    //----------------------------------------------------------------------------------------
    private static void singlePlayerMode() {
        boolean playAgain = true;
        System.out.println("Please Galant Player, enter your name: ");
        String name = input.nextLine();

        Player player = new Player(name);
        BotPlayer cpu1 = new BotPlayer();

        var singlePlayer = new GameLogic(player, cpu1);
        singlePlayer.ProcessRound();

        while (playAgain) {
            System.out.println("Do you want to play the game again 1.Yes 2. No");
            System.out.println("Answer: ");
            int answer = input.nextInt();
            input.nextLine();
            if (answer == 1) singlePlayer.ProcessRound();
            else break;
        }
    }
}