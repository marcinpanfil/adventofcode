package pl.mpanfil.adventofcode.year2018;

import java.util.HashMap;
import java.util.Map;

public class Day11 {

    public String solve1(int input) {
        int[][] grid = createGrid(input);

        int max = Integer.MIN_VALUE;
        int x = 0;
        int y = 0;

        for (int i = 1; i < grid.length - 3; i++) {
            for (int j = 0; j < grid[i].length - 3; j++) {
                int sum = 0;
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        sum += grid[i + k][j + l];
                    }
                }
                if (sum > max) {
                    max = sum;
                    x = i;
                    y = j;
                }
            }
        }

        return x + "," + y;
    }

    public String solve2(int input) {
        int[][] grid = createGrid(input);

        int max = Integer.MIN_VALUE;
        int x = 0;
        int y = 0;
        int size = 0;
        Map<String, Integer> result = new HashMap<>();

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid.length - i; j++) {
                for (int k = 1; k < grid[j].length - i; k++) {
                    int res = result.getOrDefault(j + ":" + k + ":" + (i - 1), grid[j][k]);
                    int sum = res + grid[j + i][k + i];
                    for (int l = 0; l < i; l++) {
                        sum += grid[j + i][k + l];
                    }
                    for (int l = 0; l < i; l++) {
                        sum += grid[j + l][k + i];
                    }
                    if (sum > max) {
                        max = sum;
                        x = j;
                        y = k;
                        size = i + 1;
                    }
                    result.put(j + ":" + k + ":" + i, sum);
                }
            }
        }

        return x + "," + y + "," + size;
    }

    public int[][] createGrid(int input) {
        int[][] grid = new int[301][301];
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[i].length; j++) {
                int rackId = i + 10;
                int powerLvl = rackId * j;
                powerLvl += input;
                powerLvl *= rackId;
                powerLvl = (powerLvl % 1000) / 100;
                powerLvl -= 5;
                grid[i][j] = powerLvl;
            }
        }
        return grid;
    }

}
