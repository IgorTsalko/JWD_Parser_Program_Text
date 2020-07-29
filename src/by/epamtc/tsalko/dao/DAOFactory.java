package by.epamtc.tsalko.dao;

import by.epamtc.tsalko.dao.exception.DAOException;
import by.epamtc.tsalko.dao.impl.TextDAOImpl;

public class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private final TextDAO textDAO = new TextDAOImpl();

    private DAOFactory() {}

    public static DAOFactory getInstance() {
        return instance;
    }

    public TextDAO getTextDAO() {
        return textDAO;
    }
}
