package pl.mpanfil.adventofcode.year2018;

import org.junit.Test;
import pl.mpanfil.adventofcode.util.FileUtil;

import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Day7Test {

    private Day7 day7 = new Day7();

    @Test
    public void testSolve1() {
        assertEquals("CABDFE", day7.solve1(createInput()));
    }

    @Test
    public void testSolution1() throws URISyntaxException {
        String result = day7.solve1(FileUtil.readFile("2018/day7_1_2.txt"));
        assertEquals("AHJDBEMNFQUPVXGCTYLWZKSROI", result);
    }

    private List<String> createInput() {
        return Arrays.asList(
                "Step C must be finished before step A can begin.",
                "Step C must be finished before step F can begin.",
                "Step A must be finished before step B can begin.",
                "Step A must be finished before step D can begin.",
                "Step B must be finished before step E can begin.",
                "Step D must be finished before step E can begin.",
                "Step F must be finished before step E can begin."
        );
    }

}