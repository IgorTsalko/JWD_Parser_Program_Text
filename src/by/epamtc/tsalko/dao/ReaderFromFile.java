package by.epamtc.tsalko.dao;

import by.epamtc.tsalko.dao.exception.DAOException;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReaderFromFile {

    private final Path filePath = Paths.get("resources/file.txt");

    public String readAllText() throws DAOException {
        StringBuilder textBuffer = new StringBuilder();

        try (BufferedReader fileReader = Files.newBufferedReader(filePath)) {
            String line;
            while ((line = fileReader.readLine()) != null) {
                textBuffer.append(line).append("\n");
            }
        } catch (IOException e) {
            throw new DAOException(e);
        }

        return textBuffer.toString();
    }
}
