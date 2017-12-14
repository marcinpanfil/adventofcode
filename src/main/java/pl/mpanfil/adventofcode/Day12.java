package pl.mpanfil.adventofcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Day12 {

    int solve1(List<String> lines) {
        Map<Integer, List<Integer>> data = parseLines(lines);
        List<Integer> zeroContaining = getGroupFor(data, data.get(0));
        return zeroContaining.size();
    }

    private List<Integer> getGroupFor(Map<Integer, List<Integer>> data, List<Integer> toAdd) {
        List<Integer> zeroContaining = new ArrayList<>();
        while (toAdd.size() > 0) {
            List<Integer> tmp = new ArrayList<>();
            for (Integer i : toAdd) {
                List<Integer> possibleToAdd = data.get(i);
                if (possibleToAdd != null) {
                    for (Integer p : possibleToAdd) {
                        if (!zeroContaining.contains(p) && !tmp.contains(p)) {
                            tmp.add(p);
                        }
                    }
                }
            }
            toAdd = tmp;
            zeroContaining.addAll(toAdd);
        }
        return zeroContaining;
    }

    int solve2(List<String> lines) {
        Map<Integer, List<Integer>> data = parseLines(lines);
        int count = 0;
        while (data.size() > 0) {
            int next = data.keySet().iterator().next();
            List<Integer> toDelete = getGroupFor(data, data.get(next));
            data.keySet().removeAll(toDelete);
            count++;
        }
        return count;
    }

    private Map<Integer, List<Integer>> parseLines(List<String> lines) {
        Map<Integer, List<Integer>> data = new HashMap<>();
        for (String line : lines) {
            String[] split = line.replaceAll(" ", "").split("<->");
            List<Integer> relatedPrograms = new ArrayList<>();
            String[] programsStr = split[1].split(",");
            for (String programStr : programsStr) {
                relatedPrograms.add(Integer.parseInt(programStr));
            }
            data.put(Integer.parseInt(split[0]), relatedPrograms);
        }
        return data;
    }

}
