package pl.mpanfil.adventofcode.year2017;

import org.apache.commons.lang3.math.NumberUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Day23 {

    long solve1(List<String> instructions) throws Exception {
        int curPos = 0;
        Map<Character, Long> data = new HashMap<>();
        long count = 0;
        while (curPos < instructions.size()) {
            String instruction = instructions.get(curPos);
            String[] insParam = instruction.split(" ");
            String cmd = insParam[0];
            char parameter1 = insParam[1].toCharArray()[0];
            if (!data.containsKey(parameter1)) {
                data.put(parameter1, 0L);
            }
            long value1 = getValue(data, insParam[1]);
            long value2 = getValue(data, insParam[2]);
            switch (cmd) {
                case "set":
                    data.put(parameter1, value2);
                    break;
                case "mul":
                    count++;
                    data.put(parameter1, value1 * value2);
                    break;
                case "sub":
                    data.put(parameter1, value1 - value2);
                    break;
                case "jnz":
                    if (value1 != 0) {
                        curPos += value2;
                    } else {
                        curPos++;
                    }
                    break;
                default:
                    throw new Exception("not found");
            }
            if (!cmd.equals("jnz")) {
                curPos++;
            }
        }
        return count;
    }

    long solve2() {
        long b = (long) (67 * 100 + 100000);
        long c = b + 17000;
        long h = 0L;

        for (; b <= c; b += 17) {
            for (int i = 2; i < b; i++) {
                if (b % i == 0) {
                    h++;
                    break;
                }
            }
        }
        return h;

    }

    private long getValue(Map<Character, Long> data, String str) {
        if (NumberUtils.isCreatable(str)) {
            return Long.parseLong(str);
        } else {
            char param2 = str.toCharArray()[0];
            if (data.containsKey(param2)) {
                return data.get(param2);
            } else {
                data.put(param2, 0L);
            }
        }
        return 0;
    }

}
