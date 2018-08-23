package pl.mpanfil.adventofcode.year2017;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import pl.mpanfil.adventofcode.util.FileUtil;
import pl.mpanfil.adventofcode.year2017.Day4;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class Day4Test {

    private Day4 day4 = new Day4();

    @Test
    public void solve1() throws Exception {
        List<String> lines = new ArrayList<String>() {{
            add("aa bb cc dd ee");
            add("aa bb cc dd aa");
            add("aa bb cc dd aaa");
        }};
        assertEquals(2, day4.solve1(lines));
    }

    @Test
    public void solve2() throws Exception {
        List<String> lines = new ArrayList<String>() {{
            add("abcde fghij");
            add("abcde xyz ecdab");
            add("a ab abc abd abf abj");
            add("iiii oiii ooii oooi oooo");
            add("oiii ioii iioi iiio");
        }};
        assertEquals(3, day4.solve2(lines));
    }

    @Test
    public void testSolution1() throws URISyntaxException {
        System.out.println(day4.solve1(FileUtil.readFile("day4_1_2.txt")));
    }

    @Test
    public void testSolution2() throws URISyntaxException {
        System.out.println(day4.solve2(FileUtil.readFile("day4_1_2.txt")));
    }

}