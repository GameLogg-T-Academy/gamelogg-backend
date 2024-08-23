package com.gamelogg.services;

import com.gamelogg.models.Game;
import com.gamelogg.respositories.GameRepository;
import com.gamelogg.specifications.GameSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public Page<Game> findGames(Integer pageNumber, Integer pageSize, String title, String status, Boolean favorite,
            String developer, String publisher, Integer releaseYear) {
        Specification<Game> spec = Specification
                .where(GameSpecification.hasTitle(title))
                .and(GameSpecification.hasStatus(status))
                .and(GameSpecification.isFavorite(favorite))
                .and(GameSpecification.hasDeveloper(developer))
                .and(GameSpecification.hasPublisher(publisher))
                .and(GameSpecification.hasReleaseYear(releaseYear));

        Pageable pageable = PageRequest.of(pageNumber, pageSize);

        return gameRepository.findAll(spec, pageable);
    }

    public Game findGame(Long id) {
        return gameRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public Game saveGame(Game game) {
        return gameRepository.save(game);
    }

    public void deleteGame(Long id) {
        Game game = gameRepository.findById(id).orElseThrow(RuntimeException::new);
        gameRepository.delete(game);
    }
}

