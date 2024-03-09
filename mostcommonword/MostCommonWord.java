package mostcommonword;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class MostCommonWord {
    public String mostCommonWordBruteForce(String paragraph, String[] banned) {
        String lowerCaseParagraph = paragraph.toLowerCase();
        char[] specialChars = new char[]{'!', '?', '\'', ',',';', '.'};
        Map<String, Integer> wordCount = new HashMap<>();
        String currentMaxWord = "";

        for(char specialChar: specialChars) {
            lowerCaseParagraph = lowerCaseParagraph.replace(specialChar, ' ');
        }

        String[] words = lowerCaseParagraph.split(" ");

        Set<String> bannedSet = Arrays.stream(banned)
                .map(String::toLowerCase)
                .collect(Collectors.toSet());

        for (String word : words) {
            word = word.trim();

            if (!word.isEmpty() && !bannedSet.contains(word)) {
                Integer count = 1;

                if (wordCount.containsKey(word)) {
                    count = wordCount.get(word) + 1;
                }

                wordCount.put(word, count);

                if (currentMaxWord.isEmpty()) {
                    currentMaxWord = word;
                }

                int currentMaxCount = wordCount.get(currentMaxWord);
                if (currentMaxCount <= count) {
                    currentMaxWord = word;
                }

            }
        }

        return currentMaxWord;
    }

}
