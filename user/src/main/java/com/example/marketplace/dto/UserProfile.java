package com.example.marketplace.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserProfile {

    private Long userId;
    private String login;
    private String password;
    private String name;
    private String email;
}
