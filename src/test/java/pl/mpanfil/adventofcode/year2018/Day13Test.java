package pl.mpanfil.adventofcode.year2018;

import org.junit.Test;
import pl.mpanfil.adventofcode.util.FileUtil;

import java.awt.*;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Day13Test {

    private Day13 day13 = new Day13();

    @Test
    public void testSolve1() {
        Point point = day13.solve1(createInput1());
        assertEquals(7, point.getX(), 0.0);
        assertEquals(3, point.getY(), 0.0);
    }

    @Test
    public void testSolve2() {
        Point point = day13.solve2(createInput2());
        assertEquals(6, point.getX(), 0.0);
        assertEquals(4, point.getY(), 0.0);
    }

    @Test
    public void testSolution1() throws URISyntaxException {
        Point result = day13.solve1(FileUtil.readFile("2018/day13_1_2.txt"));
        assertEquals(32, result.getX(), 0.0);
        assertEquals(99, result.getY(), 0.0);
    }

    @Test
    public void testSolution2() throws URISyntaxException {
        Point point = day13.solve2(FileUtil.readFile("2018/day13_1_2.txt"));
        assertEquals(56, point.getX(), 0.0);
        assertEquals(31, point.getY(), 0.0);
    }

    @Test
    public void testEdgeCase1() {
        Point point = day13.solve1(createEdgeCase1());
        assertEquals(1, point.getX(), 0.0);
        assertEquals(2, point.getY(), 0.0);
    }

    @Test
    public void testEdgeCase2() {
        Point point = day13.solve1(createEdgeCase2());
        assertEquals(2, point.getX(), 0.0);
        assertEquals(0, point.getY(), 0.0);
    }

    @Test
    public void testEdgeCase3() {
        Point point = day13.solve1(createEdgeCase3());
        assertEquals(2, point.getX(), 0.0);
        assertEquals(0, point.getY(), 0.0);
    }

    @Test
    public void testEdgeCase4() {
        Point point = day13.solve1(createEdgeCase4());
        assertEquals(1, point.getX(), 0.0);
        assertEquals(2, point.getY(), 0.0);
    }

    @Test
    public void testEdgeCase5() {
        Point point = day13.solve1(createEdgeCase5());
        assertEquals(4, point.getX(), 0.0);
        assertEquals(2, point.getY(), 0.0);
    }

    private List<String> createEdgeCase5() {
        return Arrays.asList(
                "    +<",
                "    +",
                ">---+"
        );
    }

    private List<String> createEdgeCase4() {
        return Arrays.asList(
                " +<",
                " + ",
                " \\-<"
        );
    }

    private List<String> createEdgeCase3() {
        return Arrays.asList(
                ">-+-<<"
        );
    }

    private List<String> createEdgeCase2() {
        return Arrays.asList(
                ">-+-<",
                "  | ",
                "  ^ "
        );
    }

    private List<String> createEdgeCase1() {
        return Arrays.asList(
                "+<+<+",
                "+ +  ",
                "\\-+ "
        );
    }

    private List<String> createInput1() {
        return Arrays.asList(
                "/->-\\        ",
                "|   |  /----\\",
                "| /-+--+-\\  |",
                "| | |  | v  |",
                "\\-+-/  \\-+--/",
                "  \\------/   "
        );
    }

    private List<String> createInput2() {
        return Arrays.asList(
                "/>-<\\  ",
                "|   |  ",
                "| /<+-\\",
                "| | | v",
                "\\>+</ |",
                "  |   ^",
                "  \\<->/"
        );
    }

}