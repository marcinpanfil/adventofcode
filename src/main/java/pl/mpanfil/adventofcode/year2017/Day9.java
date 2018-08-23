package pl.mpanfil.adventofcode.year2017;

import java.util.List;

class Day9 {

    int solve1(List<String> lines) {
        int sum = 0;
        for (String line : lines) {
            sum += calculateGroups(line);
        }
        return sum;
    }

    int solve2(List<String> lines) {
        int sum = 0;
        for (String line : lines) {
            sum += calculateGarbageCount(line);
        }
        return sum;
    }

    private int calculateGarbageCount(String line) {
        int sum = 0;
        line = removeAllIgnoredCharacters(line);
        while (line.contains("<") && line.contains((">"))) {
            int start = findGarbageStartIndex(line);
            int end = findGarbageEndIndex(start, line);
            if (start >= 0 && end >= 0) {
                StringBuilder sb = new StringBuilder(line);
                sb.delete(start, end + 1);
                line = sb.toString();
                sum += (end - start - 1);
            } else {
                return sum;
            }
        }
        return sum;
    }

    private int calculateGroups(String line) {
        int sum = 0;
        line = removeAllIgnoredCharacters(line);
        line = removeGarbage(line);
        while (!line.isEmpty()) {
            int lastGroupStartIndex = findLastOpenedGroupStartIndex(line);
            int lastGroupEndIndex = findLastOpenedGroupEndIndex(lastGroupStartIndex, line);
            StringBuilder sb = new StringBuilder(line);
            int score = numberOf(lastGroupStartIndex, line, '{') - numberOf(lastGroupStartIndex, line, '}') + 1;
            sum += score;
            sb.delete(lastGroupStartIndex, lastGroupEndIndex + 1);
            line = sb.toString();
        }
        return sum;
    }

    private String removeGarbage(String line) {
        while (line.contains("<") && line.contains((">"))) {
            int start = findGarbageStartIndex(line);
            int end = findGarbageEndIndex(start, line);
            if (start >= 0 && end >= 0) {
                StringBuilder sb = new StringBuilder(line);
                sb.delete(start, end + 1);
                line = sb.toString();
            } else {
                return line;
            }
        }
        return line;
    }

    private String removeAllIgnoredCharacters(String line) {
        return line.replaceAll("!.", "");
    }

    private int numberOf(int end, String line, char search) {
        char[] chars = line.substring(0, end).toCharArray();
        int count = 0;
        for (char c : chars) {
            if (c == search) {
                count++;
            }
        }
        return count;
    }

    private int findLastOpenedGroupStartIndex(String line) {
        return line.lastIndexOf('{');
    }

    private int findLastOpenedGroupEndIndex(int startIndex, String line) {
        String newLine = line.substring(startIndex);
        return newLine.indexOf('}') + startIndex;
    }

    private int findGarbageStartIndex(String line) {
        return line.indexOf("<");
    }

    private int findGarbageEndIndex(int startIndex, String line) {
        String newLine = line.substring(startIndex);
        return newLine.indexOf('>') + startIndex;
    }

}
