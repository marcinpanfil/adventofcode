package pl.mpanfil.adventofcode.year2018;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Day11Test {

    private Day11 day10 = new Day11();

    @Test
    public void testSolve1() {
        assertEquals("33,45", day10.solve1(18));
        assertEquals("21,61", day10.solve1(42));
    }

    @Test
    public void testSolve2() {
        assertEquals("90,269,16", day10.solve2(18));
        assertEquals("232,251,12", day10.solve2(42));
    }

    @Test
    public void testSolution1() {
        String result = day10.solve1(4455);
        assertEquals("21,54", result);
    }

    @Test
    public void testSolution2() {
        String result = day10.solve2(4455);
        assertEquals("236,268,11", result);
    }

    @Test
    public void testCreateGrid() {
        int[][] grid1 = day10.createGrid(57);
        assertEquals(-5, grid1[122][79]);
        int[][] grid2 = day10.createGrid(39);
        assertEquals(0, grid2[217][196]);
        int[][] grid3 = day10.createGrid(71);
        assertEquals(4, grid3[101][153]);
    }
}