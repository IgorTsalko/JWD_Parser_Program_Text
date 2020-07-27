package by.epamtc.tsalko.main;

import by.epamtc.tsalko.bean.Sentence;
import by.epamtc.tsalko.bean.Text;
import by.epamtc.tsalko.bean.Word;
import by.epamtc.tsalko.dao.TextDAO;
import by.epamtc.tsalko.dao.exception.DAOException;
import by.epamtc.tsalko.dao.impl.TextDAOImpl;
import by.epamtc.tsalko.main.print.PrintComponent;
import by.epamtc.tsalko.service.impl.TextService;
import by.epamtc.tsalko.service.impl.impl.TextServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        try {
            // Время старта программы
            long startTime = System.currentTimeMillis();

            PrintComponent printComponent = new PrintComponent();
            TextDAO textDAO = new TextDAOImpl();
            TextService textService = new TextServiceImpl();

            Text text = textDAO.getText();

            // Время конца программы
            long endTime = System.currentTimeMillis();
            // Использование памяти программы
            long usedBytes = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
            // Вывод информации
            System.out.printf("Time: %.2f sec; Memory %.2f mb; Sentences: %d; Words: %d\n\n",
                    ((endTime - startTime)/1000.0), (usedBytes / 1048576.0), Sentence.getCount(), Word.getCount());

            // Вывод собранного текста
            System.out.println("Вывод собранного текста _____________________________________________________________________");
            printComponent.printComponents(text);
            System.out.println();

            // Вывод всех предложений в порядке возрастания количества слов
            System.out.println("Вывод всех предложений в порядке возрастания количества слов_________________________________");
            textService.printSentencesAscending(text);
            System.out.println();

            // Вывод всех предложений с заменой мест первого и последнего слова
            System.out.println("Вывод всех предложений с заменой мест первого и последнего слова______________________________");
            textService.printSentenceOppositeReplacementFirstLastWords(text);
            System.out.println();

        } catch (DAOException e) {
            logger.error("Ошибка программы", e);
        }



    }
}
