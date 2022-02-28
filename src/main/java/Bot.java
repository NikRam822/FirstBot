
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;



public class Bot extends TelegramLongPollingBot {
    public static void main(String[] args) {

        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try{
            telegramBotsApi.registerBot(new Bot());
        } catch (TelegramApiRequestException e){
            e.printStackTrace();
        }
    }


 public void sendMsg(Message message, String text ) {

    SendMessage sendMessage = new SendMessage();
    sendMessage.enableMarkdown(true);
    sendMessage.setChatId(message.getChatId().toString());
    sendMessage.setReplyToMessageId(message.getMessageId());
    sendMessage.setText(text);
     try {
         execute(sendMessage);
     } catch (TelegramApiException e){
         e.printStackTrace();
     }
    }



    public int i= 0;

    public int c=0;
    public void onUpdateReceived(Update update)  {  //метод для приема сообщений


        Message message = update.getMessage();
        if (message !=null && message.hasText()) {

                switch (message.getText()){

                    case "/start":
                        i=0;
                                c=0;
                        sendMsg(message, "привет , как тебя зовут ? "
                                );
                        // x=x+1;
                        break;
                    case "2003":
                        sendMsg(message, "Спасибо тебе за то , что ты есть <3   ");
                        //  x=x+1;
                        break;

                    case "Паша":
                        sendMsg(message, "привет ,Пашон. Я первый бот Никиты , меня зовут SashBashBot . Пока что , я ничего не умею , но Никита попросил напомнить тебе , что , после того , как чека выдернута из гранаты - граната нам больше не друг \n если захочешь поиграть напиши : /game");
                        // x=x+1;
                        break;
                    case "Настя":
                        sendMsg(message, "привет ,Настя . Я первый бот Никиты , меня зовут SashBashBot . Пока что , я ничего не умею , но могу расскать анекдот .   Помни , что если ты всегда падаешь и поднимаешься , то скорее всего , ты косинусоида \n если захочешь поиграть напиши : /game");
                        break;

                    case "Рустам":
                        sendMsg(message, "привет ,Рустам . Я первый бот Никиты , меня зовут SashBashBot . Пока что , я ничего не умею , но могу расскать анекдот .   У мальчика у которого минус четыре на одном глазе и плюс четыре на другом, на переносице начало координат. \n если захочешь поиграть напиши : /game");
                        break;
                    case "Варя":
                        sendMsg(message, "привет ,Варя  . Я первый бот Никиты , меня зовут SashBashBot . Пока что , я ничего не умею , но могу расскать анекдот .   Помни , что если ты всегда падаешь и поднимаешься , то скорее всего , ты косинусоида. \n если захочешь поиграть напиши : /game");
                        break;

                    case "Лера":
                        sendMsg(message, "привет ,Лера  . Я первый бот Никиты , меня зовут SashBashBot . Пока что , я ничего не умею , но могу расскать анекдот \n  — Пойдем от противного, — сказал математик физику, и они отошли от профессора философии в розовой кофточке. \n если захочешь поиграть напиши : /game");
                        break;

                    case "/game":
                        sendMsg(message, "Педлагаю сыграть в игру. Только , чур , играем честно .\n Загадай число от 0 до 5 .\n После того , как загадаешь отправь мне символ : ?\n я поробую угадать твое число . \n если надоест играть - напиши мне /exit \n \n И тааак. Поехали! ");


                        break;

                        case "?":
                            int x = (int) (Math.random() * 6);
                            sendMsg(message, "Ты загадал число: " + x + "? Напиши 1 , Если это так и 0 , если не так. \n для продолжения введи : ? \n для выхода введи: /exit ");

                            break;

                        case "0":
                            i = i + 1;
                            sendMsg(message, "Поздравляю с победой. Общий счет: ты - " + i + " : я - " + c+ "\n для продолжения введи : ? \n для выхода введи: /exit");
                            break;

                        case "1":
                            c = c + 1;
                            sendMsg(message, " Ура , я угадал! Общий счет: ты - " + i + " : я - " + c +"\n для продолжения введи : ? \n для выхода введи: /exit"  );
                            break;
                    case "/exit":
                        sendMsg(message, " Спасибо за игру ! Наш счет: ты - " + i + " : я - " + c);
                        i=0;
                        c=0;

                        break;



                default:
                    if( message !=null && message.getText()!="/game" && message.hasText()){sendMsg(message,"привет, " + message.getText()+"! Меня зовут SashBashBot . Пока что , я ничего не умею , но могу рассказть анекдот .\n — Какова сумма углов в треугольнике?\n" +
                            "— Три?\n" +
                            "— Хм-м-м… И ведь не поспоришь…\n\n\n если захочешь поиграть напиши : /game"); };

                    if(message.getText() == "/game") {
                        sendMsg(message,"для ");
                        while(message.getText()!="/exit") {
                            message = update.getMessage();
                            sendMsg(message,"для выхода введите /exit");
                        }

                    }
                }


        }
    }

    public String getBotUsername() {
        return "SashBashBot";
    }

    public String getBotToken() {
        return "***";
    }
}
