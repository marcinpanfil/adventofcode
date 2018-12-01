package pl.mpanfil.adventofcode.year2018;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day1 {


    public int solve1(List<Integer> input) {
        return input.stream().mapToInt(Integer::intValue).sum();
    }

    public int solve2(List<Integer> input) throws Exception {
        Set<Integer> integers = new HashSet<>();
        int sum = 0;
        for (int i = 0; i < input.size(); i++) {
            sum += input.get(i);
            if(integers.contains(sum)) {
                return sum;
            } else {
                integers.add(sum);
            }
            if(i == input.size() - 1) {
                i = -1;
            }
        }

        throw new Exception("not found");
    }
}
