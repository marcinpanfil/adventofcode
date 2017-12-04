package pl.mpanfil.adventofcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class Day3Test {

    private Day3 day3 = new Day3();

    @Test
    public void testSolve2() {
        assertEquals(806, day3.solve2(800));
        assertEquals(330, day3.solve2(306));
    }

    @Test
    public void testSolve1() {
        assertEquals(3, day3.solve1(10));
        assertEquals(2, day3.solve1(11));
        assertEquals(3, day3.solve1(12));
        assertEquals(4, day3.solve1(13));
        assertEquals(3, day3.solve1(14));
        assertEquals(2, day3.solve1(15));
        assertEquals(3, day3.solve1(16));
        assertEquals(4, day3.solve1(17));
        assertEquals(3, day3.solve1(18));
        assertEquals(2, day3.solve1(19));
        assertEquals(3, day3.solve1(20));
        assertEquals(4, day3.solve1(21));
        assertEquals(3, day3.solve1(22));
        assertEquals(2, day3.solve1(23));
        assertEquals(3, day3.solve1(24));
        assertEquals(4, day3.solve1(25));
        assertEquals(5, day3.solve1(26));
        assertEquals(31, day3.solve1(1024));
    }

    @Test
    public void testSolution1() {
        System.out.println(day3.solve1(368078));
    }

    @Test
    public void testSolution2() {
        System.out.println(day3.solve2(368078));
    }
}