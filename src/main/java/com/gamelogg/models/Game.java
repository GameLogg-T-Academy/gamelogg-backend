package com.gamelogg.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "game")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(example = "1")
    private Long id;

    @Column(unique = true)
    @Schema(example = "Monster Hunter World")
    private String title;

    @Schema(example = "http://example.image.jpg")
    private String url;

    @Schema(example = "Description of the game")
    private String description;

    @Schema(example = "99.99")
    private Double price;

    @Schema(example = "4")
    private Integer rating;

    @Schema(example = "Action")
    private String genre;

    @Schema(example = "2018-01-26")
    private LocalDate releaseDate;

    @Schema(example = "true")
    private Boolean favorite;

    @Schema(example = "Playing")
    private String status;

    @Schema(example = "Capcom")
    private String developer;

    @Schema(example = "Capcom")
    private String publisher;

    @JsonIgnore
    @OneToMany(mappedBy = "game")
    private List<UserGame> userGames = new ArrayList<>();
}
