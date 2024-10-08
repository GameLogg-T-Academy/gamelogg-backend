package com.gamelogg.services;

import com.gamelogg.dtos.UserGameDTO;
import com.gamelogg.models.Game;
import com.gamelogg.models.User;
import com.gamelogg.models.UserGame;
import com.gamelogg.models.UserGameId;
import com.gamelogg.respositories.UserGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserGameService {

    @Autowired
    private UserGameRepository userGameRepository;

    public List<UserGame> findUserGames(Long userId, String status, Boolean isFavorite) {
        Specification<UserGame> spec = Specification
                .where(((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("user").get("id"), userId)));

        if (status != null) {
            spec = spec.and((root, query, criteriaBuilder) -> criteriaBuilder.equal(criteriaBuilder.lower(root.get("status")), status.toLowerCase()));
        }

        if (isFavorite != null) {
            spec = spec.and((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("isFavorite"), isFavorite));
        }

        return userGameRepository.findAll(spec);
    }

    public UserGame findUserGameByUserIdAndGameId(Long userId, Long gameId) throws Exception {
        UserGameId userGameId = new UserGameId(userId, gameId);
        return userGameRepository.findById(userGameId).orElseThrow(() -> new Exception("Relation not found"));
    }

    public UserGame saveUserGame(User user, Game game, UserGameDTO userGameDTO) {
        UserGameId userGameId = new UserGameId(user.getId(), game.getId());
        UserGame userGame = new UserGame();
        userGame.setId(userGameId);
        userGame.setUser(user);
        userGame.setGame(game);
        userGame.setStatus(userGameDTO.status());
        userGame.setIsFavorite(userGameDTO.isFavorite());
        return userGameRepository.save(userGame);
    }

    public void removeUserGame(Long userId, Long gameId) throws Exception {
        UserGameId userGameId = new UserGameId(userId, gameId);
        UserGame userGame = userGameRepository.findById(userGameId).orElseThrow(() -> new Exception("User-game association not found"));
        userGameRepository.delete(userGame);
    }
}