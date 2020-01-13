package com.tepe.tradingcards.model;

import com.tepe.tradingcards.bo.PlayerBO;
import com.tepe.tradingcards.config.BaseTest;
import com.tepe.tradingcards.config.Properties;
import com.tepe.tradingcards.exception.TradingCardsException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class PlayerTest extends BaseTest {

    @Autowired
    private Properties properties;

    @Autowired
    private PlayerBO playerBO;

    @Test
    public void testInitPlayer() throws TradingCardsException {
        Player player = playerBO.createPlayer(0);
        assertEquals(properties.getPlayerMaxHealth(), player.getHealth());
        assertEquals(properties.getMaxDeckSize(), player.getDeck().getSize());
        assertEquals(0, player.getActiveMana());
        assertEquals(0, player.getAllowedMana());
        player.printHand();
    }

    @Test
    public void testPlayerOperations() throws TradingCardsException {
        Player player = playerBO.createPlayer(0);
        player.draw();
    }

    @Test
    public void testOverDraw() throws TradingCardsException {
        Player player = playerBO.createPlayer(0);
        player.draw(properties.getMaxDeckSize() + 1);
        int handAmount = Math.min(properties.getPlayerMaxHandSize(), properties.getMaxDeckSize());
        assertEquals(handAmount, player.getHand().getSize());
    }

    @Test
    public void testEmptyPlayer() {
        Player player = new Player(0, properties.getPlayerMaxHealth(), 0, 0,
                null, null);
        Player.setMaxHandSize(properties.getPlayerMaxHandSize());
        Player.setMaxMana(properties.getPlayerMaxMana());

        player.printHand();
        assertEquals(0, player.getId());
        assertFalse(player.draw());
        assertNotNull(player.getDeck());
        assertNotNull(player.getHand());
        assertTrue(player.isAlive());
        player.bleed();
        assertEquals(properties.getPlayerMaxHealth() - 1, player.getHealth());
    }
}
