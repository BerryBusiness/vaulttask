package com.codecool.vaulttask.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileReaderImplTest {

    private final FileReader fileReader = new FileReaderImpl();

    @Test
    void testReadLines(@TempDir Path tempDir) throws IOException {
        Path tempFile = tempDir.resolve("test.txt");
        List<String> expectedLines = List.of("Line 1", "Line 2", "Line 3");
        Files.write(tempFile, expectedLines);

        List<String> actualLines = fileReader.readLines(tempFile.toString());
        assertEquals(expectedLines, actualLines);
    }

    @Test
    void testReadLinesWithEmptyFile(@TempDir Path tempDir) throws IOException {
        Path tempFile = tempDir.resolve("emptyFile.txt");
        Files.write(tempFile, Collections.emptyList());

        List<String> actualLines = fileReader.readLines(tempFile.toString());
        assertTrue(actualLines.isEmpty(), "The list of lines read from an empty file should be empty.");
    }
    @Test
    void testReadLinesFileNotFound() {
        assertThrows(FileNotFoundException.class, () -> {
            fileReader.readLines("/nonexistentfile.txt");
        });
    }
}
