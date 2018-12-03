package pl.mpanfil.adventofcode.year2018;

import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3 {

    public int solve1(List<String> input) {
        int[][] positions = new int[1100][1100];
        int result = 0;
        for (String line : input) {
            int[] data = parseLine(line);
            int left = data[1];
            int top = data[2];
            int width = data[3];
            int height = data[4];
            for (int i = left; i < left + width; i++) {
                for (int j = top; j < top + height; j++) {
                    positions[i][j]++;
                }
            }
        }
        for (int[] position : positions) {
            for (int j = 0; j < positions.length; j++) {
                if (position[j] > 1) {
                    result++;
                }
            }
        }

        return result;
    }

    public int solve2(List<String> input) {
        boolean[] overlap = new boolean[input.size()];
        int[][] positions = new int[1100][1100];
        for (String line : input) {
            int[] data = parseLine(line);
            int index = data[0];
            int left = data[1];
            int top = data[2];
            int width = data[3];
            int height = data[4];
            for (int i = left; i < left + width; i++) {
                for (int j = top; j < top + height; j++) {
                    if (positions[i][j] != 0) {
                        overlap[positions[i][j] - 1] = true;
                        overlap[index - 1] = true;
                    }
                    positions[i][j] = index;
                }
            }
        }

        for (int i = 0; i < overlap.length; i++) {
            if (!overlap[i]) {
                return i + 1;
            }
        }
        return -1;
    }

    private int[] parseLine(String line) {
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(line);
        return m.results().map(MatchResult::group).mapToInt(Integer::parseInt).toArray();
    }

}
