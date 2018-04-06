package eu.jedrzej.jptest.model;

import java.math.BigInteger;

/**
 * Created by JKalinowski on 2018-03-18.
 *
 * Common stock class, doesn't have any more fields than the abstract class for now, kept for extensibility in the future
 *
 */
public class CommonStock extends AbstractStock {

    public CommonStock(String symbol, BigInteger lastDividend, BigInteger parValue) {
        this.symbol = symbol;
        this.lastDividend = lastDividend;
        this.parValue = parValue;
    }

    @Override
    public BigInteger getDividendValueForCalculations() {
        return getLastDividend();
    }
}
