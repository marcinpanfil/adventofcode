package pl.mpanfil.adventofcode.year2017;

import org.junit.Test;
import pl.mpanfil.adventofcode.util.FileUtil;

public class Day23Test {

    private final Day23 day23 = new Day23();

    @Test
    public void testSolution1() throws Exception {
        System.out.println(day23.solve1(FileUtil.readFile("2017/day23_1_2.txt")));
    }

    @Test
    public void testSolution2() {
        System.out.println(day23.solve2());
    }
}