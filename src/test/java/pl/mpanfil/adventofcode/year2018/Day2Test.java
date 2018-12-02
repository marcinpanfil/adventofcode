package pl.mpanfil.adventofcode.year2018;

import org.junit.Test;
import pl.mpanfil.adventofcode.util.FileUtil;

import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Day2Test {

    private Day2 day2 = new Day2();

    @Test
    public void solve1() {
        List<String> input = Arrays.asList("abcdef", "bababc", "abbcde", "abcccd", "aabcdd", "abcdee", "ababab");
        assertEquals(12, day2.solve1(input));
    }

    @Test
    public void solve2() {
        List<String> input = Arrays.asList("abcde", "fghij", "klmno", "pqrst", "fguij", "axcye", "wvxyz");
        assertEquals("fgij", day2.solve2(input));
    }

    @Test
    public void solution1() throws URISyntaxException {
        System.out.println(day2.solve1(FileUtil.readFile("2018/day2_1_2.txt")));
    }

    @Test
    public void solution2() throws URISyntaxException {
        System.out.println(day2.solve2(FileUtil.readFile("2018/day2_1_2.txt")));
    }
}