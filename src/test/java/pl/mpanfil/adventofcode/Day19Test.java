package pl.mpanfil.adventofcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import pl.mpanfil.adventofcode.util.FileUtil;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class Day19Test {

    private Day19 day19 = new Day19();

    @Test
    public void testSolve1() {
        List<String> lines = createTestData();
        assertEquals("ABCDEF", day19.solve1(lines));
    }

    @Test
    public void testSolve2() {
        List<String> lines = createTestData();
        assertEquals(38, day19.solve2(lines));
    }

    @Test
    public void testSolution1() throws URISyntaxException {
        System.out.println(day19.solve1(FileUtil.readFile("day19_1_2.txt")));
    }

    @Test
    public void testSolution2() throws URISyntaxException {
        System.out.println(day19.solve2(FileUtil.readFile("day19_1_2.txt")));
    }

    private List<String> createTestData() {
        return new ArrayList<String>() {{
            add("     |          ");
            add("     |  +--+    ");
            add("     A  |  C    ");
            add(" F---|----E|--+ ");
            add("     |  |  |  D ");
            add("     +B-+  +--+ ");
        }};
    }
}