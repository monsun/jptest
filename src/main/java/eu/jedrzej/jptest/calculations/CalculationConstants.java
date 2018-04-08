package eu.jedrzej.jptest.calculations;

import java.math.RoundingMode;

/**
 * This class holds precision settings for calculations. This can be moved to a configurable resource at a later time.
 *
 * Created by JKalinowski on 2018-03-22.
 */
public class CalculationConstants {

    /**
     * Used for rounding purposes
     */
    public final static int SCALE = 4;

    public final static RoundingMode ROUNDING_MODE = RoundingMode.HALF_UP;

}
