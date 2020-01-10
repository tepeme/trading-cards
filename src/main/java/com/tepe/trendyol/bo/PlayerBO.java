package com.tepe.trendyol.bo;

import com.tepe.trendyol.config.Properties;
import com.tepe.trendyol.exception.TradingCardsException;
import com.tepe.trendyol.model.Card;
import com.tepe.trendyol.model.Deck;
import com.tepe.trendyol.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component public class PlayerBO {

    @Autowired private Properties properties;

    @Autowired private DeckBO deckBO;

    /**
     * Initializes a player and by system properties.
     * @return Player
     */
    public Player createPlayer() throws TradingCardsException {
        Player player;
        Deck deck = deckBO.createDeck();
        player = new Player(properties.getPlayerMaxHealth(), properties.getPlayerInitMana(),
                properties.getPlayerInitMana(), deck, properties.getPlayerInitCards());

        return player;
    }

    /**
     * Prints all Cards in Players Hand
     * Ex. 1) Mana Cost: 0, Damage: 0
     *     2) Mana Cost: 5, Damage: 5
     *     3) Mana Cost: 3, Damage: 3
     * @param player
     */
    public void printHand(Player player) {
        Deck hand = player.getHand();
        for (int i = 0; i < hand.getCards().size(); i++) {
            Card card = hand.getCards().get(i);
            System.out.println((i+1)+") Mana Cost: " + card.getManaCost() + ", Damage: " + card.getDamage());
        }
    }

    /**
     * Draws card from player's deck and returns true.
     * If the deck is empty than returns false
     * @param player
     * @return
     */
    public boolean drawCard(Player player) {
        if (Objects.isNull(player.getDeck()) || player.getDeck().getCards().isEmpty()){
            return false;
        }
        Card card = player.getDeck().getCards().remove(0);
        if (!checkOverload(player.getHand().getSize())) {
            player.getHand().getCards().add(card);
            return true;
        }
        return true;
    }

    private boolean checkOverload(int handSize) {
        return (handSize + 1) > properties.getPlayerMaxHandSize();
    }

    public boolean checkPlayer(Player player) {
        bleed(player);
        boolean isAlive = true;
        if (player.getHealth() == 0) {
            isAlive = false;
        }
        return isAlive;
    }

    private void bleed(Player player) {
        if (player.getHand().isEmpty() && player.getDeck().isEmpty()) {
            player.setHealth(player.getHealth()-1);
        }
    }
}
