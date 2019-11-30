package com.sofo.pockergame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ThreeOfKindEvaluator extends AbstractHandEvaluator {

    @Override
    protected void evaluate(Hand hand) {
        int foundFirstCount = 0;
        int foundSecondCount = 0;

        List<String> ranks = new ArrayList<String>();
        for (Card card : hand.getCards()) {
            ranks.add(card.getRank());
        }
        for (int i = 0; i < hand.getCards().size(); i++ ) {
            if (Collections.frequency(ranks, ranks.get(i)) == 1 ) {
                foundFirstCount++;
            }

            if (Collections.frequency(ranks, ranks.get(i)) == 3) {
                foundSecondCount++;
            }
        }
        if (foundFirstCount == 2 && foundSecondCount == 3) {
            System.out.println("Category: Three of kind.");
        }
    }
}
