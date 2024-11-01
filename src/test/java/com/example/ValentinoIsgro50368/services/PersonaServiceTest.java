package com.example.ValentinoIsgro50368.services;

import com.example.ValentinoIsgro50368.exceptions.InvalidDnaException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PersonaServiceTest {

    @Autowired
    private PersonaService personaService;

    //Test vertical
    @Test
    public void testVertical() throws Exception {
        String[] dna = {
                "ATGCTA",
                "AACCTC",
                "ATACTT",
                "AGACTG",
                "CCTGTA",
                "TCACTG"
        };
        assertTrue(personaService.isMutant(dna));
    }

    //Test horizontal
    @Test
    public void testHorizontal() throws Exception {
        String[] dna = {
                "TTTTAA",
                "CCGTGC",
                "TTATGT",
                "AGATGG",
                "GGGGTA",
                "TTACTG"
        };
        assertTrue(personaService.isMutant(dna));
    }

    //Test diagonales descendentes
    @Test
    public void testDiagonal1() throws Exception {
        String[] dna = {
                "ACGCGA",
                "CACTGC",
                "TTACGT",
                "AGAACG",
                "CCGCTA",
                "TCACTG"
        };
        assertTrue(personaService.isMutant(dna));
    }

    //Test diagonales ascendentes
    @Test
    public void testDiagonal2() throws Exception {
        String[] dna = {
                "ATGCGC",
                "CATTCG",
                "TTACGT",
                "AGCGTG",
                "CTGCTA",
                "TCACTG"
        };
        assertTrue(personaService.isMutant(dna));
    }

    //Test NO mutante
    @Test
    public void testNoMutant() throws Exception  {
        String[] dna = {
                "ATGCGA",
                "CGTTAC",
                "TTAGCT",
                "AGAATG",
                "CTCCTA",
                "TCACTG"
        };
        assertFalse(personaService.isMutant(dna));
    }

    //Pruebas UTN
    //MUTANTE
    @Test
    public void test1() throws Exception{
        String[] dna = {
                "AAAA",
                "CCCC",
                "TCAG",
                "GGTC"
        };
        assertTrue(personaService.isMutant(dna));
    }

    //MUTANTE
    @Test
    public void test2() throws Exception{
        String[] dna = {
                "TGAC",
                "AGCC",
                "TGAC",
                "GGTC"
        };
        assertTrue(personaService.isMutant(dna));
    }

    //NO MUTANTE
    @Test
    public void test3() throws Exception{
        String[] dna = {
                "AAAT",
                "AACC",
                "AAAC",
                "CGGG"
        };
        assertFalse(personaService.isMutant(dna));
    }

    //NO MUTANTE
    @Test
    public void test4() throws Exception{
        String[] dna = {
                "AAAA",
                "AAAA",
                "AAAA",
                "AAAA"
        };
        assertFalse(personaService.isMutant(dna));
    }

    //NO MUTANTE
    @Test
    public void test5() throws Exception{
        String[] dna = {
                "TGAC",
                "ATCC",
                "TAAC",
                "GGTC"
        };
        assertFalse(personaService.isMutant(dna));
    }

    //MUTANTE
    @Test
    public void test6() throws Exception{
        String[] dna = {
                "TCGGGTGAT",
                "TGATCCTTT",
                "TACGAGTGA",
                "AAATGTACG",
                "ACGAGTGCT",
                "AGACACATG",
                "GAATTCCAA",
                "ACTACGACC",
                "TGAGTATCC"
        };
        assertTrue(personaService.isMutant(dna));
    }

    //MUTANTE
    @Test
    public void test7() throws Exception{
        String[] dna = {
                "TTTTTTTTT",
                "TTTTTTTTT",
                "TTTTTTTTT",
                "TTTTTTTTT",
                "CCGACCAGT",
                "GGCACTCCA",
                "AGGACACTA",
                "CAAAGGCAT",
                "GCAGTCCCC"

        };
        assertTrue(personaService.isMutant(dna));
    }


    @Test
    public void testDnaNull() {
        String[] dna = null;
        InvalidDnaException exception = assertThrows(InvalidDnaException.class, () -> {
            personaService.isMutant(dna);
        });
        assertEquals("El DNA no puede ser null.", exception.getMessage());
    }

    @Test
    public void testDnaEmpty() {
        String[] dna = {};
        InvalidDnaException exception = assertThrows(InvalidDnaException.class, () -> {
            personaService.isMutant(dna);
        });
        assertEquals("El DNA no puede estar vacío.", exception.getMessage());
    }

    @Test
    public void testContainsNull() {
        String[] dna = {
                "CTA",
                null,
                "ACC"
        };
        InvalidDnaException exception = assertThrows(InvalidDnaException.class, () -> {
            personaService.isMutant(dna);
        });
        assertEquals("El DNA no puede contener un NULL.", exception.getMessage());
    }

    @Test
    public void testSizeDna() {
        String[] dna = {
                "AAAA",
                "AAAC",
                "CCCT"
        };
        InvalidDnaException exception = assertThrows(InvalidDnaException.class, () -> {
            personaService.isMutant(dna);
        });
        assertEquals("El DNA debe ser una matriz cuadrada.", exception.getMessage());
    }

    @Test
    public void testInvalidadCharacters() {
        String[] dna = {
                "ZCC",
                "GGG",
                "TTT",
        };
        InvalidDnaException exception = assertThrows(InvalidDnaException.class, () -> {
            personaService.isMutant(dna);
        });
        assertEquals("El DNA solo puede contener las letras A, C, G y T.", exception.getMessage());
    }
}




