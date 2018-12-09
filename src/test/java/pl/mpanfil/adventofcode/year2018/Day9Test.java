package pl.mpanfil.adventofcode.year2018;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Day9Test {

    private Day9 day9 = new Day9();


    @Test
    public void testSolve1() {
        assertEquals(32, day9.solve1(9, 25));
        assertEquals(8317, day9.solve1(10, 1618));
        assertEquals(146373, day9.solve1(13, 7999));
        assertEquals(2764, day9.solve1(17, 1104));
        assertEquals(54718, day9.solve1(21, 6111));
        assertEquals(37305, day9.solve1(30, 5807));
    }

    @Test
    public void testSolution1() {
        long result = day9.solve1(428, 72061);
        assertEquals(409832, result);
    }

    @Test
    public void testSolution2() {
        System.out.println(day9.solve2(428, 7206100));
    }

}