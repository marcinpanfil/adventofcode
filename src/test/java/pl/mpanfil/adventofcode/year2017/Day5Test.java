package pl.mpanfil.adventofcode.year2017;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import pl.mpanfil.adventofcode.util.FileUtil;

import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

public class Day5Test {

    private Day5 day5 = new Day5();

    @Test
    public void testSolve1() throws Exception {
        List<Integer> steps = getExampleData();
        assertEquals(5, day5.solve1(steps));
    }

    @Test
    public void testSolve2() throws Exception {
        List<Integer> steps = getExampleData();
        assertEquals(10, day5.solve2(steps));
    }


    @Test
    public void testSolution1() throws URISyntaxException {
        System.out.println(day5.solve1(FileUtil.convert1ColumnLine(FileUtil.readFile("2017/day5_1_2.txt"))));
    }

    @Test
    public void testSolution2() throws URISyntaxException {
        System.out.println(day5.solve2(FileUtil.convert1ColumnLine(FileUtil.readFile("2017/day5_1_2.txt"))));
    }

    private List<Integer> getExampleData() {
        return Arrays.asList(0, 3, 0, 1, -3);
    }
}
