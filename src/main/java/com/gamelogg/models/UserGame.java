package com.gamelogg.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user_game")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserGame {

    @EmbeddedId
    @JsonIgnore
    private UserGameId id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @MapsId("gameId")
    @JoinColumn(name = "game_id")
    private Game game;

    private Boolean isFavorite = false;

    private String status = "Not started";
}
