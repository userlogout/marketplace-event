package com.example.marketplace.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/point")
public class PointController {

    @GetMapping("/info")
    public List<String> getPointInfo() {
        return generateStringList();
    }

    private List<String> generateStringList() {
        return List.of("Pointname 1", "Point address 2");
    }

    @GetMapping("/goods")
    public List<String> getGooodsList() {
        return generateStringList();
    }
}

