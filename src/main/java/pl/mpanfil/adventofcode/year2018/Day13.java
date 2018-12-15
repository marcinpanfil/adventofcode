package pl.mpanfil.adventofcode.year2018;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Day13 {

    public Point solve1(List<String> input) {
        List<Coordinate> coordinates = findCarts(input);
        while (true) {
            sort(coordinates);
            for (Coordinate coordinate : coordinates) {
                moveCoordinate(input, coordinate);
                Point point = checkCollision(coordinates);
                if (point != null) {
                    return point;
                }
            }
        }
    }

    public Point solve2(List<String> input) {
        List<Coordinate> coordinates = findCarts(input);
        while (coordinates.size() != 1) {
            sort(coordinates);
            List<Coordinate> toRemove = new ArrayList<>();
            for (Coordinate coordinate : coordinates) {
                moveCoordinate(input, coordinate);
                for (int i = 0; i < coordinates.size() - 1; i++) {
                    for (int j = i + 1; j < coordinates.size(); j++) {
                        Coordinate c1 = coordinates.get(i);
                        Coordinate c2 = coordinates.get(j);
                        if (c1.getX() == c2.getX() && c1.getY() == c2.getY()) {
                            toRemove.add(c1);
                            toRemove.add(c2);
                        }
                    }
                }
            }

            coordinates.removeAll(toRemove);
        }
        Coordinate coordinate = coordinates.get(0);
        return new Point(coordinate.getX(), coordinate.getY());
    }

    private void moveCoordinate(List<String> input, Coordinate coordinate) {
        int move = coordinate.getMove();
        int x = coordinate.getX();
        int y = coordinate.getY();

        if (move == 2) x++;
        else if (move == 4) x--;

        if (move == 1) y--;
        else if (move == 3) y++;

        char moveDir = input.get(y).charAt(x);
        coordinate.movePosition(moveDir);
    }

    private Point checkCollision(List<Coordinate> coordinates) {
        for (int i = 0; i < coordinates.size() - 1; i++) {
            for (int j = i + 1; j < coordinates.size(); j++) {
                Coordinate c1 = coordinates.get(i);
                Coordinate c2 = coordinates.get(j);
                if (c1.getX() == c2.getX() && c1.getY() == c2.getY()) {
                    return new Point(c1.getX(), c1.getY());
                }
            }
        }
        return null;
    }

    private List<Coordinate> findCarts(List<String> input) {
        List<Coordinate> coordinates = new ArrayList<>();
        for (int i = 0; i < input.size(); i++) {
            char[] line = input.get(i).toCharArray();
            for (int j = 0; j < line.length; j++) {
                char current = line[j];
                if (current == '<' || current == '>' || current == 'v' || current == '^') {
                    Coordinate coordinate = new Coordinate(j, i, getDirection(current));
                    coordinates.add(coordinate);
                    if (current == '<' || current == '>') {
                        line[j] = '-';
                    } else {
                        line[j] = '|';
                    }
                    input.set(i, new String(line));
                }
            }
        }
        return coordinates;
    }

    private List<Coordinate> sort(List<Coordinate> coordinates) {
        coordinates.sort((o1, o2) -> {
            if (o1.getY() > o2.getY()) {
                return 1;
            } else if (o1.getY() == o2.getY()) {
                if (o1.getX() > o2.getX()) {
                    return 1;
                }
            }
            return -1;
        });
        return coordinates;
    }

    private int getDirection(char move) {
        switch (move) {
            case '^':
                return 1;
            case '>':
                return 2;
            case 'v':
                return 3;
            case '<':
                return 4;
        }
        return -1;
    }

    class Coordinate {
        private int x;
        private int y;
        private int move;
        private int option;

        Coordinate(int x, int y, int move) {
            this.x = x;
            this.y = y;
            this.move = move; //1 - north, 2 - east, 3 - south, 4 - west
            this.option = 0; //0 - left, 1 - straight, 2 - right
        }

        void movePosition(char moveDir) {
            move();
            if (moveDir == '+') {
                switch (this.option) {
                    case 0:
                        moveLeft();
                        break;
                    case 1:
                        break;
                    case 2:
                        moveRight();
                        break;
                }
                updateOption();
            } else if (moveDir == '\\') {
                if (this.move == 1 || this.move == 3) moveLeft();
                else if (this.move == 2 || this.move == 4) moveRight();
            } else if (moveDir == '/') {
                if (this.move == 1 || this.move == 3) moveRight();
                else if (this.move == 2 || this.move == 4) moveLeft();
            } else if (moveDir == '|' || moveDir == '-') {
                // nothing to do
            } else {
                System.out.println("ERROR");
            }
        }

        private void move() {
            switch (this.move) {
                case 1:
                    this.y--;
                    break;
                case 2:
                    this.x++;
                    break;
                case 3:
                    this.y++;
                    break;
                case 4:
                    this.x--;
                    break;
            }
        }

        private void updateOption() {
            this.option = this.option + 1;
            if (this.option == 3) this.option = 0;
        }

        private void moveLeft() {
            this.move = this.move - 1;
            if (this.move == 0) this.move = 4;
        }

        private void moveRight() {
            this.move = this.move + 1;
            if (this.move == 5) this.move = 1;
        }

        int getX() {
            return x;
        }

        int getY() {
            return y;
        }

        int getMove() {
            return move;
        }
    }


}
