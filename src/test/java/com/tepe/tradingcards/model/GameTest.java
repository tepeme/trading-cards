package com.tepe.tradingcards.model;

import com.tepe.tradingcards.config.BaseTest;
import com.tepe.tradingcards.config.Properties;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

public class GameTest extends BaseTest {

    @Autowired
    private Game game;

    @Autowired
    private Properties properties;

    @Test
    public void testGame() {
        assertEquals(properties.getPlayerCount(), game.getPlayers().size());
    }
}
