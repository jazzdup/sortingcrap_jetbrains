package sorting;

public enum DataType {
    LONG("number"),
    LINE("line"),
    WORD("word");
    String text;
    DataType(String text) {
        this.text = text;
    }
}
