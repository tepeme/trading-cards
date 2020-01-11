package com.tepe.tradingcards.model;

import com.tepe.tradingcards.bo.DeckBO;
import com.tepe.tradingcards.config.BaseTest;
import com.tepe.tradingcards.config.Properties;
import com.tepe.tradingcards.exception.TradingCardsException;
import com.tepe.tradingcards.model.interfaces.Playable;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DeckTest extends BaseTest {

    private static final int MAX_PLAYABLES = 5;

    @Autowired
    private DeckBO deckBO;

    @Autowired
    private Properties properties;


    @Test
    public void testDeck() throws TradingCardsException {

        Deck deck = deckBO.createDeck();
        assertEquals(properties.getMaxDeckSize(), deck.getSize());
        deck.print();
    }

    @Test
    public void testFind() throws TradingCardsException {
        Deck deck = deckBO.createDeck();
        Playable playable = deck.getPlayables().get(properties.getMaxDeckSize()-1);
        assertEquals(playable, deck.findById(playable.getId()));
        assertNull(deck.findById(-1));
        assertEquals(playable, deck.findByName(playable.getName()));
        assertNull(deck.findByName(""));
    }

    @Test
    public void testAdd() {
        Deck deck = new Deck(null);
        assertEquals(0, deck.getSize());
        deck.add(null);
        assertNull(deck.draw());
        List<Playable> playables = new ArrayList<>();
        playables.add(null);
        playables.add(null);
        deck.addAll(playables);
        assertNull(deck.draw());
        assertNull(deck.draw());
        deck = new Deck(null);
        deck.addAll(playables);
        assertNull(deck.draw());
        assertNull(deck.draw());
    }

    @Test
    public void testDrawableOperations() throws TradingCardsException {
        Deck deck = deckBO.createDeck();
        assertFalse(deck.isOverloaded(properties.getMaxDeckSize()));
        assertTrue(deck.isOverloaded(properties.getMaxDeckSize() - 1));
        Playable last = deck.getPlayables().get(properties.getMaxDeckSize()-1);
        assertEquals(last, deck.discardLast());
        assertFalse(deck.isEmpty());
        assertNotNull(deck.draw());

        int deckSize = deck.getSize();
        for (int i = 0; i < deckSize; i++) {
            deck.discardLast();
        }
        assertTrue(deck.isEmpty());

    }

}
