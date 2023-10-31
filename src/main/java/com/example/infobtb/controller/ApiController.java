package com.example.infobtb.controller;

import com.example.infobtb.bot.TelegramBot;
import com.example.infobtb.config.TelegramBotConfig;
import com.example.infobtb.dto.ClientData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    private final TelegramBot telegramBot;
    private final TelegramBotConfig telegramBotConfig;

    @Autowired
    public ApiController(TelegramBot telegramBot, TelegramBotConfig telegramBotConfig) {
        this.telegramBot = telegramBot;
        this.telegramBotConfig = telegramBotConfig;
    }

    @PostMapping("/addClient")
    public void addClient(@RequestBody ClientData clientData) {
        String message = "ФИО клиента: " + clientData.getCliname() + "\n" +
                "Новый контакт: " + clientData.getNewphone() + "\n" +
                "Исполнитель: " + clientData.getTusname();

        String groupChatId = telegramBotConfig.getGroupChatId();

        telegramBot.sendMessageToTelegram(groupChatId, message);
    }

    @PostMapping("/updateClient")
    public void updateClient(@RequestBody ClientData clientData) {
        // Отправить сообщение в Телеграм-бот
        String message = "ФИО клиента: " + clientData.getCliname() + "\n" +
                "Старый контакт: " + clientData.getOldphone() + "\n" +
                "Новый контакт: " + clientData.getNewphone() + "\n" +
                "Исполнитель: " + clientData.getTusname();

        String groupChatId = telegramBotConfig.getGroupChatId();

        telegramBot.sendMessageToTelegram(groupChatId, message);
    }
}


