package com.example.infobtb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.infobtb.bot.TelegramBot;

@SpringBootApplication
public class InfoBtbApplication {

	@Autowired
	private TelegramBot telegramBot;

	public static void main(String[] args) {
		SpringApplication.run(InfoBtbApplication.class, args);
	}
}
