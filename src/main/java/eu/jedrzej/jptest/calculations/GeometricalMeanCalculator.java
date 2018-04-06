package eu.jedrzej.jptest.calculations;

import eu.jedrzej.jptest.model.AbstractStock;

import java.math.BigInteger;
import java.util.Collection;

/**
 * Created by JKalinowski on 2018-03-18.
 */
public class GeometricalMeanCalculator {

    /**
     * Gives a geometrical mean of stocks values for the given ones
     * @param stocks collection of stocks
     * @return double approximation, as sqrt is not available in standard java math library for BigDecimal
     */
    public static BigInteger geometricalMean(Collection<AbstractStock> stocks) {
        BigInteger multiplicationOfParValues = new BigInteger("1");
        for (AbstractStock stock: stocks) {
            multiplicationOfParValues = multiplicationOfParValues.multiply(stock.getParValue());
        }
        return new BigInteger(String.valueOf(Math.round(Math.sqrt(multiplicationOfParValues.doubleValue()))));
    }

}
