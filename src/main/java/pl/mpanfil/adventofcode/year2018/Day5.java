package pl.mpanfil.adventofcode.year2018;

import org.apache.commons.lang3.ArrayUtils;

public class Day5 {

    public int solve1(String input) {
        char[] chars = input.toCharArray();
        int length = chars.length - 1;
        for (int i = 0; i < length - 1; i++) {
            if (chars[i] != chars[i + 1] && Character.toLowerCase(chars[i]) == Character.toLowerCase(chars[i + 1])) {
                chars = ArrayUtils.remove(chars, i + 1);
                chars = ArrayUtils.remove(chars, i);
                length = chars.length;
                i = i < 2 ? i = -1 : i - 2;
            }
        }
        return chars.length;
    }

    public int solve2(String input) {
        int min = Integer.MAX_VALUE;
        String current = input;
        for (int i = 0; i < 26; i++) {
            char lc = (char) (97 + i);
            char uC = (char) (65 + i);
            current = current.replace(String.valueOf(lc), "");
            current = current.replace(String.valueOf(uC), "");
            int result = solve1(current);
            if (result < min) {
                min = result;
            }
            current = input;
        }
        return min;
    }

}
