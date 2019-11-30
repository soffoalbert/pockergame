package com.sofo.pockergame;

import java.util.List;

public abstract class AbstractHandEvaluator {

    private AbstractHandEvaluator nextEvaluator;

    public void setNextHandEvaluator(AbstractHandEvaluator abstractHandEvaluator) {
        this.nextEvaluator = abstractHandEvaluator;
    }

    public void reevaluate(Hand hand) {
        evaluate(hand);
        if (nextEvaluator != null) {
            nextEvaluator.reevaluate(hand);
        } else {
            System.out.println("The end of the chain has been reached.");
        }
    }

    abstract protected void evaluate(Hand hand);
}
