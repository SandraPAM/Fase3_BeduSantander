package org.bedu.rest.model;

import java.util.Map;

public class Currency {

    private String symbol;

    private Map<String, Double> exchanges;

    public Currency(String symbol, Map<String, Double> exchanges) {
        this.symbol = symbol;
        this.exchanges = exchanges;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Map<String, Double> getExchanges() {
        return exchanges;
    }

    public void setExchanges(Map<String, Double> exchanges) {
        this.exchanges = exchanges;
    }
}
