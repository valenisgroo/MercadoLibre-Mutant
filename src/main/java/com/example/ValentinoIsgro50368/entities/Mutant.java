package com.example.ValentinoIsgro50368.entities;

import jakarta.persistence.*;  // Asegúrate de que esta es la importación correcta
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "mutant") // El nombre de la tabla puede ser diferente
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Mutant implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "is_mutant")
    private boolean isMutant;

    @ElementCollection // Si tienes un array de ADN, considera esta anotación
    @Column(name = "dna", unique = true)
    private String[] dna; // Campo para almacenar el ADN
}
