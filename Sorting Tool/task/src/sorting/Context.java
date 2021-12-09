package sorting;

import java.io.File;
import java.io.FileNotFoundException;

public class Context {
    Strategy strategy;

    public void invoke() throws FileNotFoundException {
        strategy.fill();
        strategy.printStats();
    }

    public void setStrategy(DataType dataType, SortingType sortingType, File inputFile) {
        if (sortingType.equals(SortingType.NATURAL)) {
            switch (dataType) {
                case LINE:
//                    strategy = new SortLineStrategy();
//                    hahaha no test for this crap
                    break;
                case LONG:
                    strategy = new SortNumbersStrategy();
                    break;
                case WORD:
                    strategy = new SortWordStrategy();
            }
        }else if (sortingType.equals(SortingType.BY_COUNT)) {
            switch (dataType) {
                case LINE:
                    strategy = new SortLineByCountStrategy();
                    break;
                case LONG:
                    strategy = new SortNumbersByCountStrategy();
                    break;
                case WORD:
                    strategy = new SortWordByCountStrategy();
            }
        }
        strategy.setInput(inputFile);
    }
}
