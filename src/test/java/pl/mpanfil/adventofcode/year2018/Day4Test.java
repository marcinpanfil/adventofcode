package pl.mpanfil.adventofcode.year2018;

import org.junit.Test;
import pl.mpanfil.adventofcode.util.FileUtil;

import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Day4Test {

    private Day4 day4 = new Day4();

    @Test
    public void testSolve1() {
        List<String> input = getTestInput();
        assertEquals(240, day4.solve1(input));
    }

    @Test
    public void testSolve2() {
        List<String> input = getTestInput();
        assertEquals(4455, day4.solve2(input));
    }

    @Test
    public void testSolution1() throws URISyntaxException {
        System.out.println(day4.solve1(FileUtil.readFile("2018/day4_1.txt")));
        assertEquals(99759, day4.solve1(FileUtil.readFile("2018/day4_1.txt")));
    }

    @Test
    public void testSolution2() throws URISyntaxException {
        System.out.println(day4.solve2(FileUtil.readFile("2018/day4_1.txt")));
        assertEquals(97884, day4.solve2(FileUtil.readFile("2018/day4_1.txt")));
    }

    private List<String> getTestInput() {
        return Arrays.asList(
                "[1518-11-01 00:00] Guard #10 begins shift",
                "[1518-11-01 00:05] falls asleep",
                "[1518-11-01 00:25] wakes up",
                "[1518-11-01 00:30] falls asleep",
                "[1518-11-01 00:55] wakes up",
                "[1518-11-01 23:58] Guard #99 begins shift",
                "[1518-11-02 00:40] falls asleep",
                "[1518-11-02 00:50] wakes up",
                "[1518-11-03 00:05] Guard #10 begins shift",
                "[1518-11-03 00:24] falls asleep",
                "[1518-11-03 00:29] wakes up",
                "[1518-11-04 00:02] Guard #99 begins shift",
                "[1518-11-04 00:36] falls asleep",
                "[1518-11-04 00:46] wakes up",
                "[1518-11-05 00:03] Guard #99 begins shift",
                "[1518-11-05 00:45] falls asleep",
                "[1518-11-05 00:55] wakes up"
        );
    }

}