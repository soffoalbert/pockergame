package com.sofo.pockergame;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PockerGameTest {

    @Test
    public void testFiveOfKind() {
        List<Card> fiveOfKindCards = new ArrayList<Card>();
        Card card1 = new Card("Hearts", "1");
        Card card2 = new Card("Hearts", "1");
        Card card3 = new Card("Hearts", "1");
        Card card4 = new Card("Hearts", "1");
        Card card5 = new Card("Hearts", "1");
        fiveOfKindCards.add(card1);
        fiveOfKindCards.add(card2);
        fiveOfKindCards.add(card3);
        fiveOfKindCards.add(card4);
        fiveOfKindCards.add(card5);
        Hand hand = new Hand(fiveOfKindCards);
        AbstractHandEvaluator abstractHandEvaluator = getChainOfEvaluators();
        abstractHandEvaluator.reevaluate(hand);
    }

    @Test
    public void testFourOfKind() {
        List<Card> fourOfKindCards = new ArrayList<Card>();
        Card card1 = new Card("Hearts", "3");
        Card card2 = new Card("Hearts", "1");
        Card card3 = new Card("Hearts", "1");
        Card card4 = new Card("Hearts", "1");
        Card card5 = new Card("Hearts", "1");
        fourOfKindCards.add(card1);
        fourOfKindCards.add(card2);
        fourOfKindCards.add(card3);
        fourOfKindCards.add(card4);
        fourOfKindCards.add(card5);
        Hand hand = new Hand(fourOfKindCards);
        AbstractHandEvaluator abstractHandEvaluator = getChainOfEvaluators();
        abstractHandEvaluator.reevaluate(hand);
    }

    @Test
    public void testFullHouse() {
        List<Card> fullHouseCards = new ArrayList<Card>();
        Card card1 = new Card("Hearts", "3");
        Card card2 = new Card("Hearts", "3");
        Card card3 = new Card("Hearts", "1");
        Card card4 = new Card("Hearts", "1");
        Card card5 = new Card("Hearts", "1");
        fullHouseCards.add(card1);
        fullHouseCards.add(card2);
        fullHouseCards.add(card3);
        fullHouseCards.add(card4);
        fullHouseCards.add(card5);
        Hand hand = new Hand(fullHouseCards);
        AbstractHandEvaluator abstractHandEvaluator = getChainOfEvaluators();
        abstractHandEvaluator.reevaluate(hand);
    }

    @Test
    public void testTwoPair() {
        List<Card> twoPairCards = new ArrayList<Card>();
        Card card1 = new Card("Hearts", "3");
        Card card2 = new Card("Hearts", "3");
        Card card3 = new Card("Hearts", "2");
        Card card4 = new Card("Hearts", "2");
        Card card5 = new Card("Hearts", "9");
        twoPairCards.add(card1);
        twoPairCards.add(card2);
        twoPairCards.add(card3);
        twoPairCards.add(card4);
        twoPairCards.add(card5);
        Hand hand = new Hand(twoPairCards);
        AbstractHandEvaluator abstractHandEvaluator = getChainOfEvaluators();
        abstractHandEvaluator.reevaluate(hand);
    }

    @Test
    public void testHighCard() {
        List<Card> highCards = new ArrayList<Card>();
        Card card1 = new Card("Hearts", "6");
        Card card2 = new Card("Hearts", "7");
        Card card3 = new Card("Hearts", "4");
        Card card4 = new Card("Hearts", "2");
        Card card5 = new Card("Hearts", "9");
        highCards.add(card1);
        highCards.add(card2);
        highCards.add(card3);
        highCards.add(card4);
        highCards.add(card5);
        Hand hand = new Hand(highCards);
        AbstractHandEvaluator abstractHandEvaluator = getChainOfEvaluators();
        abstractHandEvaluator.reevaluate(hand);
    }

    @Test
    public void testOnePair() {
        List<Card> onePair = new ArrayList<Card>();
        Card card1 = new Card("Hearts", "8");
        Card card2 = new Card("Hearts", "8");
        Card card3 = new Card("Hearts", "2");
        Card card4 = new Card("Hearts", "1");
        Card card5 = new Card("Hearts", "3");
        onePair.add(card1);
        onePair.add(card2);
        onePair.add(card3);
        onePair.add(card4);
        onePair.add(card5);
        Hand hand = new Hand(onePair);
        AbstractHandEvaluator abstractHandEvaluator = getChainOfEvaluators();
        abstractHandEvaluator.reevaluate(hand);
    }

    @Test
    public void testThreeOfKind() {
        List<Card> fiveOfKindCards = new ArrayList<Card>();
        Card card1 = new Card("Hearts", "8");
        Card card2 = new Card("Hearts", "8");
        Card card3 = new Card("Hearts", "8");
        Card card4 = new Card("Hearts", "1");
        Card card5 = new Card("Hearts", "2");
        fiveOfKindCards.add(card1);
        fiveOfKindCards.add(card2);
        fiveOfKindCards.add(card3);
        fiveOfKindCards.add(card4);
        fiveOfKindCards.add(card5);
        Hand hand = new Hand(fiveOfKindCards);
        AbstractHandEvaluator abstractHandEvaluator = getChainOfEvaluators();
        abstractHandEvaluator.reevaluate(hand);
    }
    AbstractHandEvaluator getChainOfEvaluators() {
        AbstractHandEvaluator  fiveOfKindEavaluator = new FiveOfKindEavaluator();
        AbstractHandEvaluator  fourOfKindEvaluator = new FourOfKindEvaluator();
        AbstractHandEvaluator  fullHouseEvaluator = new FullHouseEvaluator();
        AbstractHandEvaluator  highCardEvaluator = new HighCardEvaluator();
        AbstractHandEvaluator  onePairEvaluator = new OnePairEvaluator();
        AbstractHandEvaluator  twoPairEvaluator = new TwoPairEvaluator();
        AbstractHandEvaluator  threeOfKindEvaluator = new ThreeOfKindEvaluator();

        fiveOfKindEavaluator.setNextHandEvaluator(fourOfKindEvaluator);
        fourOfKindEvaluator.setNextHandEvaluator(highCardEvaluator);
        highCardEvaluator.setNextHandEvaluator(onePairEvaluator);
        onePairEvaluator.setNextHandEvaluator(twoPairEvaluator);
        twoPairEvaluator.setNextHandEvaluator(threeOfKindEvaluator);
        threeOfKindEvaluator.setNextHandEvaluator(fullHouseEvaluator);

        return fiveOfKindEavaluator;
    }
}
