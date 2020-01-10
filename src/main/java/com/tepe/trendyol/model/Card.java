package com.tepe.trendyol.model;

public class Card {
    private int manaCost;
    private int damage;

    private Card(){}

    public Card(int manaCost, int damage) {
        this.manaCost = manaCost;
        this.damage = damage;
    }

    public int getManaCost() {
        return this.manaCost;
    }

    public int getDamage() {
        return this.damage;
    }
}
