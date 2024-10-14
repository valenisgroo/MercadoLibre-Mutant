package com.example.ValentinoIsgro50368.services;

import com.example.ValentinoIsgro50368.entities.DNAStats;
import com.example.ValentinoIsgro50368.repositories.MutantRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StatsService {

    @Autowired
    private MutantRepository mutantRepository;

    public DNAStats getStats() {
        long countMutantDna = mutantRepository.countByIsMutant(true);
        long countHumanDna = mutantRepository.countByIsMutant(false);
        return DNAStats.builder()
                .countMutantDna(countMutantDna)
                .countHumanDna(countHumanDna)
                .build();
    }
}
