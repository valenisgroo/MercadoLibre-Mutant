package com.example.ValentinoIsgro50368.controllers;

import com.example.ValentinoIsgro50368.dtos.Stats;
import com.example.ValentinoIsgro50368.services.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "stats")

public class StatsController {

    @Autowired
    private StatsService statsService;

    @GetMapping("")
    public ResponseEntity<Stats> getStats(){

        Stats stats = statsService.getStats();
        return ResponseEntity.status(HttpStatus.OK).body(stats);

    }
}

