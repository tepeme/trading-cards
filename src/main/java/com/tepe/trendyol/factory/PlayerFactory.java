package com.tepe.trendyol.factory;

import com.tepe.trendyol.config.Properties;
import com.tepe.trendyol.model.Card;
import com.tepe.trendyol.model.Deck;
import com.tepe.trendyol.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class PlayerFactory {

    @Autowired
    private Properties properties;

    public Player createPlayer() {
        Player player;
        List<Card> cards = new ArrayList<>();
        Random random;
        for (String defaultManaCost : properties.getDefaultManaCosts().split(",")) {
            random = new Random();
            int maxCardDamage = random.nextInt(properties.getMaxCardDamage());
            Card card = new Card(Integer.parseInt(defaultManaCost), maxCardDamage);
            cards.add(card);
        }
        Deck deck = new Deck(cards);
        player = new Player(properties.getPlayerMaxHealth(), properties.getPlayerInitMana(),
                properties.getPlayerInitMana(), deck);

        return player;
    }
}
