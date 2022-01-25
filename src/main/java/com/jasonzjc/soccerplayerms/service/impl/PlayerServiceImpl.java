package com.jasonzjc.soccerplayerms.service.impl;

import com.jasonzjc.soccerplayerms.entity.Player;
import com.jasonzjc.soccerplayerms.repository.PlayerRepository;
import com.jasonzjc.soccerplayerms.service.PlayerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {

    private PlayerRepository playerRepository;

    public PlayerServiceImpl(PlayerRepository playerRepository) {
        super(); // can be omitted
        this.playerRepository = playerRepository;
    }

    @Override
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    @Override
    public Player savePlayer(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public Player getPlayerById(Long id) {
        return playerRepository.findById(id).get();
    }

    @Override
    public Player updatePlayer(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public void deletePlayerById(Long id) {
        playerRepository.deleteById(id);
    }
}
