package pl.mpanfil.adventofcode.year2015;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Day2 {

    public long solve1(List<String> input) {
        long sum = 0;
        Pattern p = Pattern.compile("-?\\d+");
        for (String line : input) {
            Matcher m = p.matcher(line);
            int x = m.find() ? Integer.parseInt(m.group()) : 0;
            int y = m.find() ? Integer.parseInt(m.group()) : 0;
            int z = m.find() ? Integer.parseInt(m.group()) : 0;
            sum += (2 * x * y + 2 * y * z + 2 * x * z) + (x * y * z / Collections.max(Arrays.asList(x, y, z)));
        }
        return sum;
    }

    public long solve2(List<String> input) {
        long sum = 0;
        Pattern p = Pattern.compile("-?\\d+");
        for (String line : input) {
            Matcher m = p.matcher(line);
            int x = m.find() ? Integer.parseInt(m.group()) : 0;
            int y = m.find() ? Integer.parseInt(m.group()) : 0;
            int z = m.find() ? Integer.parseInt(m.group()) : 0;
            sum += (x * y * z) + (2 * x + 2 * y + 2 * z - 2 * Collections.max(Arrays.asList(x, y, z)));
        }
        return sum;
    }
}
