package sorting;

import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LongStrategy extends AbstractStrategy {
    @Override
    public String getDataType() {
        return DataType.LONG.text;
    }

    @Override
    public void fill() throws FileNotFoundException {
        try (Scanner scanner = getScanner()) {
            while (scanner.hasNextLong()) {
                long number = scanner.nextLong();
                items.add(String.valueOf(number));
            }
        }
    }
}
