package com.example.ValentinoIsgro50368.repositories;

import com.example.ValentinoIsgro50368.entities.Mutant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface MutantRepository extends BaseRepository<Mutant, Long> {

    Optional<Mutant> findByDna(String[] dna);

    boolean existsByDna(String[] dna);

    long countByIsMutant(boolean isMutant);
}

