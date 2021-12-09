package sorting;

import java.io.*;
import java.util.Arrays;
import java.util.Iterator;

public class Main {
    public static void main(final String[] args) {
        try {
            DataType dataType = getDataType(args);
            SortingType sortingType = getSortingType(args);
            File inputFile = getInputFile(args);
            setOutputFile(args);
            Context context = new Context();
            context.setStrategy(dataType, sortingType, inputFile);
            context.invoke();
        } catch (MissingDataTypeException | InvalidSortingParameterException
                | MissingSortingTypeException | MissingInputFileException
                | FileNotFoundException | MissingOutputFileException e) {
            System.setOut(System.out);
            System.out.println(e.getMessage());
        }
    }

    private static void setOutputFile(String[] args) throws MissingOutputFileException, FileNotFoundException {
        Iterator<String> iterator = Arrays.stream(args).iterator();
        while (iterator.hasNext()) {
            String arg = iterator.next();
            if ("-outputFile".equals(arg)) {
                if (!iterator.hasNext()) {
                    throw new MissingOutputFileException("No output file defined!");
                }
                String argNext = iterator.next();
                System.setOut(new PrintStream(new BufferedOutputStream(
                        new FileOutputStream(argNext))));
            }
        }
    }

    private static File getInputFile(String[] args) throws MissingInputFileException {
        Iterator<String> iterator = Arrays.stream(args).iterator();
        while (iterator.hasNext()) {
            String arg = iterator.next();
            if ("-inputFile".equals(arg)) {
                if (!iterator.hasNext()) {
                    throw new MissingInputFileException("No input file defined!");
                }
                String argNext = iterator.next();
                return new File(argNext);
            }
        }
        return null;
    }

    private static SortingType getSortingType(String[] args)
            throws MissingSortingTypeException {
        Iterator<String> iterator = Arrays.stream(args).iterator();
        while (iterator.hasNext()) {
            String arg = iterator.next();
            if("-sortingType".equals(arg)){
                if (!iterator.hasNext()) {
                    throw new MissingSortingTypeException("No sorting type defined!");
                }
                String argNext = iterator.next();
                if ("byCount".equals(argNext)) {
                    return SortingType.BY_COUNT;
                }else if ("natural".equals(argNext)) {
                    return SortingType.NATURAL;
                } else
                    throw new MissingSortingTypeException("No sorting type defined!");
            }
        }
        return SortingType.NATURAL;
    }

    private static DataType getDataType(String[] args) throws MissingDataTypeException,
            InvalidSortingParameterException {
        Iterator<String> iterator = Arrays.stream(args).iterator();
        while (iterator.hasNext()) {
            String arg = iterator.next();
            if (arg.startsWith("-") && !"-dataType".equals(arg)
                                    && !"-sortingType".equals(arg)
                                    && !"-inputFile".equals(arg)
                                    && !"-outputFile".equals(arg)
                                    ){
                throw new InvalidSortingParameterException(
                        String.format("\"-%s\" is not a valid parameter. It will be skipped.", arg));
            }
            if("-dataType".equals(arg)){
                String argNext = iterator.next();
                if ("long".equals(argNext)) {
                    return DataType.LONG;
                } else if ("line".equals(argNext)) {
                    return DataType.LINE;
                } else if ("word".equals(argNext)) {
                    return DataType.WORD;
                } else{
                    throw new MissingDataTypeException("No data type defined!");
                }
            }
        }
        return DataType.LONG;
//        throw new MissingDataTypeException("No data type defined!");
    }
}
