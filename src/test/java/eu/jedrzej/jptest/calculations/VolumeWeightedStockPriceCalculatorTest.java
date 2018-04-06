package eu.jedrzej.jptest.calculations;

import eu.jedrzej.jptest.model.AbstractStock;
import eu.jedrzej.jptest.model.CommonStock;
import eu.jedrzej.jptest.model.StockTransaction;
import org.joda.time.DateTime;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collection;

import static org.testng.Assert.*;

/**
 * Created by JKalinowski on 2018-03-27.
 */
public class VolumeWeightedStockPriceCalculatorTest {

    @DataProvider
    public static Object[][] volumeWeightedDataProvider() {
        return new Object[][] {
                {Arrays.asList(new StockTransaction(new BigInteger("100"), new BigInteger("300"), true, new DateTime()), new StockTransaction(new BigInteger("400"), new BigInteger("700"), true, new DateTime())),  new BigDecimal("310") },
                {Arrays.asList(new StockTransaction(new BigInteger("100"), new BigInteger("300"), true, new DateTime())),  new BigDecimal("100") }
        };
    }

    @Test(dataProvider = "volumeWeightedDataProvider")
    public void testVolumeWeightedStockPrice(Collection<StockTransaction> transactions, BigDecimal expectedValue) throws Exception {
        Assert.assertEquals(VolumeWeightedStockPriceCalculator.volumeWeightedStockPrice(transactions), expectedValue);
    }
}