package pl.mpanfil.adventofcode.year2018;

import org.junit.Test;
import pl.mpanfil.adventofcode.util.FileUtil;

import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Day12Test {

    private Day12 day12 = new Day12();

    @Test
    public void testSolve1() {
        assertEquals(325, day12.solve1("#..#.#..##......###...###", getInstructions(), 20));
    }

    @Test
    public void testSolution1() throws URISyntaxException {
        int result = day12.solve1(
                "#.#.#..##.#....#.#.##..##.##..#..#...##....###..#......###.#..#.....#.###.#...#####.####...#####.#.#",
                FileUtil.readFile("2018/day12_1_2.txt"), 20);
        assertEquals(1917, result);
    }

    @Test
    public void testSolution2() throws URISyntaxException {
        long result = day12.solve2(
                "#.#.#..##.#....#.#.##..##.##..#..#...##....###..#......###.#..#.....#.###.#...#####.####...#####.#.#",
                FileUtil.readFile("2018/day12_1_2.txt"));
        assertEquals(1250000000991L, result);
    }


    private List<String> getInstructions() {
        return Arrays.asList(
                "...## => #",
                "..#.. => #",
                ".#... => #",
                ".#.#. => #",
                ".#.## => #",
                ".##.. => #",
                ".#### => #",
                "#.#.# => #",
                "#.### => #",
                "##.#. => #",
                "##.## => #",
                "###.. => #",
                "###.# => #",
                "####. => #  "
        );
    }


}