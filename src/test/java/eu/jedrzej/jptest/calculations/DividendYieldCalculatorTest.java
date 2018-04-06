package eu.jedrzej.jptest.calculations;

import eu.jedrzej.jptest.model.AbstractStock;
import eu.jedrzej.jptest.model.CommonStock;
import eu.jedrzej.jptest.model.PreferredStock;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

import static org.testng.Assert.*;

/**
 * Created by JKalinowski on 2018-03-27.
 */
public class DividendYieldCalculatorTest {

    @DataProvider
    public static Object[][] dividendYieldCalculator() {
        return new Object[][]{
                { new CommonStock("abc", new BigInteger("2000"), new BigInteger("3500")), new BigInteger("500"), new BigDecimal("4") },
                { new CommonStock("abc", new BigInteger("2000"), new BigInteger("3500")), new BigInteger("4000"), new BigDecimal("0.5") },
                { new PreferredStock("abc", new BigInteger("2000"), new BigInteger("3500"), new BigDecimal("10")), new BigInteger("7000"), new BigDecimal("0.5") }
        };
    }

    @Test(dataProvider = "dividendYieldCalculator")
    public void testDividendYield(AbstractStock stock, BigInteger marketPrice, BigDecimal expectedResult) throws Exception {
        Assert.assertEquals(DividendYieldCalculator.dividendYield(stock, marketPrice), expectedResult);
    }
}