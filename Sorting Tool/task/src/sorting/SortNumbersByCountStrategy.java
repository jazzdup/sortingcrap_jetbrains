package sorting;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SortNumbersByCountStrategy extends LongStrategy {
    @Override
    public void printStats() {
        System.out.println(String.format("Total %ss: %d", getDataType(), getTotalItems()));
        Map<String, Long> map = items.stream()
                .sorted(Comparator.comparingLong( i -> Long.parseLong(i)))
                .collect(Collectors.groupingBy(
                            Function.identity(),
                            LinkedHashMap::new,
                            Collectors.counting()));
        map.entrySet().stream().sorted(Comparator.comparing(e -> e.getValue()))
                .forEach(me -> System.out.println(String.format("%s: %s time(s), %.0f%%", me.getKey(), me.getValue(),
                        (me.getValue()/(double)getTotalItems())*100)));
    }
}
