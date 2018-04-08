package eu.jedrzej.jptest.calculations;

import eu.jedrzej.jptest.model.AbstractStock;
import eu.jedrzej.jptest.model.CommonStock;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by JKalinowski on 2018-03-18.
 */
public class GeometricalMeanCalculatorTest {

    @DataProvider(name = "geometricalMean")
    public static Object[][] geometricalMean() {
        return new Object[][] {
                {Arrays.asList(new AbstractStock[] { new CommonStock("ZZZ", new BigInteger("100"), new BigInteger("100"))}),  new BigDecimal("100.0000") },
                {Arrays.asList(new AbstractStock[] { new CommonStock("abc", new BigInteger("200"), new BigInteger("2")),
                        new CommonStock("abc", new BigInteger("200"), new BigInteger("3")),
                        new CommonStock("xyz", new BigInteger("100"), new BigInteger("6"))}), new BigDecimal("3.3020")}
        };
    }

    @Test(dataProvider = "geometricalMean")
    public void testGeometricalMean(Collection<AbstractStock> stocks, BigDecimal expectedResult) throws Exception {
        Assert.assertEquals(GeometricalMeanCalculator.geometricalMean(stocks), expectedResult);
    }
}