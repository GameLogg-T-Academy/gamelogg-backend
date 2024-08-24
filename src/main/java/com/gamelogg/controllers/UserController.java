package com.gamelogg.controllers;

import com.gamelogg.dtos.UserGameRequest;
import com.gamelogg.models.Game;
import com.gamelogg.models.User;
import com.gamelogg.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Tag(name = "Users")
public class UserController {

    @Autowired
    private UserService userService;

    @Operation(summary = "Get user data")
    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId) throws Exception {
        return ResponseEntity.ok(userService.getUserById(userId));
    }

    @Operation(summary = "Get list of games by user")
    @GetMapping("/{userId}/games")
    public ResponseEntity<List<Game>> getGamesByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.getGamesByUserId(userId));
    }

    @Operation(summary = "Associate game with user")
    @PostMapping("/{userId}/games")
    public ResponseEntity<User> addGameToUser(@PathVariable Long userId, @RequestBody UserGameRequest userGameRequest) throws Exception {
        return ResponseEntity.ok(userService.addGameToUser(userId, userGameRequest.gameId()));
    }

    @Operation(summary = "Remove association between game and user")
    @DeleteMapping("/{userId}/games/{gameId}")
    public ResponseEntity<User> deleteGameFromUser(@PathVariable Long userId, @PathVariable Long gameId) throws Exception {
        return ResponseEntity.ok(userService.removeGameFromUser(userId, gameId));
    }
}
