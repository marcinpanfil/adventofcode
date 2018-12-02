package pl.mpanfil.adventofcode.year2018;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day2 {

    public int solve1(List<String> input) {
        int d = 0;
        int t = 0;
        for (String i : input) {
            Map<Integer, Integer> counter = new HashMap<>();
            i.chars().forEach((c) -> {
                if (counter.containsKey(c)) {
                    int count = counter.get(c) + 1;
                    counter.put(c, count);
                } else {
                    counter.put(c, 1);
                }
            });
            if (counter.values().contains(2)) {
                d++;
            }
            if (counter.values().contains(3)) {
                t++;
            }
        }
        return d * t;
    }

    public String solve2(List<String> input) {
        for (int i = 0; i < input.size(); i++) {
            for (int j = i + 1; j < input.size(); j++) {
                char[] first = input.get(i).toCharArray();
                char[] second = input.get(j).toCharArray();
                int notEqual = 0;
                int index = 0;
                for (int k = 0; k < first.length; k++) {
                    if(notEqual <= 1) {
                        if (first[k] != second[k]) {
                            notEqual++;
                            index = k;
                        }
                    } else {
                        break;
                    }
                }
                if(notEqual == 1) {
                    StringBuilder sb = new StringBuilder(String.valueOf(first));
                    return sb.deleteCharAt(index).toString();
                }
            }
        }
        return "";
    }

}
