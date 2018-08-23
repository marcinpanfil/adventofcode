package pl.mpanfil.adventofcode.year2017;

import org.apache.commons.lang3.math.NumberUtils;

import java.util.ArrayList;
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
                value2 = getValue2(data, insParam[2]);
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

    long solve2(List<String> instructions) {
        Map<Character, Long> data0 = new HashMap<>();
        Map<Character, Long> data1 = new HashMap<>();
        data0.put('p', 0L);
        data1.put('p', 1L);
        List<Long> register0 = new ArrayList<>();
        List<Long> register1 = new ArrayList<>();
        int cur0 = 0;
        int cur1 = 0;
        long sndCount = 0;
        boolean isBlocked0 = false;
        boolean isBlocked1 = false;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            if (i % 2 == 0) {
                String instruction = instructions.get(cur0);
                String[] insParam = instruction.split(" ");
                String cmd = insParam[0];
                char parameter1 = insParam[1].toCharArray()[0];
                if (!data0.containsKey(parameter1)) {
                    data0.put(parameter1, 0L);
                }
                long value1 = data0.get(parameter1);
                long value2 = 0;
                if (insParam.length == 3) {
                    value2 = getValue2(data0, insParam[2]);
                }
                switch (cmd) {
                    case "snd":
                        register1.add(value1);
                        cur0++;
                        isBlocked1 = false;
                    case "rcv":
                        if (register0.size() > 0) {
                            long toRcv = register0.remove(0);
                            data0.put(parameter1, toRcv);
                        } else {
                            isBlocked0 = true;
                            if (isBlocked1) {
                                return sndCount;
                            }
                        }
                        break;
                    case "set":
                        data0.put(parameter1, value2);
                        break;
                    case "add":
                        data0.put(parameter1, value1 + value2);
                        break;
                    case "mul":
                        data0.put(parameter1, value1 * value2);
                        break;
                    case "mod":
                        data0.put(parameter1, value1 % value2);
                        break;
                    case "jgz":
                        if (value1 > 0) {
                            cur0 += value2;
                        } else {
                            cur0++;
                        }
                        break;
                }

                if (!cmd.equals("jgz") || !cmd.equals("rcv")) {
                    cur0++;
                }
            } else {
                String instruction = instructions.get(cur1);
                String[] insParam = instruction.split(" ");
                String cmd = insParam[0];
                char parameter1 = insParam[1].toCharArray()[0];
                if (!data1.containsKey(parameter1)) {
                    data1.put(parameter1, 0L);
                }
                long value1 = data1.get(parameter1);
                long value2 = 0;
                if (insParam.length == 3) {
                    value2 = getValue2(data1, insParam[2]);
                }
                switch (cmd) {
                    case "snd":
                        register0.add(value1);
                        cur1++;
                        isBlocked0 = false;
                        sndCount++;
                    case "rcv":
                        if (register1.size() > 0) {
                            long toRcv = register1.remove(0);
                            data1.put(parameter1, toRcv);
                        } else {
                            isBlocked1 = true;
                            if (isBlocked0) {
                                return sndCount;
                            }
                        }
                        break;
                    case "set":
                        data1.put(parameter1, value2);
                        break;
                    case "add":
                        data1.put(parameter1, value1 + value2);
                        break;
                    case "mul":
                        data1.put(parameter1, value1 * value2);
                        break;
                    case "mod":
                        data1.put(parameter1, value1 % value2);
                        break;
                    case "jgz":
                        if (value1 > 0) {
                            cur1 += value2;
                        } else {
                            cur1++;
                        }
                        break;
                }

                if (!cmd.equals("jgz") || !cmd.equals("rcv")) {
                    cur1++;
                }
            }
        }
        return sndCount;
    }

    private long getValue2(Map<Character, Long> data, String str) {
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
