package pl.mpanfil.adventofcode;

import java.util.List;
import java.util.Objects;

class Day19 {

    String solve1(List<String> lines) {
        Position position = new Position();
        return run(lines, position);
    }


    int solve2(List<String> lines) {
        Position position = new Position();
        run(lines, position);
        return position.steps;
    }

    private String run(List<String> lines, Position position) {
        position.x = lines.get(0).indexOf("|");
        position.y = 0;
        String result = "";
        Position lastPos = new Position();
        result = moveVertically(lines, position, result, 1);
        boolean vertically = true;
        while (!lastPos.equals(position)) {
            lastPos = new Position(position);
            int value;
            if (vertically) {
                value = goLeftOrRight(lines.get(position.y), position.x);
                if (value == 0) return result;
                else {
                    result = moveHorizontally(lines.get(position.y), position, result, value);
                }
                vertically = !vertically;
            } else {
                value = goUpOrDown(lines, position.x, position.y);
                if (value == 0) return result;
                else {
                    result = moveVertically(lines, position, result, value);
                }
                vertically = !vertically;
            }
        }
        return result;
    }

    private int goUpOrDown(List<String> lines, int x, int y) {
        if (lines.size() > y + 1 && lines.get(y + 1).charAt(x) != ' ') {
            return 1;
        } else if (y - 1 >= 0 && lines.get(y - 1).charAt(x) != ' ') {
            return -1;
        } else return 0;
    }

    private int goLeftOrRight(String line, int x) {
        if (line.length() > x + 1 && line.charAt(x + 1) != ' ') {
            return 1;
        } else if (x - 1 >= 0 && line.charAt(x - 1) != ' ') {
            return -1;
        } else return 0;
    }

    private String moveVertically(List<String> lines, Position position, String result, int upDown) {
        StringBuilder sb = new StringBuilder(result);
        while (true) {
            if (Character.isLetter(lines.get(position.y).charAt(position.x))) {
                sb.append(lines.get(position.y).charAt(position.x));
            }
            if (position.y + upDown == 0 || position.y + upDown == lines.size()) {
                return sb.toString();
            }
            if (lines.get(position.y + upDown).charAt(position.x) == ' ') {
                return sb.toString();
            }
            position.y += upDown;
            position.steps++;
        }
    }

    private String moveHorizontally(String line, Position position, String result, int leftRight) {
        StringBuilder sb = new StringBuilder(result);
        while (true) {
            if (Character.isLetter(line.charAt(position.x))) {
                sb.append(line.charAt(position.x));
            }
            if (position.x + leftRight == 0 || position.x + leftRight == line.length()) {
                return sb.toString();
            }
            if (line.charAt(position.x + leftRight) == ' ') {
                return sb.toString();
            }
            position.x += leftRight;
            position.steps++;
        }
    }

    private class Position {
        int x;
        int y;
        int steps;

        Position() {
            steps = 1;
        }

        Position(Position position) {
            this.x = position.x;
            this.y = position.y;
            this.steps = position.steps;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return x == position.x &&
                    y == position.y &&
                    steps == position.steps;
        }

        @Override
        public int hashCode() {

            return Objects.hash(x, y, steps);
        }
    }
}
