package pl.mpanfil.adventofcode.year2017;

import static org.junit.Assert.*;
import org.junit.Test;
import pl.mpanfil.adventofcode.util.FileUtil;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class Day2Test {


    private Day2 day2 = new Day2();

    @Test
    public void testSolve1() {
        List<String> str = new ArrayList<String>() {{
            add("5 1 9 5");
            add("7 5 3");
            add("2 4 6 8");
        }};
        assertEquals(18, day2.solve1(str));
    }

    @Test
    public void testSolve2() {
        List<String> str = new ArrayList<String>() {{
           add("5 9 2 8");
           add("9 4 7 3");
           add("3 8 6 5");
        }};
        assertEquals(9, day2.solve2(str));
    }

    @Test
    public void testSolution1() throws URISyntaxException {
        System.out.println(day2.solve1(FileUtil.readFile("2017/day2_1.txt")));
    }

    @Test
    public void testSolution2() throws URISyntaxException {
        System.out.println(day2.solve2(FileUtil.readFile("2017/day2_2.txt")));
    }

}