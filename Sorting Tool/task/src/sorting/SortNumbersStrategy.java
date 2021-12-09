package sorting;

import java.util.Comparator;

public class SortNumbersStrategy extends LongStrategy {

    @Override
    public void printStats() {
        System.out.println(String.format("Total %ss: %d", getDataType(), getTotalItems()));
        items.sort(Comparator.comparingLong( i -> Long.parseLong(i)));
        System.out.println(String.format("Sorted data:%s", getItemsString()));
    }
}
