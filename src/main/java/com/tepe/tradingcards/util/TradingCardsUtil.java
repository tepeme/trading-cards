package com.tepe.tradingcards.util;

import com.github.javafaker.Faker;
import com.tepe.tradingcards.config.Properties;
import com.tepe.tradingcards.model.Card;
import com.tepe.tradingcards.model.MoveType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;

@Component
public class TradingCardsUtil {

    @Autowired
    private Properties properties;

    private Set<String> allCardNames;
    private Map<Integer, List<Card>> allCards = new HashMap<>();
    private Random random = new Random();

    /**
     * Initializes every Card in game. This can be replaced with a method retrieving Cards from a DB etc.
     */
    @PostConstruct private void initAllCards() {

        int id = 1;
        for (int manaCost = 0; manaCost <= properties.getPlayerMaxMana(); manaCost++) {
            for (int j = 0; j < 5; j++) {

                Card card = new Card(id, getUniqueName(), manaCost, manaCost, getRandomMove());
                id++;

                if (Objects.isNull(allCardNames)) {
                    allCardNames = new HashSet<>();
                }
                if (Objects.isNull(allCards.get(manaCost))) {
                    allCards.put(manaCost, new ArrayList<>());
                }

                allCardNames.add(card.getName());
                allCards.get(manaCost).add(card);
            }
        }
    }

    /**
     * Find a name that has not been given to any Card
     * @return
     */
    public String getUniqueName() {
        Faker faker = new Faker();
        String name = faker.pokemon().name();
        if (!Objects.isNull(allCardNames)) {
            while(allCardNames.contains(name)) {
                name = faker.pokemon().name();
            }
        }
        return name;
    }

    /**
     * Retrieves List of Cards with mana cost equal to {@code manaCost}
     * @param manaCost
     * @return
     */
    public List<Card> getAllCardsByManaCost(int manaCost){
        return allCards.get(manaCost);
    }

    /**
     * Returns a random move
     * @return
     */
    private MoveType getRandomMove() {
        List<MoveType> everyMove = Arrays.asList(MoveType.values());
        return everyMove.get(random.nextInt(everyMove.size()));
    }
}
