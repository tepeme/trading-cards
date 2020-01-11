package com.tepe.tradingcards.bo;

import com.tepe.tradingcards.config.Properties;
import com.tepe.tradingcards.exception.TradingCardsException;
import com.tepe.tradingcards.model.Deck;
import com.tepe.tradingcards.model.interfaces.Playable;
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
        List<Playable> playables = new ArrayList<>();
        for (String defaultManaCost : properties.getDefaultManaCosts().split(",")) {
            int manaCost = Integer.parseInt(defaultManaCost);
            playables.add(cardBO.pollCard(manaCost));
        }
        Collections.shuffle(playables);

        return new Deck(playables);
    }

}
