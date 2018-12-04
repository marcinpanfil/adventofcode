package pl.mpanfil.adventofcode.year2018;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Day4 {

    public int solve1(List<String> input) {
        Map<Integer, Integer> sleepTimeInfo = new HashMap<>();
        List<GuardEntry> guardEntries = parseInput(input);
        int guardId = -1;
        LocalDateTime startSleep = LocalDateTime.MIN;
        for (GuardEntry guardEntry : guardEntries) {
            switch (guardEntry.action) {
                case "B":
                    guardId = guardEntry.guard;
                    break;
                case "S":
                    startSleep = guardEntry.date;
                    guardEntry.guard = guardId;
                    break;
                case "W":
                    guardEntry.guard = guardId;
                    int guardSleepTime = sleepTimeInfo.getOrDefault(guardId, 0);
                    Duration duration = Duration.between(startSleep, guardEntry.date);
                    sleepTimeInfo.put(guardId, (int) (guardSleepTime + duration.toMinutes()));
                    break;
            }
        }
        Integer maxGuardId = sleepTimeInfo.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
        List<GuardEntry> mostSleepy = guardEntries.stream().filter(g -> g.guard == maxGuardId && !g.action.equals("B"))
                .collect(Collectors.toList());
        LocalDateTime sleepBegin = LocalDateTime.MIN;
        Map<Integer, Integer> minutes = new HashMap<>();
        for (GuardEntry guardEntry : mostSleepy) {
            if (guardEntry.action.equals("S")) {
                sleepBegin = guardEntry.date;
            } else if (guardEntry.action.equals("W")) {
                Duration duration = Duration.between(sleepBegin, guardEntry.date);
                int startMin = sleepBegin.getMinute();
                int endMin = (int) (startMin + duration.toMinutes());
                calculateMinutesForGuard(startMin, endMin, minutes);
            }
        }
        Integer minute = minutes.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
        return maxGuardId * minute;
    }

    public long solve2(List<String> input) {
        List<GuardEntry> guardEntries = parseInput(input);
        //guardId, minute, count
        Map<Integer, Map<Integer, Integer>> sleepTimeInfo = new HashMap<>();
        int guardId = -1;
        LocalDateTime startSleep = LocalDateTime.MIN;
        for (GuardEntry guardEntry : guardEntries) {
            switch (guardEntry.action) {
                case "B":
                    guardId = guardEntry.guard;
                    break;
                case "S":
                    startSleep = guardEntry.date;
                    guardEntry.guard = guardId;
                    break;
                case "W":
                    guardEntry.guard = guardId;
                    Duration duration = Duration.between(startSleep, guardEntry.date);
                    int startMin = startSleep.getMinute();
                    int endMin = (int) (startMin + duration.toMinutes());
                    Map<Integer, Integer> guardMinutes = sleepTimeInfo.get(guardId);
                    if (guardMinutes == null) guardMinutes = new HashMap<>();
                    calculateMinutesForGuard(startMin, endMin, guardMinutes);
                    sleepTimeInfo.put(guardId, guardMinutes);
                    break;
            }
        }
        int maxGuardId = 0;
        int maxMinute = 0;
        int maxCount = 0;
        for (Integer guard : sleepTimeInfo.keySet()) {
            Map<Integer, Integer> times = sleepTimeInfo.get(guard);
            int minute = times.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
            int count = times.get(minute);
            if (count > maxCount) {
                maxCount = count;
                maxMinute = minute;
                maxGuardId = guard;
            }
        }
        return maxMinute * maxGuardId;
    }

    private void calculateMinutesForGuard(int startMin, int endMin, Map<Integer, Integer> guardMinutes) {
        for (int i = startMin % 60; i < endMin % 60; i++) {
            int count = guardMinutes.getOrDefault(i, 0);
            guardMinutes.put(i, ++count);
        }
    }

    private List<GuardEntry> parseInput(List<String> input) {
        List<GuardEntry> entries = new ArrayList<>();
        for (String line : input) {
            String dateStr = line.substring(line.indexOf("[") + 1, line.indexOf("]"));
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            LocalDateTime date = LocalDateTime.parse(dateStr, formatter);
            int id = -1;
            String action;
            if (line.contains("wakes up")) {
                action = "W";
            } else if (line.contains("falls asleep")) {
                action = "S";
            } else {
                String patternStr = "#\\d+";
                Pattern pattern = Pattern.compile(patternStr);
                Matcher matcher = pattern.matcher(line);
                matcher.find();
                String numberWithHash = matcher.group();
                id = Integer.parseInt(numberWithHash.substring(1));
                action = "B";
            }
            GuardEntry guardEntry = new GuardEntry(date, id, action);
            entries.add(guardEntry);
        }
        entries.sort(Comparator.comparing(o -> o.date));
        return entries;
    }

    private static class GuardEntry {
        private LocalDateTime date;
        private int guard;
        private String action;

        private GuardEntry(LocalDateTime date, int guard, String action) {
            this.date = date;
            this.guard = guard;
            this.action = action;
        }
    }

}
