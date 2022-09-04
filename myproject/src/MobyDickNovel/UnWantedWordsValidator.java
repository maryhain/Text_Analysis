package MobyDickNovel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class UnWantedWordsValidator {

    private Map<String, String> unWantedWords = new HashMap<>();

    public UnWantedWordsValidator(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));
        while (scanner.hasNext()) {
            String line = scanner.nextLine().trim();
            if (!(line.trim()).startsWith("#") && !line.isBlank()) {
                unWantedWords.put(line, line);
            }
        }
    }

    public boolean validateWord(String word) {
        return !unWantedWords.containsKey(word);
    }

}



