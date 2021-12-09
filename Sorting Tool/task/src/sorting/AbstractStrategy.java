package sorting;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public abstract class AbstractStrategy implements Strategy {
    protected List<String> items = new ArrayList<>();;
    private File inputFile = null;
    public int getTotalItems(){
        return items.size();
    }
    public Object getMax() {
        return Collections.max(items);
    }

    @Override
    public int getTimesMax() {
        return (int) items.stream().filter(i -> i == getMax()).count();
    }

    @Override
    public int getPercentMax() {
        return (int) ((getTimesMax() / (double) getTotalItems()) * 100);
    }

    @Override
    public String getDataType() {
        throw new UnsupportedOperationException("define it!");
    }

    public abstract void fill() throws FileNotFoundException;
    public void printStats() {
        System.out.println(String.format("Total %ss: %d", getDataType(), getTotalItems()));
        System.out.println(String.format("The greatest %s: %s (%d time(s), %d%%)", getDataType(),
                getMax(), getTimesMax(),
                getPercentMax()));
    }
    public String getItemsString() {
        return items.stream().map(i -> i.toString()).collect(Collectors.joining(" "));
    }

    @Override
    public String toString() {
        return this.getClass().getName();
    }

    @Override
    public void setInput(File inputFile) {
        this.inputFile = inputFile;
    }

    @Override
    public Scanner getScanner() throws FileNotFoundException {
        if (this.inputFile == null) {
            return new Scanner(System.in);
        } else {
            return new Scanner(inputFile);
        }
    }
}
