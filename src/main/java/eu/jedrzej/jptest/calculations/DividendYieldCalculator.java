package eu.jedrzej.jptest.calculations;

import eu.jedrzej.jptest.model.AbstractStock;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by JKalinowski on 2018-03-22.
 */
public class DividendYieldCalculator {

    public static BigDecimal dividendYield(AbstractStock stock, BigInteger marketPrice) {
        return new BigDecimal(stock.getDividendValueForCalculations()).divide(new BigDecimal(marketPrice));
    }

}
