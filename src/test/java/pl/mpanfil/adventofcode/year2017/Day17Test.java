package pl.mpanfil.adventofcode.year2017;

import org.junit.Test;
import pl.mpanfil.adventofcode.year2017.Day17;

import static org.junit.Assert.assertEquals;

public class Day17Test {

    private Day17 day17 = new Day17();

    @Test
    public void testSolve1() {
        assertEquals(638, day17.solve1(3));
    }

    @Test
    public void testSolve2() {
        assertEquals(1226, day17.solve2(3, 2018));
    }


    @Test
    public void testSolution1() {
        System.out.println(day17.solve1(366));
    }

    @Test
    public void testSolution2() {
        System.out.println(day17.solve2(366, 50000001));
    }
}