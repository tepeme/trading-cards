package com.tepe.trendyol.model;

import com.tepe.trendyol.config.Properties;
import com.tepe.trendyol.bo.PlayerBO;
import com.tepe.trendyol.exception.TradingCardsException;
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
@ContextConfiguration(classes= { PlayerBO.class, Properties.class})
public class PlayerTest {

    @Autowired
    private Properties properties;

    @Autowired
    private PlayerBO playerBO;

    @Test
    public void testInitPlayer() throws TradingCardsException {
        Player player = playerBO.createPlayer();
        assertEquals(properties.getPlayerMaxHealth(), player.getHealth());
        assertEquals(properties.getMaxDeckSize(), player.getDeck().getCards().size());
        assertEquals(0, player.getActiveMana());
        assertEquals(0, player.getAllowedMana());
    }
}
