package com.gamelogg.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "game")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String title;
    private String url;
    private String description;
    private Double price;
    private Integer rating;
    private String genre;
    private LocalDate releaseDate;
    private Boolean favorite;
    private String status;
    private String developer;
    private String publisher;
}
