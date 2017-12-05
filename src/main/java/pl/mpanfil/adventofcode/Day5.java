package pl.mpanfil.adventofcode;

import java.util.List;

class Day5 {

    int solve1(List<Integer> jumps) {
        int steps = 0;
        int currentIndex = 0;

        while (currentIndex < jumps.size()) {
            int jump = jumps.get(currentIndex);
            jumps.set(currentIndex, jump + 1);
            currentIndex += jump;
            steps++;
        }

        return steps;
    }

    int solve2(List<Integer> jumps) {
        int steps = 0;
        int currentIndex = 0;

        while (currentIndex < jumps.size()) {
            int jump = jumps.get(currentIndex);
            if (jump >= 3) {
                jumps.set(currentIndex, jump - 1);
            } else {
                jumps.set(currentIndex, jump + 1);
            }
            currentIndex += jump;
            steps++;
        }
        return steps;
    }

}
