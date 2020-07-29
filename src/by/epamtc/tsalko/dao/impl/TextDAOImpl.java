package by.epamtc.tsalko.dao.impl;

import by.epamtc.tsalko.bean.impl.Text;
import by.epamtc.tsalko.dao.ReaderFromFile;
import by.epamtc.tsalko.dao.TextDAO;
import by.epamtc.tsalko.dao.exception.DAOException;
import by.epamtc.tsalko.dao.parser.ComponentParser;
import by.epamtc.tsalko.dao.parser.ParserFactory;

public class TextDAOImpl implements TextDAO {

    private final ComponentParser componentParser = ParserFactory.getComponentParser();
    private final ReaderFromFile reader = new ReaderFromFile();

    public TextDAOImpl() {
    }

    @Override
    public Text getText() throws DAOException {
        return componentParser.createText(reader.readAllText());
    }
}
