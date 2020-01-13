package com.tepe.tradingcards.bo;

import com.tepe.tradingcards.config.BaseTest;
import com.tepe.tradingcards.exception.TradingCardsException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class DeckBOTest extends BaseTest {

    @Autowired
    private DeckBO deckBO;

    @Test
    public void testDeckBO() throws TradingCardsException {
        deckBO.createDeck();
    }
}
