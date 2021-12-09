package sorting;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LineStrategy extends WordStrategy {
    @Override
    public void fill() throws FileNotFoundException {
        try (Scanner scanner = getScanner()) {
            while (scanner.hasNextLine()) {
                items.add(scanner.nextLine());
            }
        }
    }

    @Override
    public String getDataType() {
        return DataType.LINE.text;
    }

    @Override
    public void printStats() {
        System.out.println(String.format("Total %ss: %d", getDataType(), getTotalItems()));
        System.out.println(String.format("The longest %s:\n%s\n(%d time(s), %d%%)",
                getDataType(), getMax(), getTimesMax(),
                getPercentMax()));

    }
}
