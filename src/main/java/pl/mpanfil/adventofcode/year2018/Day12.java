package pl.mpanfil.adventofcode.year2018;

import java.util.ArrayList;
import java.util.List;

public class Day12 {

    // points to the index 0 for initial state
    private int index = 0;

    public int solve1(String initialState, List<String> instructions, int number) {
        index = 0;
        initialState = extend(initialState);
        List<Note> notes = parseInstructions(instructions);
        for (int i = 0; i < number; i++) {
            char[] generation = initialState.toCharArray();
            for (int j = 0; j < initialState.length() - 5; j++) {
                String current = initialState.substring(j, j + 5);
                for (Note note : notes) {
                    if (current.equals(note.getSequence())) {
                        generation[j + 2] = note.getResult();
                        break;
                    } else {
                        generation[j + 2] = '.';
                    }
                }
            }
            initialState = extend(new String(generation));
        }
        char[] result = initialState.toCharArray();
        int sum = 0;
        for (int j = 0; j < result.length; j++) {
            char c = result[j];
            if (c == '#') {
                sum += (j - index);
            }
        }
        return sum;
    }

    public long solve2(String initialState, List<String> instructions) {
        long sum = solve1(initialState, instructions, 100);
        long next = solve1(initialState, instructions, 101);
        long diff = next - sum;

        sum += (50000000000L - 100) * diff;

        return sum;
    }

    private String extend(String initialState) {
        if (initialState.substring(0, 4).contains("#")) {
            initialState = "...." + initialState;
            index += 4;
        }
        if (initialState.substring(initialState.length() - 4).contains("#")) {
            initialState = initialState + "....";
        }
        return initialState;
    }

    private List<Note> parseInstructions(List<String> instructions) {
        List<Note> notes = new ArrayList<>();
        for (String instruction : instructions) {
            Note note = new Note(instruction.substring(0, 5), instruction.charAt(9));
            notes.add(note);
        }
        return notes;
    }

    private class Note {

        private String sequence;
        private char result;

        private Note(String sequence, char result) {
            this.sequence = sequence;
            this.result = result;
        }

        String getSequence() {
            return sequence;
        }

        char getResult() {
            return result;
        }
    }

}
