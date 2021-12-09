package sorting;

import java.io.FileNotFoundException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WordStrategy extends AbstractStrategy {
    @Override
    public void fill() throws FileNotFoundException {
        try (Scanner scanner = getScanner()) {
            items = scanner.tokens().collect(Collectors.toList());
        }
    }
    @Override
    public Object getMax() {
        return items.stream().sorted().max(Comparator.comparingInt(s -> s.length())).orElseThrow();
    }

    @Override
    public int getTimesMax() {
        return  (int) items.stream().filter(s -> s.length() == ((String)getMax()).length()).count();
    }

    @Override
    public String getDataType() {
        return DataType.WORD.text;
    }

    protected void printMapSortedByCount() {
        Map<String, Long> map = items.stream()
                .sorted()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()));
        map.entrySet().stream().sorted(Comparator.comparing(e -> e.getValue()))
                .forEach(me -> System.out.println(String.format("%s: %s time(s), %.0f%%", me.getKey(), me.getValue(),
                        (me.getValue()/(double)getTotalItems())*100)));
    }
}
