package pl.oktawia.sporys.enums;

public enum Types {
    ADDITION("Dodawanie", "+"),
    SUBTRATION("Odejmowanie", "-"),
    MULTIPLICATION("Mnożenie", "*"),
    DIVISION("Dzielenie", "/");

    private String name;
    private String symbol;

    private Types(String name, String symbol){
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }
}
