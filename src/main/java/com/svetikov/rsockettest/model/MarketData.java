package com.svetikov.rsockettest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MarketData {
    private String stock;
    private int currentPrice;

    public static MarketData fromException(Exception ex){
        MarketData marketData=new MarketData();
        marketData.setStock(ex.getMessage());
        return marketData;
    }
}
