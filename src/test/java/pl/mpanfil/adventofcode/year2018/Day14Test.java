package pl.mpanfil.adventofcode.year2018;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Day14Test {

    private Day14 day14 = new Day14();

    @Test
    public void testSolve1() {
        assertEquals("5158916779", day14.solve1(9));
        assertEquals("0124515891", day14.solve1(5));
        assertEquals("9251071085", day14.solve1(18));
        assertEquals("5941429882", day14.solve1(2018));
    }

    @Test
    public void testSolve2() {
        assertEquals(9, day14.solve2("51589"));
        assertEquals(5, day14.solve2("01245"));
        assertEquals(18, day14.solve2("92510"));
        assertEquals(2018, day14.solve2("59414"));
    }

    @Test
    public void testSolution1() {
        String result = day14.solve1(110201);
        assertEquals("6107101544", result);
    }

    @Test
    public void testSolution2() {
        int result = day14.solve2("110201");
        assertEquals(20291131, result);
    }
}