package com.example.marketplace.controller;

import com.example.marketplace.dto.UserProfile;
import com.example.marketplace.repository.UserRepository;
import com.example.marketplace.repository.entity.UserEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/user/profile")
    public ResponseEntity<UserProfile> userInfo() {
        Optional<UserProfile> profile = getUserProfile(1L);
        return profile.map(userProfile -> new ResponseEntity<>(userProfile, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(new UserProfile(), HttpStatus.NOT_FOUND));
    }

    @GetMapping("/profile/{userId}")
    public ResponseEntity<UserProfile> userInfo(@PathVariable Long userId) {
        if (userId == null) {
            new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        Optional<UserProfile> profile = getUserProfile(userId);
        return profile.map(userProfile -> new ResponseEntity<>(userProfile, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(new UserProfile(), HttpStatus.NOT_FOUND));
    }

    private Optional<UserProfile> getUserProfile(Long userId) {
        Optional<UserEntity> entity = userRepository.findById(userId);
        return entity
                .map(e -> new UserProfile(e.getId(), e.getLogin(), null, e.getFullName(), e.getEmail()));
    }
}
