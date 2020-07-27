package by.epamtc.tsalko.dao;

import by.epamtc.tsalko.bean.Text;
import by.epamtc.tsalko.dao.exception.DAOException;

public interface TextDAO {

    Text getText() throws DAOException;
}
