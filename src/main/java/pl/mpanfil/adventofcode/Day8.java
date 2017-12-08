package pl.mpanfil.adventofcode;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Day8 {

    int solve1(List<String> lines) throws Exception {
        Map<String, Integer> values = parse(lines);
        return Collections.max(values.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getValue();
    }

    int solve2(List<String> lines) throws Exception {
        return getMax(lines);
    }

    private Map<String, Integer> parse(List<String> lines) throws Exception {
        Map<String, Integer> values = new HashMap<>();
        for (String line : lines) {
            String[] attributes = line.split(" ");
            if (checkCondition(attributes[4], attributes[5], Integer.parseInt(attributes[6]), values)) {
                putValue(values, attributes);
            }
        }
        return values;
    }

    private int getMax(List<String> lines) throws Exception {
        Map<String, Integer> values = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for (String line : lines) {
            String[] attributes = line.split(" ");
            if (checkCondition(attributes[4], attributes[5], Integer.parseInt(attributes[6]), values)) {
                putValue(values, attributes);
                if (values.get(attributes[0]) > max) {
                    max = values.get(attributes[0]);
                }
            }
        }
        return max;
    }

    private void putValue(Map<String, Integer> values, String[] attributes) throws Exception {
        String constant = attributes[0];
        int value = Integer.parseInt(attributes[2]);
        switch (attributes[1]) {
            case "inc":
                if (values.containsKey(constant)) {
                    values.put(constant, values.get(constant) + value);
                } else {
                    values.put(constant, value);
                }
                break;
            case "dec":
                if (values.containsKey(constant)) {
                    values.put(constant, values.get(constant) - value);
                } else {
                    values.put(constant, -value);
                }
                break;
            default:
                throw new Exception("command not found");
        }
    }

    private boolean checkCondition(String constant, String condition, int value, Map<String, Integer> values) throws Exception {
        if (condition.equals(">")) {
            if (values.containsKey(constant)) {
                return values.get(constant) > value;
            } else {
                values.put(constant, 0);
                return 0 > value;
            }
        } else if (condition.equals("<")) {
            if (values.containsKey(constant)) {
                return values.get(constant) < value;
            } else {
                values.put(constant, 0);
                return 0 < value;
            }
        } else if (condition.equals(">=")) {
            if (values.containsKey(constant)) {
                return values.get(constant) >= value;
            } else {
                values.put(constant, 0);
                return 0 >= value;
            }
        } else if (condition.equals("<=")) {
            if (values.containsKey(constant)) {
                return values.get(constant) <= value;
            } else {
                values.put(constant, 0);
                return 0 <= value;
            }
        } else if (condition.equals("==")) {
            if (values.containsKey(constant)) {
                return values.get(constant) == value;
            } else {
                values.put(constant, 0);
                return 0 == value;
            }
        } else if (condition.equals("!=")) {
            if (values.containsKey(constant)) {
                return values.get(constant) != value;
            } else {
                values.put(constant, 0);
                return 0 != value;
            }
        } else throw new Exception("no condtion found");
    }

}
