package com.src.service;

import org.apache.camel.Exchange;
import org.apache.camel.ExchangeException;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service("camelRetryExceptionHandlerService")
public class CamelRetryExceptionHandlerServiceImpl implements CamelRetryExceptionHandlerService {
    Logger logger = Logger.getLogger(this.getClass().getName());
    @Override
    public void handleCustomException(Exchange e,@ExchangeException Exception causedBy) {
        logger.info("\n---------------------------------------------------------------------------------------------------------------------------------------\n" +
                "threshold has been reached\n" +
                "Exchange route id :"+e.getFromRouteId() +
                "\ncaused:"+causedBy.getMessage()+
                "\n---------------------------------------------------------------------------------------------------------------------------------------\n"

        );
    }
}
