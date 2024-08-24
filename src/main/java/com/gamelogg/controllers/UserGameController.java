package com.gamelogg.controllers;

import com.gamelogg.dtos.UserGameDTO;
import com.gamelogg.models.Game;
import com.gamelogg.models.User;
import com.gamelogg.models.UserGame;
import com.gamelogg.services.GameService;
import com.gamelogg.services.UserGameService;
import com.gamelogg.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Tag(name = "User games")
@RequestMapping("/users/{userId}")
public class UserGameController {

    @Autowired
    private UserService userService;

    @Autowired
    private GameService gameService;

    @Autowired
    private UserGameService userGameService;


    @Operation(summary = "Get list of games by user")
    @GetMapping("/games")
    public ResponseEntity<List<UserGame>> getGamesByUserId(
            @PathVariable Long userId,
            @RequestParam(required = false) Boolean isFavorite) throws Exception {
        return ResponseEntity.ok(userGameService.getUserGames(userId, isFavorite));
    }

    @Operation(summary = "Associate game with user")
    @PostMapping("/games/{gameId}")
    public ResponseEntity<UserGame> addGameToUser(@PathVariable Long userId,
            @PathVariable Long gameId,
            @RequestBody UserGameDTO userGameDTO) throws Exception {
        User user = userService.findUser(userId);
        Game game = gameService.findGame(gameId);
        return ResponseEntity.ok(userGameService.saveUserGame(user, game, userGameDTO.isFavorite()));
    }

    @Operation(summary = "Update favorite status in user-game relation")
    @PutMapping("/games/{gameId}")
    public ResponseEntity<UserGame> updateUserGame(@PathVariable Long userId,
            @PathVariable Long gameId,
            @RequestBody UserGameDTO userGameDTO) throws Exception {
        User user = userService.findUser(userId);
        Game game = gameService.findGame(gameId);
        return ResponseEntity.ok(userGameService.saveUserGame(user, game, userGameDTO.isFavorite()));
    }

    @Operation(summary = "Remove association between game and user")
    @DeleteMapping("/games/{gameId}")
    public ResponseEntity<Map<String, String>> deleteGameFromUser(@PathVariable Long userId, @PathVariable Long gameId) throws Exception {
        Map<String, String> responseMsg = new HashMap<>();
        responseMsg.put("status", "success");
        userGameService.removeUserGame(userId, gameId);
        return ResponseEntity.ok(responseMsg);
    }
}
