package com.svetikov.rsockettest.client;

import com.svetikov.rsockettest.model.MarketData;
import com.svetikov.rsockettest.model.MarketDataRequest;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MarketDataRestController {
    private final RSocketRequester rSocketRequester;
@Autowired
    public MarketDataRestController(RSocketRequester rSocketRequester) {
        this.rSocketRequester = rSocketRequester;
    }


    @GetMapping(value = "/current/{stock}")
    public Publisher<MarketData> current(@PathVariable("stock")String stock){
    return rSocketRequester.route("currentMarketData")
            .data(new MarketDataRequest(stock))
            .retrieveFlux(MarketData.class);
    }
}
