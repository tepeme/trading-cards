package com.tepe.trendyol.model;

public class Player {
    private int health;
    private int activeMana;
    private int allowedMana;
    private Deck deck;

    private Player() {}

    public Player(int health, int activeMana, int allowedMana, Deck deck) {
        this.health = health;
        this.activeMana = activeMana;
        this.allowedMana = allowedMana;
        this.deck = deck;
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

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }
}
