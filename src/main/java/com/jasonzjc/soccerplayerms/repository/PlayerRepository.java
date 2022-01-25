package com.jasonzjc.soccerplayerms.repository;

import com.jasonzjc.soccerplayerms.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
