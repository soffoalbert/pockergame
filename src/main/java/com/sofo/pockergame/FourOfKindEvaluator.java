package com.sofo.pockergame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FourOfKindEvaluator extends AbstractHandEvaluator{

    @Override
    protected void evaluate(Hand hand) {
        boolean firstRequirementMet = false;
        boolean secondRequirementMet = false;

        List<String> ranks = new ArrayList<String>();
        for (Card card : hand.getCards()) {
            ranks.add(card.getRank());
        }
        for (int i = 0; i < ranks.size(); i++ ) {
            if (!firstRequirementMet && Collections.frequency(ranks, ranks.get(i)) == 4 ) {
                firstRequirementMet = true;
            }

            if (!firstRequirementMet && Collections.frequency(ranks, ranks.get(i)) == 1) {
                secondRequirementMet = true;
            }
        }

        if (firstRequirementMet && secondRequirementMet) {
            System.out.println("Category: Four of a kind");
        }
    }
}
