package com.tepe.tradingcards.model;

import com.tepe.tradingcards.config.BaseTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CardTest extends BaseTest {

    @Test
    public void testCard() {
        String cardName = "Pikachu";
        Card card = new Card(1, cardName, 5,5, MoveType.DAMAGE);
        assertEquals(1, card.getId());
        assertEquals(cardName, card.getName());
        assertEquals(5, card.getDamage());
        assertEquals(5, card.getManaCost());
        assertEquals(MoveType.DAMAGE, card.getMoveType());
        assertEquals("ID: 1, Name: Pikachu, Mana Cost: 5, Damage: 5, MoveType: " + MoveType.DAMAGE.toString(), card.toString());
        card.print();
        Card card2 = new Card(1, cardName, 5,5, MoveType.DAMAGE);
        assertTrue(card.equals(card2));
    }
}
