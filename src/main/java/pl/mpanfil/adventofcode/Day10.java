package pl.mpanfil.adventofcode;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Day10 {

    int solve1(List<Integer> input, int maxNumber) {
        List<Integer> data = createData(maxNumber);

        int skip = 0;
        int currentPos = 0;
        for (int length : input) {
            int diff = calculateDiff(data, currentPos, length);
            currentPos = sortPartOfList(data, skip, currentPos, length, diff);
            skip++;
            currentPos = calculateCurrentPosition(data, currentPos);
        }

        return data.get(0) * data.get(1);
    }

    private int calculateCurrentPosition(List<Integer> data, int currentPos) {
        if (currentPos > data.size()) {
            currentPos = currentPos % data.size();
        }
        return currentPos;
    }

    private int sortPartOfList(List<Integer> data, int skip, int currentPos, int length, int diff) {
        List<Integer> toSort = new ArrayList<>();
        if (diff < 0) {
            toSort.addAll(data.subList(currentPos, data.size()));
            int added = data.size() - currentPos;
            toSort.addAll(data.subList(0, length - added));
        } else {
            toSort.addAll(data.subList(currentPos, currentPos + length));
        }
        Collections.reverse(toSort);
        for (int i = 0; i < toSort.size(); i++) {
            int index = i + currentPos;
            if (index >= data.size()) {
                data.set(index - data.size(), toSort.get(i));
            } else {
                data.set(index, toSort.get(i));
            }
        }
        currentPos = currentPos + skip + length;
        return currentPos;
    }

    String solve2(String input, int maxNumber) {
        List<Integer> data = createData(maxNumber);
        byte[] b = input.getBytes(StandardCharsets.US_ASCII);
        b = ArrayUtils.addAll(b, (byte) 17, (byte) 31, (byte) 73, (byte) 47, (byte) 23);

        int skip = 0;
        int currentPos = 0;
        for (int c = 0; c < 64; c++) {
            for (int length : b) {
                int diff = calculateDiff(data, currentPos, length);
                currentPos = sortPartOfList(data, skip, currentPos, length, diff);
                skip++;
                currentPos = calculateCurrentPosition(data, currentPos);
            }
        }

        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            int result = data.get(16 * i);
            for (int j = 1; j < 16; j++) {
                result = result ^ data.get(16 * i + j);
            }
            results.add(result);
        }

        List<String> hexValues = new ArrayList<>();
        for (Integer result : results) {
            hexValues.add(String.format("%02x", result));
        }

        return StringUtils.join(hexValues, "");
    }

    private int calculateDiff(List<Integer> data, int currentPos, int length) {
        return data.size() - currentPos - length;
    }

    private List<Integer> createData(int maxNumber) {
        List<Integer> data = new ArrayList<>();
        for (int i = 0; i < maxNumber; i++) {
            data.add(i);
        }
        return data;
    }

}
