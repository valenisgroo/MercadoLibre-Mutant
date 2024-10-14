package com.example.ValentinoIsgro50368.services;

import com.example.ValentinoIsgro50368.entities.Mutant;
import com.example.ValentinoIsgro50368.repositories.MutantRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MutantService {

    @Autowired
    private MutantRepository mutantRepository;

    public MutantService(MutantRepository mutantRepository) {
        this.mutantRepository = mutantRepository;
    }

    @Transactional
    public boolean isMutant(String[] dna) throws Exception {

        // Verificar si ya existe un mutante con ese DNA
        if (mutantRepository.existsByDna(dna)) {
            throw new Exception("El ADN ya existe en la base de datos");
        }

        // Crear al mutante y persistirlo en la BD
        Mutant mutant = Mutant.builder().dna(dna).build();
        mutantRepository.save(mutant);
        int cantSecuenciasIguales = contarSecuenciasIguales(dna);

        // Si cantSecuenciasIguales > 1 entonces es mutante
        return cantSecuenciasIguales > 1;
    }

    private int contarSecuenciasIguales(String[] dna) {
        int n = dna.length;
        int cantSecuenciasIguales = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Verificar en horizontal
                if (j + 3 < n && (dna[i].charAt(j) == dna[i].charAt(j + 1)) && (dna[i].charAt(j + 1) == dna[i].charAt(j + 2)) && (dna[i].charAt(j + 2) == dna[i].charAt(j + 3))) {
                    cantSecuenciasIguales++;
                }
                // Verificar en vertical
                if (i + 3 < n && (dna[i].charAt(j) == dna[i + 1].charAt(j)) && (dna[i + 1].charAt(j) == dna[i + 2].charAt(j)) && (dna[i + 2].charAt(j) == dna[i + 3].charAt(j))) {
                    cantSecuenciasIguales++;
                }
                // Verificar diagonal descendente
                if (i + 3 < n && j + 3 < n && (dna[i].charAt(j) == dna[i + 1].charAt(j + 1)) && (dna[i + 1].charAt(j + 1) == dna[i + 2].charAt(j + 2)) && (dna[i + 2].charAt(j + 2) == dna[i + 3].charAt(j + 3))) {
                    cantSecuenciasIguales++;
                }
                // Verificar diagonal ascendente
                if (i - 3 >= 0 && j + 3 < n && (dna[i - 3].charAt(j + 3) == dna[i - 2].charAt(j + 2)) && (dna[i - 2].charAt(j + 2) == dna[i - 1].charAt(j + 1)) && (dna[i - 1].charAt(j + 1) == dna[i].charAt(j))) {
                    cantSecuenciasIguales++;
                }
            }
        }
        return cantSecuenciasIguales;
    }
}
