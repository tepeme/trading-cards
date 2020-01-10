package com.tepe.trendyol.exception;

public class TradingCardsException extends Exception {

    TradingCardsExceptionType exceptionType;

    public TradingCardsException(TradingCardsExceptionType exceptionType) {
        this.exceptionType = exceptionType;
    }
}
