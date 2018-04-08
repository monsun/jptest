package eu.jedrzej.jptest.calculations;

import eu.jedrzej.jptest.model.AbstractStock;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * P to E calculation:
 * Common stock: market price / dividend
 *
 * Created by JKalinowski on 2018-03-22.
 */
public class PtoERatioCalculator {

    public static BigDecimal pToERatio(AbstractStock stock, BigInteger marketPrice) {
        return new BigDecimal(marketPrice).divide(new BigDecimal(stock.getDividendValueForCalculations()),
                CalculationConstants.SCALE, CalculationConstants.ROUNDING_MODE);
    }

}
