package com.tepe.tradingcards.model;

import com.tepe.tradingcards.model.interfaces.Drawable;
import com.tepe.tradingcards.util.IOUtil;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Objects;

@Component
public class Player {
    private int health;
    private int activeMana;
    private int allowedMana;
    private Drawable deck;
    private Drawable hand;

    private Player() {
    }

    public Player(int health, int activeMana, int allowedMana, Drawable deck, Drawable hand) {
        this.health = health;
        this.activeMana = activeMana;
        this.allowedMana = allowedMana;
        this.deck = deck;
        this.hand = hand;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getActiveMana() {
        return activeMana;
    }

    public void setActiveMana(int activeMana) {
        this.activeMana = activeMana;
    }

    public int getAllowedMana() {
        return allowedMana;
    }

    public void setAllowedMana(int allowedMana) {
        this.allowedMana = allowedMana;
    }

    public Drawable getDeck() {
        return deck;
    }

    public Drawable getHand() {
        return hand;
    }

    public void printHand() {
        if (!Objects.isNull(hand)) {
            this.hand.print();
        } else {
            IOUtil.print("Your hand is empty");
        }
    }

    public boolean isAlive() {
        return this.health > 0;
    }

    public void bleed() {
        this.health--;
    }

    /**
     * Checks if hand is overloaded and discards every last inserted playable in hand until hand is no more overloaded.
     * Returns false if hand is not overloaded at all.
     * @param maxHandSize
     * @return
     */
    public boolean checkOverloadAndDiscard(int maxHandSize) {
        boolean discarded = false;
        while (this.hand.isOverloaded(maxHandSize)) {
            IOUtil.print("Hand overloaded. Discarding: ");
            this.hand.discardLast().print();
            discarded = true;
        }
        return discarded;
    }

}
