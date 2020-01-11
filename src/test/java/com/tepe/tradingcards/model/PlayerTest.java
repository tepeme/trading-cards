package com.tepe.tradingcards.model;

import com.tepe.tradingcards.bo.CardBO;
import com.tepe.tradingcards.bo.DeckBO;
import com.tepe.tradingcards.config.Properties;
import com.tepe.tradingcards.bo.PlayerBO;
import com.tepe.tradingcards.exception.TradingCardsException;
import com.tepe.tradingcards.util.TradingCardsUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@ContextConfiguration(classes= { PlayerBO.class, DeckBO.class, CardBO.class, TradingCardsUtil.class, Properties.class})
public class PlayerTest {

    @Autowired
    private Properties properties;

    @Autowired
    private PlayerBO playerBO;

    @Test
    public void testInitPlayer() throws TradingCardsException {
        Player player = playerBO.createPlayer();
        assertEquals(properties.getPlayerMaxHealth(), player.getHealth());
        assertEquals(properties.getMaxDeckSize(), player.getDeck().getSize());
        assertEquals(0, player.getActiveMana());
        assertEquals(0, player.getAllowedMana());
        player.printHand();
    }

    @Test
    public void testPlayerOperations() throws TradingCardsException {
        Player player = playerBO.createPlayer();
        playerBO.draw(player);
    }

    @Test
    public void testInvalidDraw() throws TradingCardsException {
        Player player = playerBO.createPlayer();
        playerBO.draw(player, properties.getMaxDeckSize() + 1);
        int handAmount = Math.min(properties.getPlayerMaxHandSize(), properties.getMaxDeckSize());
        assertEquals(handAmount, player.getHand().getSize());
    }
}
