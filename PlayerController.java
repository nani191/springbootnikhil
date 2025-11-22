/*
 * 
 * You can use the following import statements
 * 
 * import org.springframework.web.bind.annotation.*;
 * import java.util.*;
 * import org.springframework.beans.factory.annotation.Autowired;
 * 
 */

package com.example.player.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

import com.example.player.model.Player;
import com.example.player.service.PlayerJpaService;

@RestController
public class PlayerController {

    @Autowired
    private PlayerJpaService playerService;

    // API 1: Get all players
    @GetMapping("/players")
    public List<Player> getPlayers() {
        return playerService.getPlayers();
    }

    // API 2: Get player by ID
    @GetMapping("/players/{playerId}")
    public Player getPlayerById(@PathVariable("playerId") int playerId) {
        return playerService.getPlayerById(playerId);
    }

    // API 3: Add single player
    @PostMapping("/players")
    public Player addPlayer(@RequestBody Player player) {
        return playerService.addPlayer(player);
    }

    // API 4: Update player
    @PutMapping("/players/{playerId}")
    public Player updatePlayer(@PathVariable("playerId") int playerId,
                               @RequestBody Player player) {
        return playerService.updatePlayer(playerId, player);
    }

    // API 5: Delete player
    @DeleteMapping("/players/{playerId}")
    public void deletePlayer(@PathVariable("playerId") int playerId) {
        playerService.deletePlayer(playerId);
    }
}
