package com.tepe.tradingcards.bo;

import com.tepe.tradingcards.config.BaseTest;
import com.tepe.tradingcards.config.Properties;
import com.tepe.tradingcards.exception.TradingCardsException;
import com.tepe.tradingcards.model.Player;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class PlayerBOTest extends BaseTest {

    @Autowired
    private PlayerBO playerBO;

    @Autowired
    private Properties properties;

    @Test
    public void testPlayerBO() throws TradingCardsException {
        Player player = playerBO.createPlayer(0);
        assertTrue(player.draw());
        assertEquals(1, player.getHand().getSize());
        assertEquals(properties.getMaxDeckSize() - 1, player.getDeck().getSize());
        assertTrue(player.draw(properties.getMaxDeckSize()));
        assertEquals(Math.min(properties.getPlayerMaxHandSize(), properties.getMaxDeckSize()),
                player.getHand().getSize());
    }
}
