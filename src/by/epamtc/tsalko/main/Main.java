package by.epamtc.tsalko.main;

import by.epamtc.tsalko.bean.impl.Text;
import by.epamtc.tsalko.dao.DAOFactory;
import by.epamtc.tsalko.dao.TextDAO;
import by.epamtc.tsalko.dao.exception.DAOException;
import by.epamtc.tsalko.main.print.PrintComponent;
import by.epamtc.tsalko.service.impl.TextService;
import by.epamtc.tsalko.service.impl.impl.TextServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        try {
            PrintComponent printComponent = new PrintComponent();
            DAOFactory daoFactory = DAOFactory.getInstance();
            TextDAO textDAO = daoFactory.getTextDAO();
            TextService textService = new TextServiceImpl();

            Text text = textDAO.getText();

            // Вывод собранного текста
            System.out.println("Вывод собранного текста _____________________________________________________________________");
            printComponent.print(text.getText());
            System.out.println();

            // Вывод всех предложений в порядке возрастания количества слов
            System.out.println("Вывод всех предложений в порядке возрастания количества слов ________________________________");
            printComponent.print(textService.formSentencesAscending(text));
            System.out.println();

            // Вывод всех предложений с заменой мест первого и последнего слова
            System.out.println("Вывод всех предложений с заменой мест первого и последнего слова ____________________________");
            printComponent.print(textService.formSentenceOppositeReplacementFirstLastWords(text));
            System.out.println();

            // Вывод всех слов с сортировкой по букве
            System.out.println("Вывод всех слов с сортировкой по букве ______________________________________________________");
            printComponent.print(textService.formSortedWordsByLetter(text, "p"));
            System.out.println();

        } catch (DAOException e) {
            logger.error("Ошибка программы", e);
        }
    }
}
