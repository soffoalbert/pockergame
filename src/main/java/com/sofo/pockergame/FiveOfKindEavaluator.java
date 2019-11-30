package com.sofo.pockergame;

public class FiveOfKindEavaluator extends AbstractHandEvaluator {

    @Override
    protected void evaluate(final Hand hand) {
        boolean requirementsMet = true;
        for (int i = 0; i < hand.getCards().size(); i++ ) {
            for (int j = 0; j < hand.getCards().size(); j++ ) {
                if (!hand.getCards().get(i).getRank().equals(hand.getCards().get(j).getRank())){
                    requirementsMet = false;
                }
            }
        }
        if (requirementsMet) {
            System.out.println("Category: Five of king.");
        }
    }
}
