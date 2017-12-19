package pl.mpanfil.adventofcode;

import org.apache.commons.lang3.math.NumberUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Day18 {

    long solve1(List<String> instructions) {
        char lastPlayed = '-';
        long lastPlayedFr = 0;
        int curPos = 0;
        Map<Character, Long> data = new HashMap<>();
        while (curPos < instructions.size()) {
            String instruction = instructions.get(curPos);
            String[] insParam = instruction.split(" ");
            String cmd = insParam[0];
            char parameter1 = insParam[1].toCharArray()[0];
            if (!data.containsKey(parameter1)) {
                data.put(parameter1, 0L);
            }
            long value1 = data.get(parameter1);
            long value2 = 0;
            if (insParam.length == 3) {
                value2 = getValue2(data, insParam[2], value2);
            }
            switch (cmd) {
                case "snd":
                    lastPlayed = parameter1;
                    lastPlayedFr = data.get(lastPlayed);
                    break;
                case "rcv":
                    long value = data.get(lastPlayed);
                    if (value > 0) {
                        return lastPlayedFr;
                    }
                    break;
                case "set":
                    data.put(parameter1, value2);
                    break;
                case "add":
                    data.put(parameter1, value1 + value2);
                    break;
                case "mul":
                    data.put(parameter1, value1 * value2);
                    break;
                case "mod":
                    data.put(parameter1, value1 % value2);
                    break;
                case "jgz":
                    if (value1 > 0) {
                        curPos += value2;
                    } else {
                        curPos++;
                    }
                    break;
            }

            if (!cmd.equals("jgz")) {
                curPos++;
            }
        }
        return lastPlayedFr;
    }

    private long getValue2(Map<Character, Long> data, String str, long value2) {
        if (NumberUtils.isCreatable(str)) {
            value2 = Long.parseLong(str);
        } else {
            char param2 = str.toCharArray()[0];
            if (data.containsKey(param2)) {
                value2 = data.get(param2);
            } else {
                data.put(param2, 0L);
            }
        }
        return value2;
    }

}
