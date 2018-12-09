package pl.mpanfil.adventofcode.year2018;

import java.util.ArrayList;
import java.util.List;

public class Day8 {

    private List<Integer> input;
    private int result = 0;

    public int solve1(List<Integer> input) {
        this.input = input;
        calculateChildSum(1);
        return input.stream().mapToInt(Integer::intValue).sum();
    }

    public int solve2(List<Integer> input) {
        this.input = input;
        this.result = 0;
        calculateChildSumEntries(1);
        return result;
    }

    private List<Integer> calculateChildSumEntries(int childCount) {
        List<Integer> sums = new ArrayList<>();
        for (int i = 0; i < childCount; i++) {
            int count = input.remove(0);
            int entryCount = input.remove(0);
            if (count == 0) {
                int sum = input.subList(0, entryCount).stream().mapToInt(Integer::intValue).sum();
                sums.add(sum);
            } else {
                List<Integer> childSums = calculateChildSumEntries(count);
                List<Integer> entries = input.subList(0, entryCount);
                int sum = 0;
                for (Integer entry : entries) {
                    if (entry < childSums.size() + 1) {
                        sum += childSums.get(entry - 1);
                    }
                }
                sums.add(sum);
                result = sum;
            }
            input = input.subList(entryCount, input.size());
        }
        return sums;
    }

    private Integer calculateChildSum(int childCount) {
        int sum = 0;
        for (int i = 0; i < childCount; i++) {
            int count = input.remove(0);
            int entryCount = input.remove(0);
            sum = calculateChildSum(count);
            sum += input.subList(0, entryCount).stream().mapToInt(Integer::intValue).sum();
            input = input.subList(entryCount, input.size());
        }
        return sum;
    }

}
