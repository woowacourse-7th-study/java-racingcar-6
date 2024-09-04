package racingcar.constant;

public enum Symbol {

    DASH("-"),
    COMMA(","),
    COLON(":"),
    BLANK(" ");

    final String symbol;

    Symbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
