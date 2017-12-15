package pl.mpanfil.adventofcode.util;

import java.util.ArrayList;
import java.util.List;

public class StringUtil {

    public static List<Integer> splitAndConvert(String strWithInts) {
        String[] intStr = strWithInts.replaceAll(" ", "").split(",");
        List<Integer> integers = new ArrayList<>();
        for (String s : intStr) {
            integers.add(Integer.parseInt(s));
        }
        return integers;
    }

}
