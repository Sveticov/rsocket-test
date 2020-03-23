package com.svetikov.rsockettest.server;

import com.svetikov.rsockettest.model.MarketData;
import com.svetikov.rsockettest.model.MarketDataRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;



@Controller
public class MarketDataRSocketController {

    private final MarketDataRepository marketDataRepository;

    @Autowired
    public MarketDataRSocketController(MarketDataRepository marketDataRepository) {
        this.marketDataRepository = marketDataRepository;
    }

    @MessageMapping("currentMarketData")
    public Mono<MarketData> currentMarketData(MarketDataRequest marketDataRequest) {
        return marketDataRepository.getOne(marketDataRequest.getStock());
    }
}
