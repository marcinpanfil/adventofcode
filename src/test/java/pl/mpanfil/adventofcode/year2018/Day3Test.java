package pl.mpanfil.adventofcode.year2018;

import org.junit.Test;
import pl.mpanfil.adventofcode.util.FileUtil;

import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Day3Test {

    private Day3 day3 = new Day3();

    @Test
    public void solve1() {
        List<String> input = Arrays.asList("#1 @ 1,3: 4x4", "#2 @ 3,1: 4x4", "#3 @ 5,5: 2x2");
        assertEquals(4, day3.solve1(input));
    }

    @Test
    public void solve2() {
        List<String> input = Arrays.asList("#1 @ 1,3: 4x4", "#2 @ 3,1: 4x4", "#3 @ 5,5: 2x2");
        assertEquals(3, day3.solve2(input));
    }

    @Test
    public void solution1() throws URISyntaxException {
        System.out.println(day3.solve1(FileUtil.readFile("2018/day3_1_2.txt")));
    }

    @Test
    public void solution2() throws URISyntaxException {
        System.out.println(day3.solve2(FileUtil.readFile("2018/day3_1_2.txt")));
    }

}