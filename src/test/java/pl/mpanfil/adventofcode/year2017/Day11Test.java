package pl.mpanfil.adventofcode.year2017;

import org.junit.Test;
import pl.mpanfil.adventofcode.util.FileUtil;

import static org.junit.Assert.assertEquals;

public class Day11Test {

    private final Day11 day11 = new Day11();

    @Test
    public void testSolve1() throws Exception {
        assertEquals(3, day11.solve1("ne,ne,ne"));
        assertEquals(0, day11.solve1("ne,ne,sw,sw"));
        assertEquals(2, day11.solve1("ne,ne,s,s"));
        assertEquals(3, day11.solve1("se,sw,se,sw,sw"));
    }

    @Test
    public void testSolution1() throws Exception {
        System.out.println(day11.solve1(FileUtil.readFile("2017/day11_1_2.txt").get(0)));
    }

    @Test
    public void testSolution2() throws Exception {
        System.out.println(day11.solve2(FileUtil.readFile("2017/day11_1_2.txt").get(0)));
    }
}