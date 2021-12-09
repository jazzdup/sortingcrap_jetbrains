package sorting;

public class SortWordByCountStrategy extends WordStrategy {
    @Override
    public void printStats() {
        System.out.println(String.format("Total %ss: %d", getDataType(), getTotalItems()));
        printMapSortedByCount();
    }
}
