package pl.mpanfil.adventofcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import pl.mpanfil.adventofcode.util.FileUtil;
import pl.mpanfil.adventofcode.util.StringUtil;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class Day16Test {

    private Day16 day16 = new Day16();

    @Test
    public void testSolve1() {
        List<String> instructions = new ArrayList<String>() {{
            add("s1");
            add("x3/4");
            add("pe/b");
        }};
        assertEquals("baedc", day16.solve1(instructions, "abcde"));
    }

    @Test
    public void testSolve1a() {
        List<String> instructions = new ArrayList<String>() {{
            add("s15");
        }};
        assertEquals("bcdefghijklmnopa", day16.solve1(instructions, "abcdefghijklmnop"));
    }

    @Test
    public void testSolve1b() {
        List<String> instructions = new ArrayList<String>() {{
            add("x10/11");
            add("x0/15");
        }};
        assertEquals("pbcdefghijlkmnoa", day16.solve1(instructions, "abcdefghijklmnop"));
    }

    @Test
    public void testSolve1c() {
        List<String> instructions = new ArrayList<String>() {{
            add("pa/p");
            add("pa/b");
        }};
        assertEquals("pacdefghijklmnob", day16.solve1(instructions, "abcdefghijklmnop"));
    }

    @Test
    public void testSolution1() throws URISyntaxException {
        System.out.println(day16.solve1(StringUtil.split(FileUtil.readFile("day16_1_2.txt").get(0)),
                "abcdefghijklmnop"));
    }


}