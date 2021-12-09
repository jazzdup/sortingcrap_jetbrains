package sorting;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public interface Strategy {
    void fill() throws FileNotFoundException;
    void printStats();
    int getTotalItems();
    Object getMax();
    int getTimesMax();
    int getPercentMax();
    String getDataType();
    void setInput(File inputFile);
    Scanner getScanner() throws FileNotFoundException;
}
