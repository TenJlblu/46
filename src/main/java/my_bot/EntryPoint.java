package my_bot;

import org.telegram.telegrambots.ApiContextInitializer;

public class EntryPoint {
    public static void main(String[] args){
        AnswerGeneratorInterface generator = new AnswerGenerator();
        ApiContextInitializer.init();
        TGBot telegramBot = new TGBot(generator);
        CMDBot cmdBot = new CMDBot(generator);
        JThread tgThread = new JThread("Telegram bot", telegramBot);
        JThread cmdThread = new JThread("Cmd bot", cmdBot);
    }
}
