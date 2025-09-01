package src;

import BotConfig.BotConfig;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public class BotDomain extends TelegramLongPollingBot {

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
            long chatId = update.getMessage().getChatId();



        }
    }
    //----------------------------------------------------------------------------------------
    // Method to start the game.
    //----------------------------------------------------------------------------------------

}