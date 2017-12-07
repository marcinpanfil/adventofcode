package pl.mpanfil.adventofcode;

import org.junit.Test;
import pl.mpanfil.adventofcode.util.FileUtil;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class Day7Test {

    private Day7 day7 = new Day7();

    @Test
    public void testSolve1() {
        List<String> lines = createSampleData();
        assertEquals("tknk", day7.solve1(lines));
    }

    @Test
    public void testSolve2() {
        List<String> lines = createSampleData();
        assertEquals(60, day7.solve2(lines));
    }

    @Test
    public void testSolution1() throws URISyntaxException {
        System.out.println(day7.solve1(FileUtil.readFile("day7_1_2.txt")));
    }

    @Test
    public void testSolution2() throws URISyntaxException {
        System.out.println(day7.solve2(FileUtil.readFile("day7_1_2.txt")));
    }

    private List<String> createSampleData() {
        return new ArrayList<String>() {{
            add("pbga (66)");
            add("xhth (57)");
            add("ebii (61)");
            add("havc (66)");
            add("ktlj (57)");
            add("fwft (72) -> ktlj, cntj, xhth");
            add("qoyq (66)");
            add("padx (45) -> pbga, havc, qoyq");
            add("tknk (41) -> ugml, padx, fwft");
            add("jptl (61)");
            add("ugml (68) -> gyxo, ebii, jptl");
            add("gyxo (61)");
            add("cntj (57)");
        }};
    }

}