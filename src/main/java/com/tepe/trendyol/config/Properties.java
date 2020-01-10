package com.tepe.trendyol.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component public class Properties {

    @Value("${maxDeckSize}") private int maxDeckSize;
    @Value("${player.maxHealth}") private int playerMaxHealth;
    @Value("${player.maxMana}") private int playerMaxMana;
    @Value("${defaultManaCosts}") private String defaultManaCosts;
    @Value("${player.initMana}") private int playerInitMana;
    @Value("${player.count}") private int playerCount;
    @Value("${player.initCards}") private int playerInitCards;
    @Value("${player.maxHandSize}") private int playerMaxHandSize;

    public int getMaxDeckSize() {
        return maxDeckSize;
    }

    public int getPlayerMaxHealth() {
        return playerMaxHealth;
    }

    public int getPlayerMaxMana() {
        return playerMaxMana;
    }

    public String getDefaultManaCosts() {
        return defaultManaCosts;
    }

    public int getPlayerInitMana() {
        return playerInitMana;
    }

    public int getPlayerCount() {
        return playerCount;
    }

    public int getPlayerInitCards() {
        return playerInitCards;
    }

    public int getPlayerMaxHandSize() {
        return playerMaxHandSize;
    }
}
