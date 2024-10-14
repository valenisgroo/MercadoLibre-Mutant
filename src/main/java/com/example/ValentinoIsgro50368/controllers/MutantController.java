package com.example.ValentinoIsgro50368.controllers;

import com.example.ValentinoIsgro50368.entities.Mutant;
import com.example.ValentinoIsgro50368.services.MutantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "mutant")
public class MutantController {

    private final MutantService mutantService;

    public MutantController(MutantService mutantService) {
        this.mutantService = mutantService;
    }

    @PostMapping("/")
    public ResponseEntity<String> isMutant(@RequestBody Mutant mutant) {
        try {
            boolean esMutante = mutantService.isMutant(mutant.getDna());
            if (esMutante) {
                return ResponseEntity.status(HttpStatus.OK).body("Es mutante");
            } else {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("No es mutante");
            }
        } catch (Exception e) {
            if (e.getMessage().equals("El ADN ya existe en la base de datos")) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Error al hacer la solicitud. Este ADN ya está cargado.");
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al hacer la solicitud.");
        }
    }
}
