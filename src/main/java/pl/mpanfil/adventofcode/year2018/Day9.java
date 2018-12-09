package pl.mpanfil.adventofcode.year2018;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day9 {

    public long solve1(int players, int marble) {
        List<Integer> marbles = new ArrayList<>(marble);
        marbles.add(0);
        marbles.add(1);
        long[] playersScores = new long[players];
        int currentIndex = 1;
        int nextIndex;
        int nextMarble;
        for (int i = 1; i < marble; i++) {
            nextMarble = i + 1;
            if (currentIndex + 1 == marbles.size()) {
                nextIndex = 1;
            } else {
                nextIndex = currentIndex + 2;
            }

            if (nextMarble % 23 == 0) {
                int index = (currentIndex - 7 < 1 ? marbles.size() + currentIndex - 7 : currentIndex - 7);
                long score = marbles.remove(index) + nextMarble;
                playersScores[i % players] += score;
                currentIndex = index;
            } else {
                marbles.add(nextIndex, nextMarble);
                currentIndex = nextIndex;
            }
        }
        return Arrays.stream(playersScores).max().getAsLong();
    }

    public long solve2(int players, int marble) {
        ArrayDeque<Integer> marbles = new ArrayDeque<>();
        marbles.addFirst(0);
        long[] scores = new long[players];
        for (int i = 1; i <= marble; i++) {
            if (i % 23 == 0) {
                rotate(marbles, -7);
                scores[i % players] += i + marbles.pop();
            } else {
                rotate(marbles, 2);
                marbles.addLast(i);
            }
        }
        return Arrays.stream(scores).max().getAsLong();
    }

    /*
    Removing from an array deque is much faster then from an array list or a linked list.
    Deque "remembers" current position so there is no need to have an index.
     */
    private void rotate(ArrayDeque arrayDeque, int shift) {
        if (shift > 0) {
            for (int i = 0; i < shift; i++) {
                Integer t = (Integer) arrayDeque.removeLast();
                arrayDeque.addFirst(t);
            }
        } else {
            for (int i = 0; i < Math.abs(shift) - 1; i++) {
                Integer t = (Integer) arrayDeque.remove();
                arrayDeque.addLast(t);
            }
        }
    }
}
