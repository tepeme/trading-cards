package com.tepe.tradingcards.model;

import com.tepe.tradingcards.model.interfaces.Playable;
import com.tepe.tradingcards.util.IOUtil;

import java.util.List;
import java.util.Objects;

public class Card implements Playable {
    private int id;
    private int manaCost;
    private int damage;
    private String name;
    private MoveType moveType;

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

    @Override
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
        IOUtil.getInstance().print(toString());
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + this.name + ", Mana Cost: " + this.manaCost + ", Damage: " + this.damage + ", MoveType: " + this.moveType.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (Objects.isNull(o)) {
            return false;
        }
        return this.id == ((Card) o).getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name);
    }

    @Override
    public void makeMove(List<Player> players) {
        if (MoveType.DAMAGE.equals(this.moveType)) {
            players.stream().forEach(player -> player.takeDamage(this.damage));
        }
    }
}
