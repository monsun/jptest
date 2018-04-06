package eu.jedrzej.jptest.model;

import java.math.BigInteger;

/**
 * Created by JKalinowski on 2018-03-18.
 * General class for Global Beverage Corporation Exchange stocks
 */
public abstract class AbstractStock {

    /**
     * Symbol that identifies the stock, should be unique
     */
    protected String symbol;

    /**
     * Last divident (in pennies)
     */
    protected BigInteger lastDividend;

    /**
     * Par value (in pennies)
     */
    protected BigInteger parValue;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public BigInteger getLastDividend() {
        return lastDividend;
    }

    public void setLastDividend(BigInteger lastDividend) {
        this.lastDividend = lastDividend;
    }

    public BigInteger getParValue() {
        return parValue;
    }

    public void setParValue(BigInteger parValue) {
        this.parValue = parValue;
    }

    public abstract BigInteger getDividendValueForCalculations();
}
