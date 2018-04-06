package eu.jedrzej.jptest.calculations;

import eu.jedrzej.jptest.model.AbstractStock;
import eu.jedrzej.jptest.model.CommonStock;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

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
                {Arrays.asList(new AbstractStock[] { new CommonStock("ZZZ", new BigInteger("100"), new BigInteger("1000000"))}),  new BigInteger("1000") },
                {Arrays.asList(new AbstractStock[] {new CommonStock("abc", new BigInteger("200"), new BigInteger("4")), new CommonStock("xyz", new BigInteger("18"), new BigInteger("5184"))}), new BigInteger("144")}
        };
    }

    @Test(dataProvider = "geometricalMean")
    public void testGeometricalMean(Collection<AbstractStock> stocks, BigInteger expectedResult) throws Exception {
        Assert.assertEquals(GeometricalMeanCalculator.geometricalMean(stocks), expectedResult);
    }
}