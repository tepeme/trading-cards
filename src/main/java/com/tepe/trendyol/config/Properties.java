package com.tepe.trendyol.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Properties {

    @Value("${maxDeckSize}") private int maxDeckSize;
    @Value("${player.maxHealth}") private int playerMaxHealth;
    @Value("${player.maxMana}") private int playerMaxMana;
    @Value("${defaultManaCosts}") private String defaultManaCosts;
    @Value("${maxCardDamage}") private int maxCardDamage;
    @Value("${player.initMana}") private int playerInitMana;

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

    public int getMaxCardDamage() {
        return maxCardDamage;
    }

    public int getPlayerInitMana() {
        return playerInitMana;
    }
}
