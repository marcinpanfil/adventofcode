package pl.mpanfil.adventofcode.util;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FileUtil {

    public static List<String> readFile(String fileName) throws URISyntaxException {
        List<String> lines = new ArrayList<>();
        URL url = FileUtil.class.getClassLoader().getResource(fileName);
        if (url != null) {
            Path path = Paths.get(url.toURI());
            try (Stream<String> stream = Files.lines(path)) {
                stream.forEach(lines::add);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return lines;
    }

    public static List<Integer> readFileAsIntList(String fileName) throws URISyntaxException {
        List<String> stringList = readFile(fileName);
        List<Integer> integerList = new ArrayList<>();
        stringList.stream().forEach(s -> integerList.add(Integer.parseInt(s)));
        return integerList;
    }

    public static List<Integer> readOneLineFileAsIntList(String fileName) throws URISyntaxException {
        List<String> stringList = readFile(fileName);
        String[] intStr = stringList.get(0).split(" ");
        List<Integer> result = new ArrayList<>();
        Arrays.stream(intStr).forEach(s -> result.add(Integer.parseInt(s)));
        return result;
    }

    public static List<Integer> convert1ColumnLine(List<String> lines) {
        List<Integer> numbers = new ArrayList<>();
        lines.forEach((s) -> numbers.add(Integer.parseInt(s)));
        return numbers;
    }

}
