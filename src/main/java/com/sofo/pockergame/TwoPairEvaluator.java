package com.sofo.pockergame;

import java.util.*;

public class TwoPairEvaluator extends AbstractHandEvaluator {
    @Override
    protected void evaluate(Hand hand) {
        int foundtWO = 0;
        int foundOnes = 0;
        Map<String, Integer> occurences = new HashMap<String, Integer>();
        List<String> ranks = new ArrayList<String>();
        for (Card card : hand.getCards()) {
            ranks.add(card.getRank());
        }
        for (int i = 0; i < ranks.size(); i++ ) {
            occurences.put(ranks.get(i), Collections.frequency(ranks, ranks.get(i)));
        }

        for (Map.Entry<String, Integer> ranks2 : occurences.entrySet()) {
            if (ranks2.getValue() == 2) {
                foundtWO++;
            }
            if (ranks2.getValue() == 1) {
                foundOnes++;
            }
        }

        if (foundtWO == 2 && foundOnes ==1) {
            System.out.println("Category: Two pair");
        }
    }
}
