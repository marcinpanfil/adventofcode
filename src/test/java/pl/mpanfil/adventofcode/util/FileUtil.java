package pl.mpanfil.adventofcode.util;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
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

}
