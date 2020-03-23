package com.svetikov.rsockettest.server;

import com.svetikov.rsockettest.model.MarketData;
import com.svetikov.rsockettest.model.MarketDataRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

import java.util.Random;

@Slf4j
@Component
public class MarketDataRepository {
    private static final int BOUND=100;
    private Random random=new Random();

    public Mono<MarketData> getOne(String stock) {
        return Mono.just(getMarketDataResponse(stock));
    }

    private MarketData getMarketDataResponse(String stock) {
        return new MarketData(stock,random.nextInt(BOUND));
    }


}
