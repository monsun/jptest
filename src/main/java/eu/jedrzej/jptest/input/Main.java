package eu.jedrzej.jptest.input;


import eu.jedrzej.jptest.calculations.DividendYieldCalculator;
import eu.jedrzej.jptest.calculations.GeometricalMeanCalculator;
import eu.jedrzej.jptest.calculations.PtoERatioCalculator;
import eu.jedrzej.jptest.calculations.VolumeWeightedStockPriceCalculator;
import eu.jedrzej.jptest.model.AbstractStock;
import eu.jedrzej.jptest.model.CommonStock;
import eu.jedrzej.jptest.model.PreferredStock;
import eu.jedrzej.jptest.model.StockHelper;
import org.jline.reader.EndOfFileException;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.reader.UserInterruptException;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.joda.time.DateTime;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * Created by JKalinowski on 2018-04-02.
 */
public class Main {

    private final static String PROMPT = "$>";

    public static void main(String[] args) throws IOException {
        Terminal terminal = TerminalBuilder.builder().build();
        LineReader reader = LineReaderBuilder.builder().terminal(terminal).build();
        while (true) {
            String line = null;
            try {
                line = reader.readLine(PROMPT);
                StringTokenizer stringTokenizer = new StringTokenizer(line);
                String command = stringTokenizer.nextToken();
                switch (command) {
                    case "dy":
                    case "dividendYield": {
                        String stockSymbol = stringTokenizer.nextToken();
                        String marketPriceStr = stringTokenizer.nextToken();
                        try {
                            BigInteger marketPrice = new BigInteger(marketPriceStr);
                            BigDecimal dividendYield = DividendYieldCalculator.dividendYield(StockHelper.getStockBySymbol(stockSymbol), marketPrice);
                            System.out.println("Dividend yield: " + dividendYield);
                        } catch (NumberFormatException e) {
                            System.out.println("Wrong format number for market price: " + marketPriceStr + ".");
                        }
                        break;
                    }


                    case "pe":
                    case "pERatio": {
                        String stockSymbol = stringTokenizer.nextToken();
                        String marketPriceStr = stringTokenizer.nextToken();
                        try {
                            BigInteger marketPrice = new BigInteger(marketPriceStr);
                            AbstractStock stock = StockHelper.getStockBySymbol(stockSymbol);
                            BigDecimal pERatio = null;
                            if (stock instanceof CommonStock) {
                                pERatio = PtoERatioCalculator.pToERatio((CommonStock) stock, marketPrice);
                            } else if (stock instanceof PreferredStock) {
                                pERatio = PtoERatioCalculator.pToERatio((PreferredStock) stock, marketPrice);
                            }
                            System.out.println("P to E ratio: " + pERatio);
                        } catch (NumberFormatException e) {
                            System.out.println("Wrong format number for market price: " + marketPriceStr + ".");
                        }

                        break;
                    }

                    case "record": {
                        String quantityStr = stringTokenizer.nextToken();
                        boolean buy = stringTokenizer.nextToken().equals("buy");
                        String tradePriceStr = stringTokenizer.nextToken();
                        try {
                            BigInteger quantity = new BigInteger(quantityStr);
                            BigInteger tradePrice = new BigInteger(tradePriceStr);
                            System.out.println(StockHelper.recordTransaction(tradePrice, quantity, buy, new DateTime()));
                        } catch (NumberFormatException e) {
                            System.out.println("Wring number format for quantity or trade price.");
                            e.printStackTrace();
                        }
                        break;
                    }

                    case "vwsp":
                    case "volumeWeightedStockPrice": {
                        BigDecimal price = VolumeWeightedStockPriceCalculator.volumeWeightedStockPrice(StockHelper.getRecentTransactions());
                        System.out.println("Volume Weighted Stock Price: " + price);
                        break;
                    }

                    case "gbce":
                    case "index": {
                        BigInteger index = GeometricalMeanCalculator.geometricalMean(StockHelper.getAllStocks());
                        System.out.println("BGCE index: " + index);
                        break;
                    }
                }

            } catch (UserInterruptException e) {
                // Ignore
            } catch (EndOfFileException e) {
                return;
            }
        }

    }
}
