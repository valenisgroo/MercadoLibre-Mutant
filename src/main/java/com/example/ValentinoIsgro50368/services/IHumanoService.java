package com.example.ValentinoIsgro50368.services;

import com.example.ValentinoIsgro50368.dtos.StatsDTO;

public interface IHumanoService {
    boolean isMutant(String[] dna);
    StatsDTO obtenerEstadisticas();

}
