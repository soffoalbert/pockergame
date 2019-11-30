package com.sofo.pockergame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FullHouseEvaluator extends AbstractHandEvaluator {
    @Override
    protected void evaluate(Hand hand) {
        boolean firstRequirementMet = false;
        boolean secondRequirementMet = false;
        List<String> ranks = new ArrayList<String>();
        for (Card card : hand.getCards()) {
            ranks.add(card.getRank());
        }
        for (int i = 0; i < ranks.size(); i++ ) {
            if (!firstRequirementMet && Collections.frequency(ranks, ranks.get(i)) == 3 ) {
                firstRequirementMet = true;
            }

            if (!secondRequirementMet && Collections.frequency(ranks, ranks.get(i)) == 2) {
                secondRequirementMet = true;
            }
        }
        if (secondRequirementMet && firstRequirementMet) {
            System.out.println("Category: Full House");
        }
    }
}
