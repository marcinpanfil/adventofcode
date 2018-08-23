package pl.mpanfil.adventofcode.year2017;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import pl.mpanfil.adventofcode.year2017.Day15;

public class Day15Test {

    private Day15 day15 = new Day15();

    @Test
    public void testSolve1() {
        assertEquals(588, day15.solve1(1092455, 430625591, 16807, 48271));
    }

    @Test
    public void testSolve2() {
        assertEquals(309, day15.solve2(1092455, 430625591, 16807, 48271));
    }

    @Test
    public void testSolution1() {
        System.out.println(day15.solve1(289 * 16807, 629 * 48271, 16807, 48271));
    }

    @Test
    public void testSolution2() {
        System.out.println(day15.solve2(289 * 16807, 629 * 48271, 16807, 48271));
    }

}