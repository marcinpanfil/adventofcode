package pl.mpanfil.adventofcode.year2017;

class Day1 {

    int solve1(String strToSolve) {
        char[] chars = strToSolve.toCharArray();
        int sum = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                sum += Character.getNumericValue(chars[i]);
            }
        }
        if (chars[0] == chars[chars.length - 1]) {
            sum += Character.getNumericValue(chars[0]);
        }
        return sum;
    }

    int solve2(String strToSolve) {
        char[] chars = strToSolve.toCharArray();
        int sum = 0;
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] == chars[i + chars.length/2]) {
                sum += (2 * Character.getNumericValue(chars[i]));
            }
        }
        return sum;
    }
}
