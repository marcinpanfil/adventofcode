package pl.mpanfil.adventofcode.year2015;

import org.junit.Test;
import pl.mpanfil.adventofcode.util.FileUtil;

import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class Day2Test {

    private final Day2 day2 = new Day2();

    @Test
    public void testSolve1() {
        assertEquals(58, day2.solve1(Collections.singletonList("2x3x4")));
        assertEquals(43, day2.solve1(Collections.singletonList("1x1x10")));
    }

    @Test
    public void testSolve2() {
        assertEquals(34, day2.solve2(Collections.singletonList("2x3x4")));
        assertEquals(14, day2.solve2(Collections.singletonList("1x1x10")));
    }

    @Test
    public void testSolution1() throws URISyntaxException {
        System.out.println(day2.solve1(FileUtil.readFile("2015/day2_1.txt")));
    }

    @Test
    public void testSolution2() throws URISyntaxException {
        System.out.println(day2.solve2(FileUtil.readFile("2015/day2_1.txt")));
    }

}
