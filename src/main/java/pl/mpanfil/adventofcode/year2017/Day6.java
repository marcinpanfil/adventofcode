package pl.mpanfil.adventofcode.year2017;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Day6 {

    int solve1(List<Integer> numbers) {
        int steps = 1;
        List<String> variations = new ArrayList<>();

        while (true) {
            int max = Collections.max(numbers);
            int index = numbers.indexOf(max);
            numbers.set(index, 0);
            int count = 0;
            int current = index == numbers.size() - 1 ? 0 : index + 1;
            distribute(numbers, max, index, count, current);
            String varStr = numbers.toString();
            if (variations.contains(varStr)) {
                return steps;
            } else {
                variations.add(varStr);
                steps++;
            }
        }
    }

    int solve2(List<Integer> numbers) {
        List<String> variations = new ArrayList<>();
        int steps = 1;
        while (true) {
            int max = Collections.max(numbers);
            int index = numbers.indexOf(max);
            numbers.set(index, 0);
            int count = 0;
            int current = index == numbers.size() - 1 ? 0 : index + 1;
            distribute(numbers, max, index, count, current);
            String varStr = numbers.toString();
            if (variations.contains(varStr)) {
                return variations.size() - variations.indexOf(varStr);
            } else {
                variations.add(varStr);
            }
        }
    }

    private void distribute(List<Integer> numbers, int max, int index, int count, int current) {
        while (count < max) {
            numbers.set(current, numbers.get(current) + 1);
            count++;
            current++;
            if (current == numbers.size()) {
                current = index == 0 ? 1 : 0;
            }
        }
    }

}
