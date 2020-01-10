package com.tepe.trendyol.model;

import com.tepe.trendyol.config.Properties;
import com.tepe.trendyol.bo.PlayerBO;
import com.tepe.trendyol.exception.TradingCardsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class Game {

    @Autowired
    private Properties properties;

    @Autowired
    private PlayerBO playerBO;

    private List<Player> players;

    @PostConstruct
    private void initializeGame() throws TradingCardsException {
        players = new ArrayList<>();
        for (int i = 0; i < properties.getPlayerCount(); i++) {
            players.add(playerBO.createPlayer());
        }
    }

    public void playGame() {

    }
}
