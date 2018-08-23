package pl.mpanfil.adventofcode.year2017;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Day4 {

    int solve1(List<String> lines) {
        int validCount = 0;
        for (String line : lines) {
            String[] words = line.split("\\s+");
            List<String> alreadyAdded = new ArrayList<>();
            boolean contains = false;
            for (String word : words) {
                if (alreadyAdded.contains(word)) {
                    contains = true;
                    break;
                } else {
                    alreadyAdded.add(word);
                }
            }
            if (!contains) {
                validCount++;
            }
        }
        return validCount;
    }

    int solve2(List<String> lines) {
        int validCount = 0;
        for (String line : lines) {
            String[] words = line.split("\\s+");
            boolean isAnagram = false;
            for (int i = 0; i < words.length; i++) {
                for (int j = i + 1; j < words.length; j++) {
                    isAnagram = isAnagram(words[i], words[j]);
                    if (isAnagram) {
                        break;
                    }
                }
                if (isAnagram) {
                    break;
                }
            }
            if (!isAnagram) {
                validCount++;
            }
        }
        return validCount;
    }

    private boolean isAnagram(String firstWord, String secondWord) {
        char[] word1 = firstWord.replaceAll("[\\s]", "").toCharArray();
        char[] word2 = secondWord.replaceAll("[\\s]", "").toCharArray();
        Arrays.sort(word1);
        Arrays.sort(word2);
        return Arrays.equals(word1, word2);
    }

}
