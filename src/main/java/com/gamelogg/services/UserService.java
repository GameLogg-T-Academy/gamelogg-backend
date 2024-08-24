package com.gamelogg.services;

import com.gamelogg.models.Game;
import com.gamelogg.models.User;
import com.gamelogg.respositories.GameRepository;
import com.gamelogg.respositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findUser(Long userId) throws Exception {
        return userRepository.findById(userId).orElseThrow(() -> new Exception("User not found"));
    }
}
