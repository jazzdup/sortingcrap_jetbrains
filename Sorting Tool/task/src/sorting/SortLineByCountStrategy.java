package sorting;

public class SortLineByCountStrategy extends LineStrategy {
    @Override
    public void printStats() {
        System.out.println(String.format("Total %ss: %d", getDataType(), getTotalItems()));
        printMapSortedByCount();
    }
}
