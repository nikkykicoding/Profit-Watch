package com.nikkykicoding.profitwatch;
public class Stock {

    private String stockName;
    private double buyPrice;
    private double sellPrice;
    private String date;
    private double profit;

    private int id; // Add this

    public Stock(int id, String stockName, double buyPrice, double sellPrice, String date, double profit) {
        this.id = id;
        this.stockName = stockName;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
        this.date = date;
        this.profit = profit;
    }

    public int getId() {
        return id;
    }

    public String getStockName() {
        return stockName;
    }

    public double getBuyPrice() {
        return buyPrice;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public String getDate() {
        return date;
    }

    public double getProfit() {
        return profit;
    }
}
