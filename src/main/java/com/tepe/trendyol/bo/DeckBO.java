package com.tepe.trendyol.bo;

import com.tepe.trendyol.config.Properties;
import com.tepe.trendyol.exception.TradingCardsException;
import com.tepe.trendyol.model.Card;
import com.tepe.trendyol.model.Deck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component public class DeckBO {

    @Autowired private Properties properties;

    @Autowired private CardBO cardBO;

    /**
     * Creates initial deck
     *
     * @return Deck
     */
    public Deck createDeck() throws TradingCardsException {
        List<Card> cards = new ArrayList<>();
        for (String defaultManaCost : properties.getDefaultManaCosts().split(",")) {
            int manaCost = Integer.parseInt(defaultManaCost);
            cards.add(cardBO.pollCard(manaCost));
        }
        Collections.shuffle(cards);

        return new Deck(cards);
    }

    /**
     * Initializes a hand from random
     *
     * @param deck
     * @param initHandCardCount
     * @return
     */
    public Deck initHand(Deck deck, int initHandCardCount) {
        List<Card> hand = new ArrayList<>();
        int deckSize = deck.getCards().size();
        for (int i = 0; i < initHandCardCount; i++) {
            hand.add(deck.getCards().remove(0));
        }
        return new Deck(hand);
    }

}
