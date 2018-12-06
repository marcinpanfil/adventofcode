package pl.mpanfil.adventofcode.year2018;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Day6 {

    private int maxX = 0;
    private int maxY = 0;

    public int solve1(List<String> input) {
        List<Point> points = parse(input);
        int[][] data = new int[maxX + 1][maxY + 1];
        fillData(points, data);

        List<Integer> count = new ArrayList<>(Collections.nCopies(points.size(), 0));
        List<Integer> infinite = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                int value = data[i][j];
                if (value != -1) {
                    if (i == 0 || j == 0 || i == maxX || j == maxY) {
                        infinite.add(value);
                    } else {
                        int counter = count.get(value) + 1;
                        count.set(value, counter);
                    }
                }
            }
        }

        List<Integer> toDelete = infinite.stream().distinct().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        for (Integer i : toDelete) {
            count.remove((int) i);
        }
        return count.stream().max(Integer::compareTo).get();
    }

    public int solve2(List<String> input, int maxDistance) {
        List<Point> points = parse(input);
        int[][] data = new int[maxX + 1][maxY + 1];
        int regionSize = 0;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                int sum = 0;
                for (Point point : points) {
                    sum = sum + calculateDistance(i, j, point);
                }
                if (sum < maxDistance) {
                    regionSize++;
                }
            }
        }
        return regionSize;
    }

    private void print(String[][] data) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void fillData(List<Point> points, int[][] data) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                Point nearestPoint = null;
                int minDistance = Integer.MAX_VALUE;
                boolean manyPoints = false;
                for (Point point : points) {
                    if (point.x == i && point.y == j) {
                        nearestPoint = null;
                        data[i][j] = point.id;
                        break;
                    }
                    int distance = calculateDistance(i, j, point);
                    if (distance < minDistance) {
                        minDistance = distance;
                        nearestPoint = point;
                        manyPoints = false;
                    } else if (distance == minDistance) {
                        manyPoints = true;
                    }
                }
                if (nearestPoint != null) {
                    if (manyPoints) {
                        data[i][j] = -1;
                    } else {
                        data[i][j] = nearestPoint.id;
                    }
                }
            }
        }
    }

    private int calculateDistance(int x, int y, Point point) {
        return Math.abs(point.x - x) + Math.abs(point.y - y);
    }

    private List<Point> parse(List<String> input) {
        this.maxY = 0;
        this.maxX = 0;
        ArrayList<Point> points = new ArrayList<>();
        for (int i = 0; i < input.size(); i++) {
            String line = input.get(i);
            String[] pointStr = line.replace(" ", "").split(",");
            int x = Integer.parseInt(pointStr[1]);
            int y = Integer.parseInt(pointStr[0]);
            points.add(new Point(x, y, i));
            if (x > maxX) {
                maxX = x;
            }
            if (y > maxY) {
                maxY = y;
            }
        }
        return points;
    }

    private static class Point {
        int x;
        int y;
        int id;

        Point(int x, int y, int id) {
            this.x = x;
            this.y = y;
            this.id = id;
        }
    }

}
