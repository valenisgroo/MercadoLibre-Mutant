package com.example.ValentinoIsgro50368.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "mutant")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder

public class Mutant implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "is_mutant")
    private boolean isMutant;

    @ElementCollection
    @Column(name = "dna", unique = true)
    private String[] dna;
}
