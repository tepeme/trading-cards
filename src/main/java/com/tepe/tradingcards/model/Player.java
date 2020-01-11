package com.tepe.tradingcards.model;

import com.tepe.tradingcards.model.interfaces.Drawable;
import com.tepe.tradingcards.model.interfaces.Playable;
import com.tepe.tradingcards.util.IOUtil;
import org.apache.commons.lang3.ObjectUtils;

import java.util.Objects;

public class Player {
    private int id;
    private int health;
    private int activeMana;
    private int allowedMana;
    private Drawable deck;
    private Drawable hand;

    private static int maxHandSize;
    private static int maxMana;

    public Player(int id, int health, int activeMana, int allowedMana, Drawable deck, Drawable hand, int maxHandSize, int maxMana) {
        this.id = id;
        this.health = health;
        this.activeMana = activeMana;
        this.allowedMana = allowedMana;
        this.deck = deck;
        this.hand = hand;
        Player.maxHandSize = maxHandSize;
        Player.maxMana = maxMana;
    }

    public int getId() {
        return id;
    }

    public int getHealth() {
        return health;
    }

    public int getActiveMana() {
        return activeMana;
    }

    public int getAllowedMana() {
        return allowedMana;
    }

    public Drawable getDeck() {
        if (Objects.isNull(this.deck)) {
            deck = new Deck(null);
        }
        return deck;
    }

    public Drawable getHand() {
        if (Objects.isNull(this.hand)) {
            hand = new Deck(null);
        }
        return hand;
    }

    public void printHand() {
        if (!Objects.isNull(hand)) {
            this.hand.print();
        } else {
            IOUtil.getInstance().print("Your hand is empty");
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
     * @param maxHandSize Max allowed size for this {@code Player}s hand
     * @return boolean
     */
    public boolean checkOverloadAndDiscard(int maxHandSize) {
        boolean discarded = false;
        while (this.hand.isOverloaded(maxHandSize)) {
            IOUtil.getInstance().print("Hand overloaded. Discarding: ");
            this.hand.discardLast().print();
            discarded = true;
        }
        return discarded;
    }

    /**
     * Draws playable from player's deck and returns true.
     * If the deck is empty than returns false
     * @return
     */
    public boolean draw() {
        if (Objects.isNull(this.deck)){
            IOUtil.getInstance().print("Invalid operation!");
            return false;
        }

        Playable playable = this.deck.draw();
        boolean result = false;

        if (!Objects.isNull(playable)) {
            this.getHand().add(playable);
            result = !this.checkOverloadAndDiscard(this.maxHandSize);
        } else {
            bleed();
            IOUtil.getInstance().print("Bleeding");
        }

        return result;
    }

    /**
     * Draws multiple playables from player's deck returns true if player can draw at least one playable
     * @param drawCount
     * @return
     */
    public boolean draw(int drawCount) {
        boolean result = false;

        for (int i = 0; i < drawCount; i++) {
            boolean drawResult = draw();
            result = (result || drawResult);
        }

        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (Objects.isNull(o)) {
            return false;
        }
        return this.id == ((Player) o).getId();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.id);
    }

    public void prepareForTurn(int initCards) {
        if (this.allowedMana == 0) {
            draw(initCards);
        } else {
            draw();
        }
        if (this.allowedMana < Player.maxMana) {
            this.allowedMana++;
        }
        this.activeMana = this.allowedMana;
        IOUtil.getInstance().print("You have " + this.health + " HP!");
    }

    public void reduceMana(int reduceBy) {
        this.activeMana -= reduceBy;
    }

    public void takeDamage(int damage) {
        this.health -= damage;
        IOUtil.getInstance().print("Player #" + (this.id + 1) + ", you have " + this.health + "HP left!");
    }

    public boolean canPlayPlayable() {
        boolean result = false;
        if (activeMana != 0) {
            result = this.getHand().containsPlayableForMana(activeMana);
            if (!result) {
                IOUtil.getInstance().print("Not Enough Mana for Player #" + (this.id + 1) + "! Skipping Turn!");
            }
        }
        return result;
    }


}
