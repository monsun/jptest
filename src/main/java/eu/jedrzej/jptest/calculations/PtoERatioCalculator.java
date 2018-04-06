package eu.jedrzej.jptest.calculations;

import eu.jedrzej.jptest.model.AbstractStock;
import eu.jedrzej.jptest.model.CommonStock;
import eu.jedrzej.jptest.model.PreferredStock;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by JKalinowski on 2018-03-22.
 */
public class PtoERatioCalculator {

    public static BigDecimal pToERatio(CommonStock stock, BigInteger marketPrice) {
        return new BigDecimal(marketPrice).divide(new BigDecimal(stock.getLastDividend()), CalculationConstants.SCALE, CalculationConstants.roundingMode);
    }

    public static BigDecimal pToERatio(PreferredStock stock, BigInteger marketPrice) {
        return new BigDecimal(marketPrice).divide(stock.getFixedDividend(), CalculationConstants.SCALE, CalculationConstants.roundingMode);
    }


}
