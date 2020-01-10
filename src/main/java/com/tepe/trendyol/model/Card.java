package com.tepe.trendyol.model;

public class Card {
    private int manaCost;
    private int damage;
    private String cardName;
    private MoveType moveType;

    private Card(){}

    public Card(String cardName, int manaCost, int damage, MoveType moveType) {
        this.cardName = cardName;
        this.manaCost = manaCost;
        this.damage = damage;
        this.moveType = moveType;
    }

    public String getCardName() {
        return cardName;
    }

    public int getManaCost() {
        return this.manaCost;
    }

    public int getDamage() {
        return this.damage;
    }

    public MoveType getMoveType() {
        return moveType;
    }
}
