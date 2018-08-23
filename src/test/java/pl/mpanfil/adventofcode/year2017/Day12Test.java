package pl.mpanfil.adventofcode.year2017;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import pl.mpanfil.adventofcode.util.FileUtil;
import pl.mpanfil.adventofcode.year2017.Day12;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class Day12Test {

    private Day12 day12 = new Day12();

    @Test
    public void testSolve1() {
        List<String> lines = createInput();
        assertEquals(6, day12.solve1(lines));
    }

    @Test
    public void testSolve2() {
        List<String> lines = createInput();
        assertEquals(2, day12.solve2(lines));
    }

    @Test
    public void testSolution1() throws URISyntaxException {
        System.out.println(day12.solve1(FileUtil.readFile("day12_1_2.txt")));
    }

    @Test
    public void testSolution2() throws URISyntaxException {
        System.out.println(day12.solve2(FileUtil.readFile("day12_1_2.txt")));
    }

    private List<String> createInput() {
        return new ArrayList<String>() {{
            add("0 <-> 2");
            add("1 <-> 1");
            add("2 <-> 0, 3, 4");
            add("3 <-> 2, 4");
            add("4 <-> 2, 3, 6");
            add("6 <-> 4, 5");
        }};
    }
}