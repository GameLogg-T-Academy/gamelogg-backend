package com.gamelogg.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "platform_game")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlatformGame {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "platform_id")
    private Platform platform;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;
}
