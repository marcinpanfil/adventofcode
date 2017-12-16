package pl.mpanfil.adventofcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import pl.mpanfil.adventofcode.util.FileUtil;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class Day13Test {

    private Day13 day13 = new Day13();

    @Test
    public void testSolve1() {
        List<String> lines = createTestList();
        assertEquals(24, day13.solve1(lines));
    }

    @Test
    public void testSolve2() {
        List<String> lines = createTestList();
        assertEquals(10, day13.solve2(lines));
    }

    @Test
    public void testSolution1() throws URISyntaxException {
        System.out.println(day13.solve1(FileUtil.readFile("day13_1_2.txt")));
    }

    @Test
    public void testSolution2() throws URISyntaxException {
        System.out.println(day13.solve2(FileUtil.readFile("day13_1_2.txt")));
    }

    private List<String> createTestList() {
        return new ArrayList<String>() {{
            add("0: 3");
            add("1: 2");
            add("4: 4");
            add("6: 4");
        }};
    }

}