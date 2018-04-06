package eu.jedrzej.jptest.model;

import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by JKalinowski on 2018-04-02.
 */
public class StockHelper {

    private static final int TRANSACTIONS_AGE_IN_MINUTES = 15;

    private static List<StockTransaction> transactions = new LinkedList<>();

    public static AbstractStock getStockBySymbol(String stockSymbol) {
        try {
            InputStream is = StockHelper.class.getClassLoader().getResourceAsStream("stocks.json");
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(new InputStreamReader(is));
            JSONArray stocks = (JSONArray) jsonObject.get("stocks");
            for (Object stock : stocks) {
                JSONObject stockObject = (JSONObject) stock;
                if (stockObject.containsKey("symbol") && stockSymbol.equals(stockObject.get("symbol"))) {
                    if ("Common".equals(stockObject.get("type"))) {
                        return new CommonStock((String) stockObject.get("symbol"), new BigInteger((String) stockObject.get("lastDividendPennies")),
                                new BigInteger((String) stockObject.get("parValuePennies")));
                    } else if ("Preferred".equals(stockObject.get("type"))) {
                        return new PreferredStock((String) stockObject.get("symbol"), new BigInteger((String) stockObject.get("lastDividendPennies")),
                                new BigInteger((String) stockObject.get("parValuePennies")), new BigDecimal((String) stockObject.get("fixedDividendPercent")));
                    }
                }
            }
            throw new IllegalStateException("Stock not found " + stockSymbol + ".");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static StockTransaction recordTransaction(BigInteger tradePrice, BigInteger quantity, boolean buyIndicator, DateTime dateTime) {
        StockTransaction transaction = new StockTransaction(tradePrice, quantity, buyIndicator, dateTime);
        transactions.add(transaction);
        return transaction;
    }


    public static List<StockTransaction> getRecentTransactions() {
        DateTime now = new DateTime();
        List<StockTransaction> result = new LinkedList<>();
        for (StockTransaction transaction: transactions) {
            Interval interval = new Interval(transaction.getDateTime(), now);
            if (interval.toDuration().getStandardMinutes() < TRANSACTIONS_AGE_IN_MINUTES) {
                result.add(transaction);
            }
        }
        return result;
    }

    public static List<AbstractStock> getAllStocks() {
        try {
            List<AbstractStock> result = new LinkedList<>();
            InputStream is = StockHelper.class.getClassLoader().getResourceAsStream("stocks.json");
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(new InputStreamReader(is));
            JSONArray stocks = (JSONArray) jsonObject.get("stocks");
            for (Object stock : stocks) {
                JSONObject stockObject = (JSONObject) stock;
                if ("Common".equals(stockObject.get("type"))) {
                    result.add(new CommonStock((String) stockObject.get("symbol"), new BigInteger((String) stockObject.get("lastDividendPennies")),
                            new BigInteger((String) stockObject.get("parValuePennies"))));
                } else if ("Preferred".equals(stockObject.get("type"))) {
                    result.add(new PreferredStock((String) stockObject.get("symbol"), new BigInteger((String) stockObject.get("lastDividendPennies")),
                            new BigInteger((String) stockObject.get("parValuePennies")), new BigDecimal((String) stockObject.get("fixedDividendPercent"))));
                }
            }
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
