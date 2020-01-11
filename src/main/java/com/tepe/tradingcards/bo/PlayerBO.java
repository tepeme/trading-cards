package com.tepe.tradingcards.bo;

import com.tepe.tradingcards.config.Properties;
import com.tepe.tradingcards.exception.TradingCardsException;
import com.tepe.tradingcards.model.Deck;
import com.tepe.tradingcards.model.Player;
import com.tepe.tradingcards.model.interfaces.Playable;
import com.tepe.tradingcards.util.IOUtil;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component public class PlayerBO {

    public static volatile PlayerBO INSTANCE;

    @Autowired private Properties properties;

    @Autowired private DeckBO deckBO;

    /**
     * Initializes a player and by system properties.
     * @return Player
     */
    public Player createPlayer() throws TradingCardsException {
        Player player;
        Deck deck = deckBO.createDeck();
        Deck hand = new Deck(new ArrayList<>());
        player = new Player(properties.getPlayerMaxHealth(), properties.getPlayerInitMana(),
                properties.getPlayerInitMana(), deck, hand);

        return player;
    }

    /**
     * Draws playable from player's deck and returns true.
     * If the deck is empty than returns false
     * @return
     */
    public boolean draw(Player player) {
        if (ObjectUtils.allNotNull(player, player.getDeck())){
            IOUtil.print("Invalid operation!");
            return false;
        }

        Playable playable = player.getDeck().draw();
        boolean result = false;

        if (!Objects.isNull(playable)) {
            player.getHand().add(playable);
            playable.print();
            result = true;
        }

        if (player.checkOverloadAndDiscard(properties.getPlayerMaxHandSize())){
            result = false;
        }

        return result;
    }

    /**
     * Draws multiple playables from player's deck returns true if player can draw at least one playable
     * @param player
     * @param drawCount
     * @return
     */
    public boolean draw(Player player, int drawCount) {
        if (ObjectUtils.allNotNull(player, player.getDeck())){
            IOUtil.print("Invalid operation!");
            return false;
        }

        boolean result = false;

        for (int i = 0; i < drawCount; i++) {
            result = result || draw(player);
        }

        return result;
    }

}
