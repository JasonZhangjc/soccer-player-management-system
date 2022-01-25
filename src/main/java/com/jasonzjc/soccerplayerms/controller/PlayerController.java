package com.jasonzjc.soccerplayerms.controller;

import com.jasonzjc.soccerplayerms.entity.Player;
import com.jasonzjc.soccerplayerms.service.PlayerService;
import com.jasonzjc.soccerplayerms.entity.Player;
import com.jasonzjc.soccerplayerms.service.PlayerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PlayerController {

    private PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    // handler method to handle list students and return model and view
    @GetMapping("/players")
    public String listPlayers(Model model) {
        model.addAttribute("players", playerService.getAllPlayers());
        return "players";
    }

    @GetMapping("/players/new")
    public String createPlayerForm(Model model) {
        // create player object to store player form data
        Player player = new Player();
        model.addAttribute("player", player);
        return "create_player";
    }

    @PostMapping("/players")
    public String savePlayer(@ModelAttribute("player") Player player) {
        playerService.savePlayer(player);
        return "redirect:/players";
    }

    @GetMapping("/players/edit/{id}")
    public String editPlayerForm(@PathVariable Long id, Model model) {
        model.addAttribute("player", playerService.getPlayerById(id));
        return "edit_player";
    }

    @PostMapping("/players/{id}")
    public String updatePlayer(@PathVariable Long id,
                                @ ModelAttribute("player") Player player, Model model) {

        // get player from database by id
        Player existingPlayer= playerService.getPlayerById(id);
        existingPlayer.setId(id);
        existingPlayer.setFirstName(player.getFirstName());
        existingPlayer.setLastName(player.getLastName());
        existingPlayer.setCountry(player.getCountry());
        existingPlayer.setClub(player.getClub());
        existingPlayer.setPosition(player.getPosition());

        // save updated player object
        playerService.updatePlayer(existingPlayer);
        return "redirect:/players";
    }

    // handler method to handle delete player request
    @GetMapping("/players/{id}")
    public String deletePlayer(@PathVariable Long id) {
        playerService.deletePlayerById(id);
        return "redirect:/players";
    }

}
