package com.codecool.vaulttask;

import com.codecool.vaulttask.service.FileReader;
import com.codecool.vaulttask.service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class VaulttaskApplication implements CommandLineRunner {


    @Autowired
    private FileReader fileReader;
    private final ValidationService validationService;

    public VaulttaskApplication(ValidationService validationService) {
        this.validationService = validationService;
    }

    public static void main(String[] args) {
        SpringApplication.run(VaulttaskApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<String> lines = fileReader.readLines("/input.txt");
        int validCount = (int) lines.stream()
                .filter(validationService::isValidPassphrase)
                .count();
        System.out.println("Helyes jelmondatok szama: " + validCount);
    }
}
