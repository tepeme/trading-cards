package com.tepe.tradingcards.config;


import com.tepe.tradingcards.bo.CardBO;
import com.tepe.tradingcards.bo.DeckBO;
import com.tepe.tradingcards.bo.PlayerBO;
import com.tepe.tradingcards.model.Game;
import com.tepe.tradingcards.util.TradingCardsUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@ContextConfiguration(classes = {Game.class, PlayerBO.class, DeckBO.class, CardBO.class,
        TradingCardsUtil.class, Properties.class})
public class BaseTest {
    @Test
    public void test() {
    }
}
