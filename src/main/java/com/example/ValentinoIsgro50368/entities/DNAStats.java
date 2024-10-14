package com.example.ValentinoIsgro50368.entities;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class DNAStats {

    private long countMutantDna;
    private long countHumanDna;

    // Metodo para obtener el ratio entre mutantes y humanos
    public float getRatio() {
        if (countHumanDna == 0) {
            return 0;
        }
        return (float) countMutantDna / countHumanDna;
    }

    // Metodo para incrementar el contador de mutantes
    public void incrementMutantCount() {
        this.countMutantDna++;
    }

    // Metodo para incrementar el contador de humanos
    public void incrementHumanCount() {
        this.countHumanDna++;
    }
}
