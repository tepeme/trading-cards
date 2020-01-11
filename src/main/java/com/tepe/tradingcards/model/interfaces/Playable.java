package com.tepe.tradingcards.model.interfaces;

import com.tepe.tradingcards.model.Player;

import java.util.List;

public interface Playable {
    void print();

    int getId();

    String getName();

    int getManaCost();

    void makeMove(List<Player> players);
}
