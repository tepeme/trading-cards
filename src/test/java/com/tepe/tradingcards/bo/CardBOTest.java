package com.tepe.tradingcards.bo;

import com.tepe.tradingcards.config.BaseTest;
import com.tepe.tradingcards.exception.TradingCardsException;
import com.tepe.tradingcards.model.Card;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class CardBOTest extends BaseTest {

    @Autowired private CardBO cardBO;

    @Test
    public void testCard() throws TradingCardsException {
        Card card = cardBO.pollCard(0);
        try {
            Card card2 = cardBO.pollCard(-1);
        } catch (TradingCardsException e) {
            assertTrue(true);
        }
    }
}
