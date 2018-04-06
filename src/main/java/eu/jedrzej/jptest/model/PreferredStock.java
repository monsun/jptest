package eu.jedrzej.jptest.model;

import eu.jedrzej.jptest.calculations.CalculationConstants;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

/**
 * Created by JKalinowski on 2018-03-18.
 */
public class PreferredStock extends AbstractStock {

    public PreferredStock(String symbol, BigInteger lastDividend, BigInteger parValue, BigDecimal fixedDividend) {
        this.symbol = symbol;
        this.lastDividend = lastDividend;
        this.parValue = parValue;
        this.fixedDividend = fixedDividend;
    }

    /**
     * Percent of fixed dividend
     */
    protected BigDecimal fixedDividend;

    public BigDecimal getFixedDividend() {
        return fixedDividend;
    }

    @Override
    public BigInteger getDividendValueForCalculations() {
        return fixedDividend.multiply(new BigDecimal(getParValue())).multiply(this.fixedDividend).multiply(new BigDecimal("1").divide(new BigDecimal("100"), CalculationConstants.SCALE, CalculationConstants.roundingMode)).toBigInteger();
    }
}
