package com.gamelogg.controllers;

import com.gamelogg.models.User;
import com.gamelogg.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Tag(name = "Users")
public class UserController {

    @Autowired
    private UserService userService;

    @Operation(summary = "Get user data")
    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId) throws Exception {
        return ResponseEntity.ok(userService.findUser(userId));
    }

}
