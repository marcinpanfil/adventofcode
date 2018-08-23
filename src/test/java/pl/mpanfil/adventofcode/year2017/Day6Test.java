package pl.mpanfil.adventofcode.year2017;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import pl.mpanfil.adventofcode.year2017.Day6;

import java.util.ArrayList;
import java.util.Arrays;

public class Day6Test {

    private Day6 day6 = new Day6();

    @Test
    public void testSolve1() {
        assertEquals(5, day6.solve1(new ArrayList<>(Arrays.asList(0, 2, 7, 0))));
    }

    @Test
    public void testSolve2() {
        assertEquals(4, day6.solve2(new ArrayList<>(Arrays.asList(0, 2, 7, 0))));
    }

    @Test
    public void testSolution1() {
        System.out.println(day6.solve1(Arrays.asList(10, 3, 15, 10, 5, 15, 5, 15, 9, 2, 5, 8, 5, 2, 3, 6)));
    }

    @Test
    public void testSolution2() {
        System.out.println(day6.solve2(Arrays.asList(10, 3, 15, 10, 5, 15, 5, 15, 9, 2, 5, 8, 5, 2, 3, 6)));
    }

}