package pl.mpanfil.adventofcode.year2017;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import pl.mpanfil.adventofcode.year2017.Day14;

public class Day14Test {

    private Day14 day14 = new Day14();

    @Test
    public void testSolve1() {
        assertEquals(8108, day14.solve1("flqrgnkx"));
    }

    @Test
    public void testSolve2() {
        assertEquals(1242, day14.solve2("flqrgnkx"));
    }

    @Test
    public void testSolution1() {
        System.out.println(day14.solve1("ffayrhll"));
    }

    @Test
    public void testSolution2() {
        System.out.println(day14.solve2("ffayrhll"));
    }
}