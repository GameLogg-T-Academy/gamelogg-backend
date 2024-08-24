package com.gamelogg.services;

import com.gamelogg.models.Game;
import com.gamelogg.models.User;
import com.gamelogg.respositories.GameRepository;
import com.gamelogg.respositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GameRepository gameRepository;

    public User getUserById(Long userId) throws Exception {
        return userRepository.findById(userId).orElseThrow(() -> new Exception("User not found"));
    }

    public User addGameToUser(Long userId, Long gameId) throws Exception {
        User user = userRepository.findById(userId).orElseThrow(() -> new Exception("User not found"));
        Game game = gameRepository.findById(gameId).orElseThrow(() -> new Exception("Game not found"));

        if (!user.getGames().contains(game)) {
            user.getGames().add(game);
            userRepository.save(user);
        }

        return user;
    }

    public User removeGameFromUser(Long userId, Long gameId) throws Exception {
        User user = userRepository.findById(userId).orElseThrow(() -> new Exception("User not found"));
        Game game = gameRepository.findById(gameId).orElseThrow(() -> new Exception("Game not found"));

        user.getGames().remove(game);
        userRepository.save(user);

        return user;
    }

    public List<Game> getGamesByUserId(Long userId) {
        return userRepository.findById(userId).orElseThrow(RuntimeException::new).getGames();
    }
}
