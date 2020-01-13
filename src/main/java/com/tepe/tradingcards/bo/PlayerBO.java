package com.tepe.tradingcards.bo;

import com.tepe.tradingcards.config.Properties;
import com.tepe.tradingcards.exception.TradingCardsException;
import com.tepe.tradingcards.model.Deck;
import com.tepe.tradingcards.model.Game;
import com.tepe.tradingcards.model.MoveType;
import com.tepe.tradingcards.model.Player;
import com.tepe.tradingcards.model.interfaces.Playable;
import com.tepe.tradingcards.util.IOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

@Component public class PlayerBO {

    @Autowired private Properties properties;

    @Autowired private DeckBO deckBO;

    @Autowired private Game game;

    /**
     * Initializes a player by system properties.
     * @return Player
     */
    public Player createPlayer(int id) throws TradingCardsException {
        Player player;
        Deck deck = deckBO.createDeck();
        Deck hand = new Deck(new ArrayList<>());
        player = new Player(id, properties.getPlayerMaxHealth(), properties.getPlayerInitMana(),
                properties.getPlayerInitMana(), deck, hand);
        Player.setMaxHandSize(properties.getPlayerMaxHandSize());
        Player.setMaxMana(properties.getPlayerMaxMana());

        return player;
    }

    public void play(Player player) {
        IOUtil.getInstance().print("Player #" + (player.getId() + 1) + " your turn:");
        player.prepareForTurn(properties.getPlayerInitCards());
        IOUtil.getInstance().print("Here are the cards in your hand:");
        player.getHand().print();
        IOUtil.getInstance().printBreak();

        Playable playable = null;
        boolean isSkip = false;
        while(player.canPlayPlayable() && !isSkip) {
            if (!Objects.isNull(playable)) {
                IOUtil.getInstance().print("Player #" + (player.getId() + 1) + " your turn:");
                IOUtil.getInstance().print("Here are the cards in your hand:");
                player.getHand().print();
                IOUtil.getInstance().printBreak();
            }

            playable = askNextPlayable(player);

            if (Objects.isNull(playable)) {
                isSkip = true;
            } else {
                playable.makeMove(game.getPlayers().stream().filter(p -> !p.equals(player)).collect(Collectors.toList()));
                player.getHand().discard(playable);
                player.reduceMana(playable.getManaCost());
            }
        }

    }

    private Playable askNextPlayable(Player player) {
        IOUtil.getInstance().print("You have " + player.getActiveMana() + " Mana to use!");
        String userInput = IOUtil.getInstance().askPlayableIdOrName();

        Playable playable = null;
        boolean askAgain = true;
        while (Objects.isNull(playable) && askAgain) {
            int playableId;
            String playableName;
            try {
                playableId = Integer.parseInt(userInput);
                playable = player.getHand().findById(playableId);
            } catch (NumberFormatException nfe) {
                playableName = userInput;
                playable = player.getHand().findByName(playableName);
            }

            if (!Objects.isNull(playable) && player.getActiveMana() < playable.getManaCost()){
                askAgain = true;
                playable = null;
                IOUtil.getInstance().print("Not Enough Mana!");
            } else {
                askAgain = false;
            }

            if (askAgain) {
                IOUtil.getInstance().print("You have " + player.getActiveMana() + " Mana to use!");
                userInput = IOUtil.getInstance().askPlayableIdOrName();
            }
        }

        return playable;
    }

}
