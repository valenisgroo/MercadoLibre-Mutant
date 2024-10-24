package com.example.ValentinoIsgro50368.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PersonaServiceTest {

    @Autowired
    private PersonaService personaService;

    @Test
    public void testVertical() throws Exception {
        String[] dna = {
                "ATGCGA",
                "AAGCGC",
                "ATACGT",
                "AGACGG",
                "CCTGTA",
                "TCACTG"
        };
        assertTrue(personaService.isMutant(dna));
    }

    @Test
    public void testHorizontal() throws Exception {
        String[] dna = {
                "AAAAGA",
                "CAGTGC",
                "TTATGT",
                "AGATGG",
                "CCCCTA",
                "TCACTG"
        };
        assertTrue(personaService.isMutant(dna));
    }

    @Test
    public void testAscendingDiagonal() throws Exception {
        String[] dna = {
                "ATGCGA",
                "CATTAC",
                "TTAACT",
                "AGACTG",
                "CTCCTA",
                "TCACTG"
        };
        assertTrue(personaService.isMutant(dna));
    }

    @Test
    public void testDescendingDiagonal() throws Exception {
        String[] dna = {
                "ATGCGA",
                "CATTGC",
                "TTATGT",
                "AGAATG",
                "CCGCTA",
                "TCACTG"
        };
        assertTrue(personaService.isMutant(dna));
    }

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

    @Test
    public void test4() throws Exception{
        String[] dna = {
                "TGAC",
                "ATCC",
                "TAAC",
                "GGTC"
        };
        assertFalse(personaService.isMutant(dna));
    }

    @Test
    public void test5() throws Exception{
        String[] dna = {
                "AAAA",
                "AAAA",
                "AAAA",
                "AAAA"
        };
        assertFalse(personaService.isMutant(dna));
    }

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
}

