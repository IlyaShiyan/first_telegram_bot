import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendAudio;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class Bot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return "absolutely_music_bot";
    }

    @Override
    public String getBotToken() {
        return "5965103201:AAGiBaElqNQj03FYZuHlgjtK8AruaL5AqeE";
    }

    // Calvin Harris CQACAgIAAxkBAAMHY6n4fkE5JtOVgXNnanuQDTvi9mAAAywAAoOOUUmIpocNacshgCwE
    //Krid CQACAgIAAxkBAAMJY6n4-4-V1O8Ickg3Kp9pk16tSVAAAgQsAAKDjlFJAUNF66patxcsBA
    //Smash CQACAgIAAxkBAAMLY6n5KGHMwgOCOo2CcdiXyY0n0ugAAgYsAAKDjlFJcMWq-c0PfsAsBA
    //Dua lipa CQACAgIAAxkBAAMNY6n5Uc2RAAHVSvgC7gKet0pBdtGiAAIILAACg45RSWLGryAg6q9kLAQ

    @Override
    public void onUpdateReceived(Update update) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(update.getMessage().getChatId().toString());


        KeyboardRow keyboardRow1 = new KeyboardRow();
        keyboardRow1.add(new KeyboardButton("Calvin Harris"));
        keyboardRow1.add(new KeyboardButton("Krid"));

        KeyboardRow keyboardRow2 = new KeyboardRow();
        keyboardRow2.add(new KeyboardButton("Smash"));
        keyboardRow2.add(new KeyboardButton("Dua lipa"));


        List<KeyboardRow> list = new ArrayList<>();
        list.add(keyboardRow1);
        list.add(keyboardRow2);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(list);
        sendMessage.setText(update.getMessage().getText());
        sendMessage.setReplyMarkup(replyKeyboardMarkup);


        SendAudio sendAudio = new SendAudio();
        sendAudio.setChatId(update.getMessage().getChatId().toString());
        InputFile inputFile = new InputFile();

        switch (update.getMessage().getText()) {
            case "Calvin Harris":
                inputFile.setMedia("CQACAgIAAxkBAAMHY6n4fkE5JtOVgXNnanuQDTvi9mAAAywAAoOOUUmIpocNacshgCwE");
                break;
            case "Krid":
                inputFile.setMedia("CQACAgIAAxkBAAMJY6n4-4-V1O8Ickg3Kp9pk16tSVAAAgQsAAKDjlFJAUNF66patxcsBA");
                break;
            case "Smash":
                inputFile.setMedia("CQACAgIAAxkBAAMLY6n5KGHMwgOCOo2CcdiXyY0n0ugAAgYsAAKDjlFJcMWq-c0PfsAsBA");
                break;
            case "Dua lipa":
                inputFile.setMedia("CQACAgIAAxkBAAMNY6n5Uc2RAAHVSvgC7gKet0pBdtGiAAIILAACg45RSWLGryAg6q9kLAQ");
                break;
        }

        sendAudio.setAudio(inputFile);
        try {
            execute(sendAudio);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }


    }
}
