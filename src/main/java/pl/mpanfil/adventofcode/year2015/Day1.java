package pl.mpanfil.adventofcode.year2015;

import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

class Day1 {


    public int solve1(String input) {
        int openPar = StringUtils.countMatches(input, "(");
        int closePar = StringUtils.countMatches(input, ")");
        return openPar - closePar;
    }

    public int solve2(String input) {
        List<Character> characters = input.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        int flor = 0;
        for (int i = 0; i < characters.size(); i++) {
            Character character = characters.get(i);
            if (character == '(') {
                flor++;
            } else if (character == ')') {
                flor--;
            }
            if (flor == -1) {
                return i + 1;
            }
        }
        return 0;
    }
}
