package com.tepe.trendyol.bo;

import com.tepe.trendyol.exception.TradingCardsException;
import com.tepe.trendyol.exception.TradingCardsExceptionType;
import com.tepe.trendyol.model.Card;
import com.tepe.trendyol.util.TradingCardsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component public class CardBO {

    private static Logger LOG = LoggerFactory.getLogger(TradingCardsUtil.class);

    @Autowired private TradingCardsUtil tradingCardsUtil;

    public Card pollCard(int manaCost) throws TradingCardsException {
        List<Card> allCards = tradingCardsUtil.getAllCardsByManaCost(manaCost);

        if (allCards.size() < 1) {
            LOG.error("Not enough cards in game");
            throw new TradingCardsException(TradingCardsExceptionType.NOT_ENOUGH_CARDS_IN_GAME);
        }

        Random random = new Random();

        return allCards.get(random.nextInt(allCards.size()));
    }
}
