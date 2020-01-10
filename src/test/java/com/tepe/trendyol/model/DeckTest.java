package com.tepe.trendyol.model;

import com.tepe.trendyol.config.Properties;
import com.tepe.trendyol.factory.PlayerFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@ContextConfiguration(classes= {Properties.class})
public class DeckTest {

    @Autowired
    private Properties properties;

    @Test
    public void testDeck(){

        List<Card> cards = new ArrayList<>();
        Random random;
        for (String defaultManaCost : properties.getDefaultManaCosts().split(",")) {
            random = new Random();
            int maxCardDamage = random.nextInt(properties.getMaxCardDamage());
            Card card = new Card(Integer.parseInt(defaultManaCost), maxCardDamage);
            cards.add(card);
        }
        Deck deck = new Deck(cards);
        assertEquals(properties.getMaxDeckSize(), deck.getCards().size());
    }
}
