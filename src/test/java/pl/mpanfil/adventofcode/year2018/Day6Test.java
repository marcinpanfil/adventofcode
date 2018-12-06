package pl.mpanfil.adventofcode.year2018;

import org.junit.Test;
import pl.mpanfil.adventofcode.util.FileUtil;

import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Day6Test {

    private Day6 day6 = new Day6();

    @Test
    public void testSolve1() {
        List<String> input = Arrays.asList("1, 1", "1, 6", "8, 3", "3, 4", "5, 5", "8, 9");
        assertEquals(17, day6.solve1(input));
    }

    @Test
    public void testSolve2() {
        List<String> input = Arrays.asList("1, 1", "1, 6", "8, 3", "3, 4", "5, 5", "8, 9");
        assertEquals(16, day6.solve2(input, 32));
    }

    @Test
    public void testSolution1() throws URISyntaxException {
        int result = day6.solve1(FileUtil.readFile("2018/day6_1_2.txt"));
        assertEquals(3840, result);
    }

    @Test
    public void testSolution2() throws URISyntaxException {
        int result = day6.solve2(FileUtil.readFile("2018/day6_1_2.txt"), 10000);
        assertEquals(46542, result);
    }
}