package pl.mpanfil.adventofcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Day7 {

    String solve1(List<String> lines) {
        lines = lines.stream().filter(l -> l.contains("->")).collect(Collectors.toList());
        List<String> usedDisks = new ArrayList<>();
        List<String> refDisks = new ArrayList<>();
        for (String line : lines) {
            String diskRef = line.substring(0, line.indexOf(" "));
            refDisks.add(diskRef);
            String[] disks = line.substring(line.indexOf("->") + 2).replaceAll(" ", "").split(",");
            for (String disk : disks) {
                usedDisks.add(disk);
            }
        }
        for (String refDisk : refDisks) {
            if (!usedDisks.contains(refDisk)) {
                return refDisk;
            }
        }
        return "";
    }

    int solve2(List<String> lines) {
        Map<String, Integer> weightMap = createWeightMap(lines);
        String head = solve1(lines);
        String[] subDisks = getSubDisks(head, lines);
        String last = "";
        while (subDisks != null) {
            String notBalanced = findNotBalanced(subDisks, weightMap);
            if(notBalanced.equals("")) {

            }
            subDisks = getSubDisks(notBalanced, lines);
            last = notBalanced;
        }
        return 0;
    }

    private String findNotBalanced(String[] disks, Map<String, Integer> weightMap) {
        Map<Integer, Integer> values = new HashMap<>(disks.length);
        for (String disk : disks) {
            int value = weightMap.get(disk);
            if (values.containsKey(value)) {
                values.put(value, values.get(value) + 1);
            } else {
                values.put(value, 1);
            }
        }
        if (values.size() == 1) {
            return "";
        }
        int notBalanced = Collections.min(values.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
        for (String disk : disks) {
            int value = weightMap.get(disk);
            if (notBalanced == value) {
                return disk;
            }
        }
        return "";
    }

    private Map<String, Integer> createWeightMap(List<String> lines) {
        Map<String, Integer> weights = new HashMap<>();
        for (String line : lines) {
            if (!line.contains("->")) {
                String diskRef = line.substring(0, line.indexOf(" "));
                int weight = Integer.parseInt(line.substring(line.indexOf("(") + 1, line.indexOf(")")));
                weights.put(diskRef, weight);
            }
        }
        for (String line : lines) {
            if (line.contains("->")) {
                String diskRef = line.substring(0, line.indexOf(" "));
                weights.put(diskRef, getDiskWeight(diskRef, lines));
            }
        }
        return weights;
    }

    private int getDiskWeight(String disk, List<String> lines) {
        String line = getDiskLine(disk, lines);
        if (line.contains("->")) {
            String[] subDisks = getSubDisks(disk, lines);
            System.out.println("disk " + disk);
            int weight = Integer.parseInt(line.substring(line.indexOf("(") + 1, line.indexOf(")")));
            for (String subDisk : subDisks) {
                weight += getDiskWeight(subDisk, lines);
            }
            return weight;
        } else {
            return Integer.parseInt(line.substring(line.indexOf("(") + 1, line.indexOf(")")));
        }
    }

    private String getDiskLine(String disk, List<String> lines) {
        for (String line : lines) {
            if (line.startsWith(disk + " ")) {
                return line;
            }
        }
        return null;
    }

    private String[] getSubDisks(String disk, List<String> lines) {
        for (String line : lines) {
            if (line.startsWith(disk + " ")) {
                return line.substring(line.indexOf("->") + 2).replaceAll(" ", "").split(",");
            }
        }
        return null;
    }

}
