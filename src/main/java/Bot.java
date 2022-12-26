import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendAudio;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

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
    //

    @Override
    public void onUpdateReceived(Update update) {
        SendAudio sendAudio = new SendAudio();
        sendAudio.setChatId(update.getMessage().getChatId().toString());
        sendAudio.setAudio(new InputFile("CQACAgIAAxkBAAMHY6n4fkE5JtOVgXNnanuQDTvi9mAAAywAAoOOUUmIpocNacshgCwE"));
        sendAudio.setCaption("The best song ever");
        for (int i = 0; i < 3; i++) {
            try {
                execute(sendAudio);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }

    }
}
