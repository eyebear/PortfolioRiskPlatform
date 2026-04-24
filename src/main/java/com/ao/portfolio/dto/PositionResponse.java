package com.ao.portfolio.dto;

public class PositionResponse {

    private Long id;
    private String symbol;
    private int quantity;
    private double avgPrice;

    public PositionResponse() {
    }

    public PositionResponse(Long id, String symbol, int quantity, double avgPrice) {
        this.id = id;
        this.symbol = symbol;
        this.quantity = quantity;
        this.avgPrice = avgPrice;
    }

    public Long getId() {
        return id;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getAvgPrice() {
        return avgPrice;
    }
}