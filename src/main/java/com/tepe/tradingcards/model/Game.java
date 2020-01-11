package com.tepe.tradingcards.model;

import com.tepe.tradingcards.config.Properties;
import com.tepe.tradingcards.bo.PlayerBO;
import com.tepe.tradingcards.exception.TradingCardsException;
import com.tepe.tradingcards.util.IOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
            players.add(playerBO.createPlayer(i));
        }
    }

    public void playGame() {
        Random random = new Random();
        int nextPlayerId = random.nextInt(players.size());
        Player currentPlayer = players.get(nextPlayerId);
        Player previousPlayer = null;
        while(!currentPlayer.equals(previousPlayer) && currentPlayer.isAlive()){
            IOUtil.getInstance().print("");
            IOUtil.getInstance().printBreak();
            playerBO.play(currentPlayer);

            nextPlayerId++;
            previousPlayer = currentPlayer;
            currentPlayer = players.get(nextPlayerId%players.size());
        }

        IOUtil.getInstance().print("Congratulations Player #" + (previousPlayer.getId() + 1));
    }

    public List<Player> getPlayers() {
        return this.players;
    }


}
