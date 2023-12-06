package com.codecool.vaulttask.service;


import org.springframework.stereotype.Service;

@Service
public class ValidationService {

    public boolean isValidPassphrase(String passphrase) {
        if (!passphrase.matches("^[a-z ]+[.!?]$")) {
            return false;
        }

        String[] words = passphrase.substring(0, passphrase.length() - 1).split(" ");
        if (words.length < 2) {
            return false;
        }

        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].equals(words[j])) {
                    return false;
                }
            }
        }

        return true;
    }
}
