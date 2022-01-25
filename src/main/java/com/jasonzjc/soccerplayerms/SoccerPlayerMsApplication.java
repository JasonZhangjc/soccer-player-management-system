package com.jasonzjc.soccerplayerms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.jasonzjc.soccerplayerms.entity.Player;
import com.jasonzjc.soccerplayerms.repository.PlayerRepository;


@SpringBootApplication
public class SoccerPlayerMsApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SoccerPlayerMsApplication.class, args);
	}

	@Autowired
	private PlayerRepository playerRepository;

	@Override
	public void run(String... args) throws Exception {}
}
