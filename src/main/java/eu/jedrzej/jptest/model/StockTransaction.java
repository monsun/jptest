package eu.jedrzej.jptest.model;

import org.joda.time.DateTime;

import java.math.BigInteger;

/**
 * Created by JKalinowski on 2018-03-23.
 *
 * For keeping transaction records for volume weighted stock price calculator
 */
public class StockTransaction {

    private boolean buyIndicator;

    private BigInteger tradePrice;

    private BigInteger quantity;

    private DateTime dateTime;

    public StockTransaction(BigInteger tradePrice, BigInteger quantity, boolean buyIndicator, DateTime dateTime) {
        this.tradePrice = tradePrice;
        this.quantity = quantity;
        this.buyIndicator = buyIndicator;
        this.dateTime = dateTime;
    }

    public BigInteger getTradePrice() {
        return tradePrice;
    }

    public void setTradePrice(BigInteger tradePrice) {
        this.tradePrice = tradePrice;
    }

    public BigInteger getQuantity() {
        return quantity;
    }

    public void setQuantity(BigInteger quantity) {
        this.quantity = quantity;
    }

    public boolean isBuyIndicator() {
        return buyIndicator;
    }

    public void setBuyIndicator(boolean buyIndicator) {
        this.buyIndicator = buyIndicator;
    }

    public DateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(DateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "StockTransaction{" +
                "buyIndicator=" + buyIndicator +
                ", tradePrice=" + tradePrice +
                ", quantity=" + quantity +
                ", dateTime=" + dateTime +
                '}';
    }
}
