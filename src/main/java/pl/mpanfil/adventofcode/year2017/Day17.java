package pl.mpanfil.adventofcode.year2017;

import java.util.ArrayList;
import java.util.List;

class Day17 {

    int solve1(int steps) {
        List<Integer> spin = new ArrayList<>();
        int curPos = 1;
        spin.add(0);
        for (int i = 1; i < 2018; i++) {
            spin.add(curPos, i);
            curPos = (curPos + steps) % spin.size() + 1;
            if (curPos == spin.size()) {
                curPos = 0;
            }
        }
        return spin.get(spin.indexOf(2017) + 1);
    }

    int solve2(int steps, int cycles) {
        int curPos = 1;
        int zeroIndex = 0;
        int value = 0;
        for (int i = 1; i < cycles; i++) {
            curPos = (curPos + steps) % (i + 1) + 1;
            if (curPos == i + 1) {
                curPos = 0;
            }
            if (curPos == zeroIndex + 1) {
                value = i + 1;
            }
            if (curPos <= zeroIndex) {
                zeroIndex++;
            }
        }
        return value;
    }

}
