package pl.mpanfil.adventofcode.year2017;

import java.util.ArrayList;
import java.util.List;

class Day16 {

    String solve1(List<String> instructions, String danceString) {
        return dance(instructions, danceString);
    }

    String solve2(List<String> instructions, String danceString) {
        List<String> alreadyDanced = new ArrayList<>();
        String last = dance(instructions, danceString);
        alreadyDanced.add(last);
        while (true) {
            last = dance(instructions, last);
            if (alreadyDanced.contains(last)) {
                break;
            }
            alreadyDanced.add(last);
        }
        int size = alreadyDanced.size();
        int mod = 1000000000 % size - 1;
        return alreadyDanced.get(mod == -1 ? size - 1 : mod);
    }

    private String dance(List<String> instructions, String danceString) {
        for (String instruction : instructions) {
            if (instruction.startsWith("s")) {
                int size = Integer.parseInt(instruction.substring(1, instruction.length()));
                int length = danceString.length();
                danceString = danceString.substring(length - size) + danceString.substring(0, length - size);
            } else if (instruction.startsWith("x")) {
                String[] split = instruction.replace("x", "").split("/");
                int index1 = Integer.parseInt(split[0]);
                int index2 = Integer.parseInt(split[1]);
                char c1 = danceString.charAt(index1);
                char c2 = danceString.charAt(index2);
                StringBuilder sb = new StringBuilder(danceString);
                sb.setCharAt(index1, c2);
                sb.setCharAt(index2, c1);
                danceString = sb.toString();
            } else if (instruction.startsWith("p")) {
                char c1 = instruction.substring(1, 2).toCharArray()[0];
                char c2 = instruction.substring(3, 4).toCharArray()[0];
                int index1 = danceString.indexOf(c1);
                int index2 = danceString.indexOf(c2);
                StringBuilder sb = new StringBuilder(danceString);
                sb.setCharAt(index1, c2);
                sb.setCharAt(index2, c1);
                danceString = sb.toString();
            }
        }
        return danceString;
    }

}
