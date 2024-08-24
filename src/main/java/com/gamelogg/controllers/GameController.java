package com.gamelogg.controllers;

import com.gamelogg.models.Game;
import com.gamelogg.services.GameService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/games")
@Tag(name = "Games")
public class GameController {

    @Autowired
    private GameService gameService;

    @Operation(summary = "Get list of games")
    @GetMapping
    public ResponseEntity<Page<Game>> getGames(
            @RequestParam(value = "pageNumber", defaultValue = "0") Integer pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "status", required = false) String status,
            @RequestParam(value = "maxPrice", required = false) Double maxPrice,
            @RequestParam(value = "favorite", required = false) Boolean favorite,
            @RequestParam(value = "developer", required = false) String developer,
            @RequestParam(value = "publisher", required = false) String publisher,
            @RequestParam(value = "releaseYear", required = false) Integer releaseYear
    ) {

        Page<Game> games = gameService.findGames(pageNumber, pageSize, title, status,
                maxPrice, favorite, developer, publisher, releaseYear);

        return new ResponseEntity<>(games, HttpStatus.OK);
    }

    @Operation(summary = "Get game by ID")
    @GetMapping("/{id}")
    public ResponseEntity<Game> getGame(@PathVariable(value = "id") Long id) throws Exception {
        Game game = gameService.findGame(id);
        return new ResponseEntity<>(game, HttpStatus.OK);
    }

    @Operation(summary = "Add new game")
    @PostMapping
    public ResponseEntity<Game> createGame(@RequestBody Game game) {
        Game createdGame = gameService.saveGame(game);
        return new ResponseEntity<>(createdGame, HttpStatus.CREATED);
    }

    @Operation(summary = "Update game")
    @PutMapping("/{id}")
    public ResponseEntity<Game> updateGame(@PathVariable Long id, @RequestBody Game game) {
        game.setId(id);
        Game updatedGame = gameService.saveGame(game);
        return new ResponseEntity<>(updatedGame, HttpStatus.OK);
    }

    @Operation(summary = "Remove game")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGame(@PathVariable Long id) throws Exception {
        gameService.deleteGame(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
