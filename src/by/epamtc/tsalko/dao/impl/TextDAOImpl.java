package by.epamtc.tsalko.dao.impl;

import by.epamtc.tsalko.bean.Text;
import by.epamtc.tsalko.dao.TextDAO;
import by.epamtc.tsalko.dao.exception.DAOException;
import by.epamtc.tsalko.dao.parser.ComponentParser;
import by.epamtc.tsalko.dao.parser.ParserFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TextDAOImpl implements TextDAO {

    private final Path filePath = Paths.get("resources/file.txt");
    private final ComponentParser componentParser = ParserFactory.getComponentParser();

    @Override
    public Text getText() throws DAOException {
        Text text;
        StringBuilder textBuffer = new StringBuilder();

        try (BufferedReader fileReader = Files.newBufferedReader(filePath)) {
            String line;
            while ((line = fileReader.readLine()) != null) {
                textBuffer.append(line).append("\n");
            }
            text = componentParser.createText(textBuffer.toString());
        } catch (IOException e) {
            throw new DAOException(e);
        }

        return text;
    }
}
