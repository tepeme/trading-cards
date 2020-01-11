package com.tepe.tradingcards.model;

import com.tepe.tradingcards.model.interfaces.Playable;
import com.tepe.tradingcards.util.IOUtil;

public class Card implements Playable {
    private int id;
    private int manaCost;
    private int damage;
    private String name;
    private MoveType moveType;

    private Card(){}

    public Card(int id, String name, int manaCost, int damage, MoveType moveType) {
        this.id = id;
        this.name = name;
        this.manaCost = manaCost;
        this.damage = damage;
        this.moveType = moveType;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
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

    @Override
    public void print() {
        IOUtil.print("ID: " + id + " Name: " + this.name + " Mana Cost: " + this.manaCost + ", Damage: " + this.damage);
    }

    @Override
    public boolean equals(Object o) {
        return this.id == ((Card) o).getId();
    }
}
