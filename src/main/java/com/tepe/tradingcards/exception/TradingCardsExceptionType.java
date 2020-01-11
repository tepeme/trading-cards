package com.tepe.tradingcards.exception;

public enum TradingCardsExceptionType {

    NOT_ENOUGH_CARDS_IN_GAME("Not enough cards of this mana cost in the game");

    public String value;
    TradingCardsExceptionType(String value) {this.value = value;}
}
