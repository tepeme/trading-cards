package com.tepe.trendyol.model;

import com.tepe.trendyol.config.Properties;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class Deck {
    private List<Card> cards;

    private Deck(){}

    public Deck(List<Card> cards) {
        this.cards = cards;
    }

    public List<Card> getCards() {
        return this.cards;
    }
}
