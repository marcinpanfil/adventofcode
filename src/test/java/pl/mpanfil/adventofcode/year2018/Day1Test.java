package pl.mpanfil.adventofcode.year2018;

import org.junit.Test;
import pl.mpanfil.adventofcode.util.FileUtil;

import java.net.URISyntaxException;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class Day1Test {

    private Day1 day1 = new Day1();

    @Test
    public void testSolve1() {
        int sum1 = day1.solve1(Arrays.asList(1, 1, 1));
        assertEquals(3, sum1);
        int sum2 = day1.solve1(Arrays.asList(-1, -2, -3));
        assertEquals(-6, sum2);
    }

    @Test
    public void testSolve2() throws Exception {
        int result1 = day1.solve2(Arrays.asList(+3, +3, +4, -2, -4));
        assertEquals(10, result1);
        int result2 = day1.solve2(Arrays.asList(-6, +3, +8, +5, -6));
        assertEquals(5, result2);
    }

    @Test
    public void testSolution1() throws URISyntaxException {
        System.out.println(day1.solve1(FileUtil.readFileAsIntList("2018/day1_1_2.txt")));
    }

    @Test
    public void testSolution2() throws Exception {
        System.out.println(day1.solve2(FileUtil.readFileAsIntList("2018/day1_1_2.txt")));
    }
}