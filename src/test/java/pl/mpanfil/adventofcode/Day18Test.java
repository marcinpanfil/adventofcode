package pl.mpanfil.adventofcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import pl.mpanfil.adventofcode.util.FileUtil;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class Day18Test {

    private Day18 day18 = new Day18();

    @Test
    public void testSolve1() {
        List<String> instructions = new ArrayList<String>() {{
            add("set a 1");
            add("add a 2");
            add("mul a a");
            add("mod a 5");
            add("snd a");
            add("set a 0");
            add("rcv a");
            add("jgz a -1");
            add("set a 1");
            add("jgz a -2");
        }};
        assertEquals(4, day18.solve1(instructions));
    }

    @Test
    public void testSolution1() throws URISyntaxException {
//        System.out.println(day17.solve1(FileUtil.readFile("day18_1_2.txt")));
        assertEquals(4601, day18.solve1(FileUtil.readFile("day18_1_2.txt")));
    }
}