package pl.mpanfil.adventofcode.year2017;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import pl.mpanfil.adventofcode.util.FileUtil;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day9Test {

    private final Day9 day9 = new Day9();

    @Test
    public void testSolve1Case1() {
        List<String> lines = createList("{}", "{{{}}}", "{{},{}}");
        assertEquals(12, day9.solve1(lines));
    }

    @Test
    public void testSolve1Case2() {
        List<String> lines = createList("{{{},{},{{}}}}", "{<a>,<a>,<a>,<a>}");
        assertEquals(17, day9.solve1(lines));
    }

    @Test
    public void testSolve1Case3() {
        List<String> lines = createList("{{<ab>},{<ab>},{<ab>},{<ab>}}", "{{<!!>},{<!!>},{<!!>},{<!!>}}");
        assertEquals(18, day9.solve1(lines));
    }

    @Test
    public void testSolve1Case4() {
        List<String> lines = createList("{{!{}}", "{{<!!>},{<!!>},{<!!>},{<!!>}}");
        assertEquals(12, day9.solve1(lines));
    }

    @Test
    public void testSolve1Case5() {
        List<String> lines = createList("{{<a!>},{<a!>},{<a!>},{<ab>}}");
        assertEquals(3, day9.solve1(lines));
    }

    @Test
    public void testSolution1() throws URISyntaxException {
        System.out.println(day9.solve1(FileUtil.readFile("2017/day9_1_2.txt")));
    }

    @Test
    public void testSolve2Case1() {
        List<String> lines = createList("<>", "<random characters>");
        assertEquals(17, day9.solve2(lines));
    }

    @Test
    public void testSolve2Case2() {
        List<String> lines = createList("<<<<>", "<{!>}>");
        assertEquals(5, day9.solve2(lines));
    }

    @Test
    public void testSolve2Case3() {
        List<String> lines = createList("<!!>", "<!!!>>", "<{o\"i!a,<{i<a>");
        assertEquals(10, day9.solve2(lines));
    }

    @Test
    public void testSolution2() throws URISyntaxException {
        System.out.println(day9.solve2(FileUtil.readFile("2017/day9_1_2.txt")));
    }

    private List<String> createList(String... str) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, str);
        return list;
    }

}