package com.tepe.trendyol.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    @Test
    public void testInitPlayer(){
        Player player = new Player();
        assertEquals(30, player.getHealth());
        assertEquals(20, player.getDeck().size());
        assertEquals(0, player.getActiveMana());
        assertEquals(0, player.getAllowedMana());
    }
}
