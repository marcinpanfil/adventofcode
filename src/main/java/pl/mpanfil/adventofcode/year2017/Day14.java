package pl.mpanfil.adventofcode.year2017;

import org.apache.commons.lang3.StringUtils;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

class Day14 {

    int solve1(String input) {
        int sum = 0;
        List<String> bitStrings = createBitStrings(input);
        for (String bitString : bitStrings) {
            sum += StringUtils.countMatches(bitString, '1');
        }
        return sum;
    }

    int solve2(String input) {
        int[][] bits = createBitTable(createBitStrings(input));
        int[] nextRegion = findNextRegion(bits);
        int count = 0;
        while (nextRegion.length > 0) {
            count++;
            markRegion(bits, nextRegion[0], nextRegion[1]);
            nextRegion = findNextRegion(bits);
        }
        return count;
    }

    private int[][] markRegion(int[][] bits, int i, int j) {
        List<int[]> connected = findConnected(bits, i, j);
        markPoints(bits, new ArrayList<int[]>() {{
            add(new int[]{i, j});
        }});
        while (connected.size() > 0) {
            markPoints(bits, connected);
            List<int[]> tmp = new ArrayList<>();
            for (int[] ints : connected) {
                tmp.addAll(findConnected(bits, ints[0], ints[1]));
            }
            connected = tmp;
        }
        return bits;
    }

    private int[][] markPoints(int[][] bits, List<int[]> tmp) {
        for (int[] ints : tmp) {
            bits[ints[0]][ints[1]] = 0;
        }
        return bits;
    }

    private List<int[]> findConnected(int[][] bits, int i, int j) {
        List<int[]> connected = new ArrayList<>();
        if (i > 0) {
            if (bits[i - 1][j] == 1) {
                connected.add(new int[]{i - 1, j});
            }
        }
        if (j > 0) {
            if (bits[i][j - 1] == 1) {
                connected.add(new int[]{i, j - 1});
            }
        }
        if (i < bits.length - 1) {
            if (bits[i + 1][j] == 1) {
                connected.add(new int[]{i + 1, j});
            }
        }
        if (j < bits[i].length - 1) {
            if (bits[i][j + 1] == 1) {
                connected.add(new int[]{i, j + 1});
            }
        }
        return connected;
    }

    private int[] findNextRegion(int[][] bits) {
        for (int i = 0; i < bits.length; i++) {
            for (int j = 0; j < bits[i].length; j++) {
                if (bits[i][j] == 1) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    private int[][] createBitTable(List<String> bitString) {
        int[][] bitTable = new int[bitString.size()][bitString.size()];
        for (int i = 0; i < bitString.size(); i++) {
            String str = bitString.get(i);
            for (int j = 0; j < str.length(); j++) {
                bitTable[i][j] = Integer.parseInt(str.substring(j, j + 1));
            }
        }
        return bitTable;
    }

    private List<String> createBitStrings(String input) {
        List<String> strings = new ArrayList<>();
        Day10 day10 = new Day10();
        for (int i = 0; i < 128; i++) {
            String line = input + "-" + i;
            String knot = day10.solve2(line, 256);
            strings.add(hexToBin(knot));
        }
        return strings;
    }

    private String hexToBin(String s) {
        int len = s.length() * 4;
        String bin = new BigInteger(s, 16).toString(2);
        if (bin.length() < len) {
            int diff = len - bin.length();
            String pad = "";
            for (int i = 0; i < diff; ++i) {
                pad = pad.concat("0");
            }
            bin = pad.concat(bin);
        }
        return bin;
    }
}
