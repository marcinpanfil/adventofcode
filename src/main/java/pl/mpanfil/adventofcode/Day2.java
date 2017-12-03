package pl.mpanfil.adventofcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

class Day2 {

    int solve1(List<String> strToSolve) {
        AtomicInteger checksum = new AtomicInteger(0);
        strToSolve.forEach((s) -> {
            String[] numbersStr = s.split("\\s+");
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (String numberStr : numbersStr) {
                int number = Integer.parseInt(numberStr);
                if (number > max) {
                    max = number;
                }
                if (number < min) {
                    min = number;
                }
            }
            checksum.addAndGet(max - min);
        });
        return checksum.get();
    }

    int solve2(List<String> strToSolve) {
        int checksum = 0;
        for (String line : strToSolve) {
            String[] numbersStr = line.split("\\s+");
            List<Integer> integers = Arrays.stream(numbersStr).map(Integer::parseInt).collect(Collectors.toList());
            checksum += findAndCalculateDivisible(integers);
        }
        return checksum;
    }

    private int findAndCalculateDivisible(List<Integer> integers) {
        for (int i = 0; i < integers.size() - 1; i++) {
            for (int j = 1; j < integers.size(); j++) {
                if (i != j) {
                    if (integers.get(i) % integers.get(j) == 0) {
                        return integers.get(i) / integers.get(j);
                    } else if (integers.get(j) % integers.get(i) == 0) {
                        return integers.get(j) / integers.get(i);
                    }
                }
            }
        }
        return 0;
    }
}
