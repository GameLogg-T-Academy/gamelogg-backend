package com.gamelogg.controllers;

import com.gamelogg.dtos.UserGameRequest;
import com.gamelogg.models.Game;
import com.gamelogg.models.User;
import com.gamelogg.services.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
@Tag(name = "Users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.getUserById(userId));
    }

    @GetMapping("/{userId}/games")
    public ResponseEntity<List<Game>> getGamesByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.getGamesByUserId(userId));
    }

    @PostMapping("/{userId}/games")
    public ResponseEntity<User> addGameToUser(@PathVariable Long userId, @RequestBody UserGameRequest userGameRequest) {
        return ResponseEntity.ok(userService.addGameToUser(userId, userGameRequest.gameId()));
    }

    @DeleteMapping("/{userId}/games/{gameId}")
    public ResponseEntity<User> deleteGameFromUser(@PathVariable Long userId, @PathVariable Long gameId) {
        return ResponseEntity.ok(userService.removeGameFromUser(userId, gameId));
    }
}
