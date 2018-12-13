package pl.mpanfil.adventofcode.year2018;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day10 {

    public int solve1(List<String> input) {
        List<Message> data = parse(input);
        int maxX = Integer.MAX_VALUE;
        int maxY = Integer.MAX_VALUE;
        int minX = Integer.MIN_VALUE;
        int minY = Integer.MIN_VALUE;
        int diffX = Integer.MAX_VALUE;
        int diffY = Integer.MAX_VALUE;
        int seconds = 0;
        while (diffX > (maxX - minX) && diffY > (maxY - minY)) {
            if (seconds > 0) {
                diffX = maxX - minX;
                diffY = maxY - minY;
            }

            minX = Integer.MAX_VALUE;
            maxX = Integer.MIN_VALUE;
            minY = Integer.MAX_VALUE;
            maxY = Integer.MIN_VALUE;

            for (Message message : data) {
                message.move();
                if (message.getX() > maxX) {
                    maxX = message.getX();
                }
                if (message.getX() < minX) {
                    minX = message.getX();
                }
                if (message.getY() > maxY) {
                    maxY = message.getY();
                }
                if (message.getY() < minY) {
                    minY = message.getY();
                }
            }
            seconds++;
        }

        for (Message message : data) {
            message.moveBack();
        }

        for (int y = minY; y <= maxY; y++) {
            for (int x = minX; x <= maxX; x++) {
                boolean found = false;
                for (Message point : data) {
                    if (point.isEqual(x, y)) {
                        found = true;
                        break;
                    }
                }

                if (found) {
                    System.out.print("#");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }

        return --seconds;
    }

    private List<Message> parse(List<String> input) {
        List<Message> messages = new ArrayList<>();
        String patternStr = "-?\\d+";
        Pattern pattern = Pattern.compile(patternStr);
        for (String line : input) {
            Matcher matcher = pattern.matcher(line);
            matcher.find();
            int x = Integer.parseInt(matcher.group());
            matcher.find();
            int y = Integer.parseInt(matcher.group());
            matcher.find();
            int xv = Integer.parseInt(matcher.group());
            matcher.find();
            int yv = Integer.parseInt(matcher.group());
            Message message = new Message(x, y, xv, yv);
            messages.add(message);
        }
        return messages;
    }

    private class Message {

        private int x;
        private int y;

        private int xv;
        private int yv;

        private Message(int x, int y, int xv, int yv) {
            this.x = x;
            this.y = y;
            this.xv = xv;
            this.yv = yv;
        }

        boolean isEqual(int x, int y) {
            return this.x == x && this.y == y;
        }

        void move() {
            this.x += xv;
            this.y += yv;
        }

        void moveBack() {
            this.x -= xv;
            this.y -= yv;
        }

        int getX() {
            return x;
        }

        int getY() {
            return y;
        }
    }

}
