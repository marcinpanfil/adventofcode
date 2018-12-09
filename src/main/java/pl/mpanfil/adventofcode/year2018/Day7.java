package pl.mpanfil.adventofcode.year2018;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

public class Day7 {

    private Map<Character, List<Character>> data;
    private Map<Character, List<Character>> tasks;

    public String solve1(List<String> input) {
        parseInput(input);
        List<Character> result = new ArrayList<>();
        List<Character> stepsToAdd = getFirsts();
        Set<Character> steps = new TreeSet<>(stepsToAdd);
        Character nextStep = stepsToAdd.get(0);
        while (!steps.isEmpty() && nextStep != null) {
            steps.remove(nextStep);
            result.add(nextStep);
            steps.addAll(data.getOrDefault(nextStep, Collections.emptyList()));
            Character possibleNextStep = steps.stream()
                    .filter(s -> result.containsAll(tasks.getOrDefault(s, Collections.emptyList()))).findFirst().orElse(null);
            if (possibleNextStep != null) {
                nextStep = possibleNextStep;
            }
        }

        return toString(result);
    }

    public int solve2(List<String> input, int workers, int count) {
        parseInput(input);
        List<Character> result = new ArrayList<>();
        List<Character> stepsToAdd = getFirsts();
        Set<Character> steps = new TreeSet<>(stepsToAdd);
        int time = 0;
        int availableWorkers = workers;
        Map<Character, Integer> processInfo = new HashMap<>();
        Character nextStep = stepsToAdd.get(0);
        processInfo.put(nextStep, 0);
        while (result.size() < count) {
            Set<Character> characters = new HashSet<>(processInfo.keySet());
            for (Character character : characters) {
                int processTime = 60 + ((int) character - 64);
                int startTime = processInfo.get(character);
                if (startTime + processTime == time) {
                    processInfo.remove(character);
                    result.add(character);
                    List<Character> nextPossible = data.getOrDefault(character, Collections.emptyList()).stream()
                            .filter(s -> result.containsAll(tasks.getOrDefault(s, Collections.emptyList()))).collect(Collectors.toList());
                    steps.addAll(nextPossible);
                }
            }
            for (Character step : steps) {
                if (processInfo.size() < availableWorkers) {
                    processInfo.put(step, time);
                }
            }
            steps.removeAll(processInfo.keySet());

            if (processInfo.size() == availableWorkers || steps.isEmpty() && result.size() != count) {
                time++;
            }
        }
        return time;
    }

    private String toString(List<Character> list) {
        return list.stream().map(Object::toString).collect(joining());
    }

    private List<Character> getFirsts() {
        Set<Character> before = new HashSet<>(data.keySet());
        Set<Character> after = new HashSet<>(tasks.keySet());
        for (List<Character> value : data.values()) {
            after.addAll(value);
        }
        before.removeAll(after);
        ArrayList<Character> characters = new ArrayList<>(before);
        Collections.sort(characters);
        return characters;
    }

    private void parseInput(List<String> input) {
        this.data = new HashMap<>();
        this.tasks = new HashMap<>();
        for (String i : input) {
            char stepA = i.charAt(5);
            char stepB = i.charAt(36);
            createData(data, stepA, stepB);
            createData(tasks, stepB, stepA);
        }
    }

    private void createData(Map<Character, List<Character>> data, char stepA, char stepB) {
        List<Character> characters;
        if (data.containsKey(stepA)) {
            characters = data.get(stepA);
        } else {
            characters = new ArrayList<>();
        }
        characters.add(stepB);
        characters.sort(Comparator.naturalOrder());
        data.put(stepA, characters);
    }

}
