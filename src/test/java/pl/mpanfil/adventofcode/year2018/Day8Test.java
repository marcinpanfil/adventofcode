package pl.mpanfil.adventofcode.year2018;

import org.junit.Test;
import pl.mpanfil.adventofcode.util.FileUtil;

import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class Day8Test {

    private Day8 day8 = new Day8();

    @Test
    public void testSolve1() {
        assertEquals(138, day8.solve1(createInput1()));
        assertEquals(11, day8.solve1(createInput2()));
    }

    @Test
    public void testSolve2() {
        assertEquals(66, day8.solve2(createInput1()));
        assertEquals(4, day8.solve2(createInput2()));
    }

    @Test
    public void testSolution1() throws URISyntaxException {
        int result = day8.solve1(FileUtil.readOneLineFileAsIntList("2018/day8_1_2.txt"));
        assertEquals(41028, result);
    }

    @Test
    public void testSolution2() throws URISyntaxException {
        int result = day8.solve2(FileUtil.readOneLineFileAsIntList("2018/day8_1_2.txt"));
        assertEquals(20849, result);
    }

    private List<Integer> createInput1() {
        List<String> str = Arrays.asList("2", "3", "0", "3", "10", "11", "12", "1", "1", "0", "1", "99", "2", "1", "1", "2");
        return str.stream().map(Integer::valueOf).collect(Collectors.toList());
    }

    private List<Integer> createInput2() {
        List<String> str = Arrays.asList("2", "1", "1", "1", "0", "1", "4", "1", "1", "1", "0", "1", "3", "2", "1");
        return str.stream().map(Integer::valueOf).collect(Collectors.toList());
    }

}