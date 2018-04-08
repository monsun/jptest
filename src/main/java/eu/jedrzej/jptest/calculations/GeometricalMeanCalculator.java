package eu.jedrzej.jptest.calculations;

import ch.obermuhlner.math.big.BigDecimalMath;
import eu.jedrzej.jptest.model.AbstractStock;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.Collection;

/**
 * Geometrical mean calculation:
 * n-th root of multiplication of n stocks values
 *
 * Created by JKalinowski on 2018-03-18.
 */
public class GeometricalMeanCalculator {

    public static BigDecimal geometricalMean(Collection<AbstractStock> stocks) {
        BigInteger multiplicationOfParValues = new BigInteger("1");
        for (AbstractStock stock: stocks) {
            multiplicationOfParValues = multiplicationOfParValues.multiply(stock.getParValue());
        }
        return BigDecimalMath.root(new BigDecimal(multiplicationOfParValues), new BigDecimal(stocks.size()),
                new MathContext(CalculationConstants.SCALE, CalculationConstants.ROUNDING_MODE)).setScale(
                CalculationConstants.SCALE, CalculationConstants.ROUNDING_MODE);
    }

}
