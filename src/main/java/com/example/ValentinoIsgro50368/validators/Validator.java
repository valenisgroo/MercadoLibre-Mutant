package com.example.ValentinoIsgro50368.validators;

public class Validator {

    public static boolean validarDNA(String[] dna) {
        if (dna == null) {
            return false; //Array null
        }

        int N = dna.length;

        if (N == 0) {
            return false;
        }

        for (String cadena : dna) {
            if (cadena == null || cadena.length() != N) {
                return false;
            }

            for (char letra : cadena.toCharArray()) {
                if ("ATCG".indexOf(letra) == -1) {
                    return false; // Letras no permitidas encontradas
                }
            }
        }

        return true; // El ADN es válido
    }
}

