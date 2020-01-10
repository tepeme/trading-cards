package com.tepe.trendyol.model;

import com.tepe.trendyol.config.Properties;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Deck {
    private List<Card> cards;

    private Deck(){}

    public Deck(List<Card> cards) {
        this.cards = cards;
    }

    public List<Card> getCards() {
        return this.cards;
    }

    public int getSize() {
        if (Objects.isNull(this.cards)) {
            return 0;
        }
        return this.cards.size();
    }

    public boolean isEmpty() {
        return Objects.isNull(this.cards) || this.cards.isEmpty();
    }
}
