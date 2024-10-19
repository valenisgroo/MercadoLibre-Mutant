package com.example.ValentinoIsgro50368.controllers;

import com.example.ValentinoIsgro50368.dtos.DNAStats;
import com.example.ValentinoIsgro50368.services.StatsService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "stats")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StatsController {

    @Autowired
    private StatsService statsService;

    @GetMapping("")
    public DNAStats getStats() {
        return statsService.getStats();
    }
}
