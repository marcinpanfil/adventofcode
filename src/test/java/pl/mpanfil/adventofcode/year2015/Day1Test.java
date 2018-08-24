package pl.mpanfil.adventofcode.year2015;

import org.junit.Test;
import pl.mpanfil.adventofcode.util.FileUtil;

import java.net.URISyntaxException;

import static org.junit.Assert.*;

public class Day1Test {

    private final Day1 day1 = new Day1();

    @Test
    public void testSolve1() {
        assertEquals(0, day1.solve1("(())"));
        assertEquals(0, day1.solve1("()()"));
        assertEquals(3, day1.solve1("((("));
        assertEquals(3, day1.solve1("(()(()("));
        assertEquals(3, day1.solve1("))((((("));
        assertEquals(3, day1.solve1("))((((("));
        assertEquals(-1, day1.solve1("())"));
        assertEquals(-1, day1.solve1("))("));
        assertEquals(-3, day1.solve1(")))"));
        assertEquals(-3, day1.solve1(")())())"));
    }

    @Test
    public void testSolve2() {
        assertEquals(1, day1.solve2(")"));
        assertEquals(5, day1.solve2("()())"));
    }

    @Test
    public void testSolution1() throws URISyntaxException {
        System.out.println(day1.solve1(FileUtil.readFile("2015/day1_1.txt").get(0)));
    }

    @Test
    public void testSolution2() throws URISyntaxException {
        System.out.println(day1.solve2(FileUtil.readFile("2015/day1_1.txt").get(0)));
    }

}