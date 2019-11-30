package com.sofo.pockergame;

import java.util.List;
import java.util.Map;

public class Hand {
    private List<Card> cards;

    public Hand(List<Card> cards) {
        this.cards = cards;
    }

    public  List<Card> getCards() {
        return cards;
    }
}
