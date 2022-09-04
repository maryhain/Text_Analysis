package MobyDickNovel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Map.Entry;
import java.lang.String;


public class PassageAnalyzer {

	
    private String passageFile;
    private UnWantedWordsValidator unWantedWordsValidator;

   
    private Map<String, Long> data = new HashMap<>();
    private List<ReportRow> report = new ArrayList<>();

    public PassageAnalyzer(String passageFile, UnWantedWordsValidator unWantedWordsValidator) throws FileNotFoundException {
        this.passageFile = passageFile;
        this.unWantedWordsValidator = unWantedWordsValidator;
        this.analyze();
        this.createReport();
    }

    private void createReport() {
        for (Map.Entry<String, Long> entry : data.entrySet()) {
            report.add(new ReportRow(entry.getKey(), entry.getValue()));
        }
        report.sort(Comparator.comparing(ReportRow::getCount).reversed());
    }

    private void analyze() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(passageFile));
        while (scanner.hasNext()) {
            String line = scanner.nextLine().trim();
            if (!line.isBlank()) {
                //get separate words in the line
            	List<String> words = List.of(line.split(" "));
            	
                for (String word :  words )
                		{
                    word = cleanWord(word.trim());
                    if (unWantedWordsValidator.validateWord(word)) {
                        if (!data.containsKey(word)) {
                            data.put(word, 1L);
                        } else {
                            data.put(word, data.get(word) + 1);
                        }
                    }
                }
            }
        }

    }

   

	String cleanWord(String word) {
        return word.trim()
                .replace(",", " ")
                .replace(";", " ")
                .replace("?", " ")
                .replace("!", " ")
                .replace(":", " ")
                .replace("\"", " ");

    }


    public List<ReportRow> getReport() {
        if (report.size() <= 100) {
            return report;
        } else {
            return report.subList(0, 101);
        }
    }

static int getMaxOccurrence(Map<String, Integer> words)
{
    int max = 1;

    for (Entry<String, Integer> word :
         words.entrySet()) {

        
        if (word.getValue() > max) {
            max = word.getValue();
        }
    }

    // Return the maximum value from the Map
    return max;
}
}

