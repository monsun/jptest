package eu.jedrzej.jptest.calculations;

import eu.jedrzej.jptest.model.AbstractStock;
import eu.jedrzej.jptest.model.CommonStock;
import eu.jedrzej.jptest.model.PreferredStock;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;

import static org.testng.Assert.*;

/**
 * Created by JKalinowski on 2018-03-27.
 */
public class PtoERatioCalculatorTest {


    @DataProvider
    public static Object[][] PtoEDataProvider() {
        return new Object[][] {
                {new CommonStock("ZZZ", new BigInteger("100"), new BigInteger("1000")), new BigInteger("1000"), new BigDecimal("10.0000") },
                {new PreferredStock("abc", new BigInteger("200"), new BigInteger("10000"), new BigDecimal("5")), new BigInteger("1000") , new BigDecimal("200.0000")}
        };
    }

    @Test(dataProvider = "PtoEDataProvider")
    public void testPToERatio(AbstractStock stock, BigInteger marketPrice, BigDecimal expectedValue) throws Exception {
        if (stock instanceof CommonStock) {
            Assert.assertEquals(PtoERatioCalculator.pToERatio((CommonStock) stock, marketPrice), expectedValue);
        } else if (stock instanceof PreferredStock) {
            Assert.assertEquals(PtoERatioCalculator.pToERatio((PreferredStock) stock, marketPrice), expectedValue);
        } else {
            Assert.fail();
        }
     }
}