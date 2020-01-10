package com.tepe.trendyol.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Properties {

    @Value("${maxDeckSize}") private int maxDeckSize;
    @Value("${maxPlayerHealth}") private int maxPlayerHealth;
    @Value("${maxPlayerMana}") private int maxPlayerMana;

    public int getMaxDeckSize() {
        return maxDeckSize;
    }

    public int getMaxPlayerHealth() {
        return maxPlayerHealth;
    }

    public int getMaxPlayerMana() {
        return maxPlayerMana;
    }
}
