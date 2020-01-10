package com.tepe.trendyol.util;

import com.github.javafaker.Faker;
import com.tepe.trendyol.config.Properties;
import com.tepe.trendyol.model.Card;
import com.tepe.trendyol.model.MoveType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;

@Component
public class TradingCardsUtil {

    @Autowired
    private Properties properties;

    private static Set<String> allCardNames;
    private static Map<Integer, List<Card>> allCards;

    /**
     * Initializes every Card in game. This can be replaced with a method retrieving Cards from a DB etc.
     */
    @PostConstruct private void initAllCards() {

        allCards = new HashMap<>();

        for (int manaCost = 0; manaCost <= properties.getPlayerMaxMana(); manaCost++) {
            for (int j = 0; j < 5; j++) {

                String name = getUniqueName();

                Card card = new Card(getUniqueName(), manaCost, manaCost, getRandomMove());

                if (Objects.isNull(allCardNames)) {
                    allCardNames = new HashSet<>();
                }
                if (Objects.isNull(allCards.get(manaCost))) {
                    allCards.put(manaCost, new ArrayList<>());
                }

                allCardNames.add(card.getCardName());
                allCards.get(manaCost).add(card);
            }
        }
    }

    /**
     * Find a name that has not been given to any Card
     * @return
     */
    public static String getUniqueName() {
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
        if (Objects.isNull(allCards)) {
            return new ArrayList<>();
        } else {
            return allCards.get(manaCost);
        }
    }

    /**
     * Returns a random move
     * @return
     */
    private MoveType getRandomMove() {
        Random random = new Random();
        List<MoveType> everyMove = Arrays.asList(MoveType.values());
        return everyMove.get(random.nextInt(everyMove.size()));
    }
}
