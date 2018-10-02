package my_bot;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.text.SimpleDateFormat;
import java.util.*;

public class TGBot extends TelegramLongPollingBot implements Runnable {

    private AnswerGenerator solver;

    public void run(){
        TelegramBotsApi botApi = new TelegramBotsApi();
        try {
            botApi.registerBot(new TGBot(this.solver));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    TGBot(AnswerGenerator generator){
        this.solver = generator;
    }

    public void onUpdateReceived(Update update){
        Message message = update.getMessage();
        if (message != null && message.hasText()){
            sendMsg(message, solver.GetAnswer(message.getText()));
        }
    }

    private void sendMsg(Message message, String text){
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setText(text);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public String getBotUsername() {
        return "UrFU Ft-202";
    }

    public String getBotToken() {
        return "616457548:AAEOiC4COqi8epMpNz9q-GhHx69hSPsiQFk";
    }
}
