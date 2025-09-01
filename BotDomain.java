package src;

import BotConfig.BotConfig;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class BotDomain extends TelegramLongPollingBot {

    static long chatId;
    @Override
    public String getBotUsername() {
        return BotConfig.getBotName();
    }

    @Override
    public String getBotToken() {
        return BotConfig.getBotToken();
    }

    //----------------------------------------------------------------------------------------
    // Bridge between Bot and User.
    //----------------------------------------------------------------------------------------
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
             chatId = update.getMessage().getChatId();

            if (messageText.equals("/start")) startGame();

            if (messageText.equals("/quit")) quitGame();

        }
    }


    //----------------------------------------------------------------------------------------
    // Method to start the game.
    //----------------------------------------------------------------------------------------
    private void startGame() {
        showGameMenu();
    }

    //----------------------------------------------------------------------------------------
    // Method to show the game menu
    //----------------------------------------------------------------------------------------
    private void showGameMenu() {
        //Using an inline keyboard
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();

        //creating rules for each button
        List<InlineKeyboardButton> row1 = new ArrayList<>();
        List<InlineKeyboardButton> row2 = new ArrayList<>();
        List<InlineKeyboardButton> row3 = new ArrayList<>();
        List<InlineKeyboardButton> row4 = new ArrayList<>();


        //Show  game rules button
        InlineKeyboardButton showRulesButton = new InlineKeyboardButton();
        showRulesButton.setText("Show Game Rules");
        showRulesButton.setCallbackData("GAME_RULES");

        //Single Player Mode Button
        InlineKeyboardButton singlePlayerButton = new InlineKeyboardButton();
        singlePlayerButton.setText("Single Player");
        singlePlayerButton.setCallbackData("SINGLE_PLAYER");

        //Multi_Player Mode Button
        InlineKeyboardButton multiPlayerButton = new InlineKeyboardButton();
        multiPlayerButton.setText("Multi Player");
        multiPlayerButton.setCallbackData("MULTI_PLAYER");

        //Quit Button
        InlineKeyboardButton quitButton = new InlineKeyboardButton();
        quitButton.setText("Quit RPS");
        quitButton.setCallbackData("QUIT");

        // Adding buttons to the respective row
        row1.add(showRulesButton);
        row2.add(singlePlayerButton);
        row3.add(multiPlayerButton);
        row4.add(quitButton);

        // Adding rows to the keyboard layout.
        keyboard.add(row1);
        keyboard.add(row2);
        keyboard.add(row3);
        keyboard.add(row4);

        inlineKeyboardMarkup.setKeyboard(keyboard);

        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId)); // The chat ID to send the message to
        message.setText("Choose the game play mode"); // The text of the message

// Attach the inline keyboard to the message
        message.setReplyMarkup(inlineKeyboardMarkup);

// Send the message
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    //----------------------------------------------------------------------------------------
    // Method to quit the game.
    //----------------------------------------------------------------------------------------
    private void quitGame() {

    }
}
