package com.tepe.tradingcards.model;

import com.tepe.tradingcards.bo.DeckBO;
import com.tepe.tradingcards.config.Properties;
import com.tepe.tradingcards.exception.TradingCardsException;
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
@ContextConfiguration(classes= {Properties.class})
public class DeckTest {

    @Autowired
    private Properties properties;

    @Autowired private DeckBO deckBO;

    @Test
    public void testDeck() throws TradingCardsException {

        Deck deck = deckBO.createDeck();
        assertEquals(properties.getMaxDeckSize(), deck.getSize());
        deck.print();
    }
}