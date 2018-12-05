package pl.mpanfil.adventofcode.year2018;

import org.junit.Test;
import pl.mpanfil.adventofcode.util.FileUtil;

import java.net.URISyntaxException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Day5Test {

    private Day5 day5 = new Day5();

    @Test
    public void testSolve1() {
        assertEquals(10, day5.solve1("dabAcCaCBAcCcaDA"));
        assertEquals(4, day5.solve1("kKKZUF"));
        assertEquals(2, day5.solve1("bBkKQqga"));
    }

    @Test
    public void testSolve2() {
        assertEquals(4, day5.solve2("dabAcCaCBAcCcaDA"));
    }

    @Test
    public void testSolution1() throws URISyntaxException {
        List<String> input = FileUtil.readFile("2018/day5_1_2.txt");
        System.out.println(day5.solve1(input.get(0)));
    }

    @Test
    public void testSolution2() throws URISyntaxException {
        List<String> input = FileUtil.readFile("2018/day5_1_2.txt");
        System.out.println(day5.solve2(input.get(0)));
    }
}

