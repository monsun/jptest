package eu.jedrzej.jptest.calculations;

import eu.jedrzej.jptest.model.AbstractStock;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Dividend yield calculation:
 * For common stocks: last_dividend / market_price
 * For preferred stocks: (fixed_dividend * par_value)/market_price
 *
 * Created by JKalinowski on 2018-03-22.
 */
public class DividendYieldCalculator {

    public static BigDecimal dividendYield(AbstractStock stock, BigInteger marketPrice) {
        return new BigDecimal(stock.getDividendValueForCalculations()).divide(new BigDecimal(marketPrice));
    }

}
