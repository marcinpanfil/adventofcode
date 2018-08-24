package pl.mpanfil.adventofcode.year2017;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import pl.mpanfil.adventofcode.util.FileUtil;

import java.util.ArrayList;
import java.util.List;

public class Day8Test {

    private Day8 day8 = new Day8();

    @Test
    public void testSolve1() throws Exception {
        List<String> lines = createLines();
        assertEquals(1, day8.solve1(lines));
    }

    @Test
    public void testSolve2() throws Exception {
        List<String> lines = createLines();
        assertEquals(10, day8.solve2(lines));
    }

    @Test
    public void testSolution1() throws Exception {
        System.out.println(day8.solve1(FileUtil.readFile("2017/day8_1_2.txt")));
    }

    @Test
    public void testSolution2() throws Exception {
        System.out.println(day8.solve2(FileUtil.readFile("2017/day8_1_2.txt")));
    }


    private List<String> createLines() {
        return new ArrayList<>() {{
            add("b inc 5 if a > 1");
            add("a inc 1 if b < 5");
            add("c dec -10 if a >= 1");
            add("c inc -20 if c == 10");
        }};
    }
}