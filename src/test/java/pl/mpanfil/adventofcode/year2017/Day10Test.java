package pl.mpanfil.adventofcode.year2017;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import pl.mpanfil.adventofcode.util.StringUtil;
import pl.mpanfil.adventofcode.year2017.Day10;

import java.util.ArrayList;
import java.util.List;

public class Day10Test {

    private Day10 day10 = new Day10();

    @Test
    public void testSolve1() {
        List<Integer> input = new ArrayList<Integer>() {{
            add(3);
            add(4);
            add(1);
            add(5);
        }};
        assertEquals(12, day10.solve1(input, 5));
    }

    @Test
    public void testSolve2() {
        assertEquals("3efbe78a8d82f29979031a4aa0b16a9d", day10.solve2("1,2,3", 256));
        assertEquals("63960835bcdc130f0b66d7ff4f6a5a8e", day10.solve2("1,2,4", 256));
        assertEquals("33efeb34ea91902bb2f59c9920caa6cd", day10.solve2("AoC 2017", 256));
        assertEquals("a2582a3a0e66e6e86e3812dcb672a272", day10.solve2("", 256));
    }

    @Test
    public void testSolution1() {
        System.out.println(day10.solve1(
                StringUtil.splitAndConvert("212,254,178,237,2,0,1,54,167,92,117,125,255,61,159,164"),
                256));
    }

    @Test
    public void testSolution2() {
        System.out.println(day10.solve2("212,254,178,237,2,0,1,54,167,92,117,125,255,61,159,164", 256));
    }


}