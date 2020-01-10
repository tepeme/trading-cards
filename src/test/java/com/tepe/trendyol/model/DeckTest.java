package com.tepe.trendyol.model;

import com.tepe.trendyol.bo.CardBO;
import com.tepe.trendyol.bo.DeckBO;
import com.tepe.trendyol.config.Properties;
import com.tepe.trendyol.exception.TradingCardsException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@ContextConfiguration(classes= {Properties.class})
public class DeckTest {

    @Autowired
    private Properties properties;

    @Autowired private DeckBO deckBO;

    @Test
    public void testDeck() throws TradingCardsException {

        Deck deck = deckBO.createDeck();
        assertEquals(properties.getMaxDeckSize(), deck.getCards().size());
    }
}
