package MobyDickNovel;

import java.io.FileNotFoundException;
import java.util.List;

public class Main {
    public static void main(String args[]) throws FileNotFoundException {
        UnWantedWordsValidator unWantedWordsValidator =
                new UnWantedWordsValidator("C:\\Users\\toshiba\\Desktop\\stop-words.txt");
        PassageAnalyzer passageAnalyzer =
                new PassageAnalyzer("C:\\Users\\toshiba\\Desktop\\mobydick.txt",
                        unWantedWordsValidator);
        List<ReportRow> report = passageAnalyzer.getReport();

        for (ReportRow reportRow : report) {
            reportRow.print();
        }


    }
}
