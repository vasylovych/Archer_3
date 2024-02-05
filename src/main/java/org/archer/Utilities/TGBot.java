package org.archer.Utilities;


import com.pengrad.telegrambot.Callback;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;

import java.io.IOException;

import static org.archer.Utilities.CommonMethods.getTimestampInMinutes;

public class TGBot {

    private TelegramBot bot;
    private static String apiToken;
    static boolean flag = true;

    public TGBot(String apiToken) {
        bot = new TelegramBot(apiToken);
    }

    public static String getToken() {
        return apiToken;
    }


    public void start() {
        bot.setUpdatesListener(updates -> {
            System.out.println("Update pulled :" +getTimestampInMinutes());
            for (Update update : updates) {
                if (!flag) {
                    Driver.tearDown();
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.exit(0);
                }
                if (update.message() != null) {
                    flag = handleMessage(update);
                }
            }
            return UpdatesListener.CONFIRMED_UPDATES_ALL;

        });
    }

    public boolean handleMessage(Update update) {
        boolean flag = true;
        long chatId = update.message().chat().id();
        String text = update.message().text();
        if (text.equalsIgnoreCase("close")) {
            sendMessage(chatId, "Archer App is closing!");
            flag = false;

        }
        System.out.println("text :" + text);
        return flag;
    }
    public void sendMessage(long chatId, String text) {
        SendMessage request = new SendMessage(chatId, text);
        bot.execute(request, new Callback<SendMessage, SendResponse>() {
            @Override
            public void onResponse(SendMessage request, SendResponse response) {
                System.out.println("message sent " + response.message().text());
            }

            @Override
            public void onFailure(SendMessage request, IOException e) {
                e.printStackTrace();
            }
        });
    }


}
