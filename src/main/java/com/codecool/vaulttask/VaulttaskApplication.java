package com.codecool.vaulttask;

import com.codecool.vaulttask.service.FileReaderService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VaulttaskApplication implements CommandLineRunner {


    private FileReaderService fileReaderService;

    public VaulttaskApplication(FileReaderService fileReaderService) {
        this.fileReaderService = fileReaderService;
    }

    public static void main(String[] args) {
        SpringApplication.run(VaulttaskApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        fileReaderService.readFile();
    }
}
