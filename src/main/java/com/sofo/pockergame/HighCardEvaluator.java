package com.sofo.pockergame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HighCardEvaluator extends AbstractHandEvaluator {

    @Override
    protected void evaluate(Hand hand) {
        int foundCount = 0;
        List<String> ranks = new ArrayList<String>();
        for (Card card : hand.getCards()) {
            ranks.add(card.getRank());
        }
        for (int i = 0; i < hand.getCards().size(); i++ ) {
            if (Collections.frequency(ranks, ranks.get(i)) == 1 ) {
                foundCount++;
            }
        }
        if (foundCount == 5) {
            System.out.println("Category: High Card.");
        }
    }
}
