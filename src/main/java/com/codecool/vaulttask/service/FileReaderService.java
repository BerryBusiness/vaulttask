package com.codecool.vaulttask.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

@Service
public class FileReaderService {

    private final ValidationService validationService;

    public FileReaderService(ValidationService validationService) {
        this.validationService = validationService;
    }

    public void readFile(){
        int validCount = 0;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                Objects.requireNonNull(getClass().getResourceAsStream("/input.txt"))))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (validationService.isValidPassphrase(line)) {
                    validCount++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Helyes jelmondatok száma: " + validCount);
    }
}
