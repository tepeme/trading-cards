package com.tepe.trendyol.model;

import com.tepe.trendyol.config.Properties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class PlayerTest {

    @Autowired
    private Properties properties;

    @Test
    public void testInitPlayer(){
        Player player = new Player();
        assertEquals(properties.getMaxPlayerHealth(), player.getHealth());
        assertEquals(properties.getMaxDeckSize(), player.getDeck().getSize());
        assertEquals(0, player.getActiveMana());
        assertEquals(0, player.getAllowedMana());
    }
}
