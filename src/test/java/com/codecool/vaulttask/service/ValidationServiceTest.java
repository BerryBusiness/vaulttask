package com.codecool.vaulttask.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidationServiceTest {

    private final ValidationService validationService = new ValidationService();

    @Test
    void isValidPassphrase() {
        assertTrue(validationService.isValidPassphrase("hello world!"));
    }

    @Test
    void testInvalidPassphraseNoPunctuation() {
        assertFalse(validationService.isValidPassphrase("hello world"));
    }

    @Test
    void testEmptyString(){
        assertFalse(validationService.isValidPassphrase(""));
    }
    @Test
    void testSingleWord(){
        assertFalse(validationService.isValidPassphrase("word"));
    }
    @Test
    void testRepeatedWord(){
        assertFalse(validationService.isValidPassphrase("word word."));
    }
    @Test
    void testPunctuationIsPresent(){
        assertFalse(validationService.isValidPassphrase("word, hello!"));
    }
    @Test
    void testCapitalLetter(){
        assertFalse(validationService.isValidPassphrase("Hello woLd."));
    }
    @Test
    void testForMeaninglessWord(){
        assertTrue(validationService.isValidPassphrase("fjhgjhajal kdkuuun?"));
    }
}
