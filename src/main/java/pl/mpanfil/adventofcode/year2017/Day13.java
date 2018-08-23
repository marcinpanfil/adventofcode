package pl.mpanfil.adventofcode.year2017;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

class Day13 {

    int solve1(List<String> lines) {
        Map<Integer, Integer> data = parseData(lines);
        int last = getLast(data);
        int sum = 0;
        for (int i = 0; i <= last; i++) {
            if (data.containsKey(i)) {
                int size = data.get(i);
                int curPos = i % ((data.get(i) - 1) * 2);
                if (curPos == 0) {
                    sum += size * i;
                }
            }
        }
        return sum;
    }

    int solve2(List<String> lines) {
        Map<Integer, Integer> data = parseData(lines);
        int last = getLast(data);
        int waitTime = 0;
        while (true) {
            int sum = 0;
            for (int i = 0; i <= last; i++) {
                if (sum == 0) {
                    if (data.containsKey(i)) {
                        int size = data.get(i);
                        int curPos = (waitTime + i) % ((data.get(i) - 1) * 2);
                        if (curPos == 0) {
                            sum += size * i;
                            waitTime++;
                        }
                    }
                }
            }
            if (sum == 0) {
                return waitTime;
            }
            if (waitTime % 1000 == 0) {
                System.out.println(waitTime);
            }
        }
    }

    private int getLast(Map<Integer, Integer> data) {
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(data.entrySet());
        Map.Entry<Integer, Integer> lastEntry = entryList.get(entryList.size() - 1);
        return lastEntry.getKey();
    }

    private Map<Integer, Integer> parseData(List<String> lines) {
        Map<Integer, Integer> data = new LinkedHashMap<>();
        for (String line : lines) {
            String[] s = line.split(": ");
            data.put(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
        }
        return data;
    }

}
