package pl.mpanfil.adventofcode.year2017;

import java.util.Arrays;
import java.util.Collections;

class Day11 {

    int solve1(String input) throws Exception {
        String[] directions = input.split(",");
        int x = 0;
        int y = 0;
        for (String direction : directions) {
            switch (direction) {
                case "n":
                    y++;
                    break;
                case "ne":
                    x++;
                    y++;
                    break;
                case "se":
                    x++;
                    break;
                case "sw":
                    x--;
                    y--;
                    break;
                case "nw":
                    x--;
                    break;
                case "s":
                    y--;
                    break;
                default:
                    throw new Exception("something is wrong");
            }
        }
        return calculateDistance(x, y);
    }

    private int calculateDistance(int x, int y) {
        int dx = 0 - x;
        int dy = 0 - y;
        int d = Math.abs(dy - dx);
        return Collections.max(Arrays.asList(Math.abs(dx), Math.abs(dy), d));
    }

    int solve2(String input) throws Exception {
        String[] directions = input.split(",");
        int x = 0;
        int y = 0;
        int maxDistance = Integer.MIN_VALUE;
        for (String direction : directions) {
            switch (direction) {
                case "n":
                    y++;
                    break;
                case "ne":
                    x++;
                    y++;
                    break;
                case "se":
                    x++;
                    break;
                case "sw":
                    x--;
                    y--;
                    break;
                case "nw":
                    x--;
                    break;
                case "s":
                    y--;
                    break;
                default:
                    throw new Exception("something is wrong");
            }
            int currentDistance = calculateDistance(x, y);
            if (currentDistance > maxDistance) {
                maxDistance = currentDistance;
            }
        }
        return maxDistance;
    }

}
