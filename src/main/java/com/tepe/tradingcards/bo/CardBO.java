package com.tepe.tradingcards.bo;

import com.tepe.tradingcards.exception.TradingCardsException;
import com.tepe.tradingcards.exception.TradingCardsExceptionType;
import com.tepe.tradingcards.model.Card;
import com.tepe.tradingcards.util.TradingCardsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Random;

@Component public class CardBO {

    @Autowired private TradingCardsUtil tradingCardsUtil;

    private Random random = new Random();

    public Card pollCard(int manaCost) throws TradingCardsException {
        List<Card> allCards = tradingCardsUtil.getAllCardsByManaCost(manaCost);

        if (Objects.isNull(allCards) || allCards.isEmpty()) {
            throw new TradingCardsException(TradingCardsExceptionType.NOT_ENOUGH_CARDS_IN_GAME);
        }

        return allCards.get(random.nextInt(allCards.size()));
    }
}
