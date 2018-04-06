package eu.jedrzej.jptest.calculations;

import eu.jedrzej.jptest.model.StockTransaction;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;

/**
 * Created by JKalinowski on 2018-03-23.
 */
public class VolumeWeightedStockPriceCalculator {

    public static BigDecimal volumeWeightedStockPrice(Collection<StockTransaction> transactions) {
        BigInteger sumOfQuantities = new BigInteger("0");
        BigInteger sumOfProducts = new BigInteger("0");
        for (StockTransaction transaction: transactions) {
            sumOfProducts = sumOfProducts.add(transaction.getQuantity().multiply(transaction.getTradePrice()));
            sumOfQuantities = sumOfQuantities.add(transaction.getQuantity());
        }

        return new BigDecimal(sumOfProducts).divide(new BigDecimal(sumOfQuantities), CalculationConstants.SCALE, CalculationConstants.roundingMode);
    }
}
