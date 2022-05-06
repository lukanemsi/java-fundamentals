package com.company;

import java.util.*;
import java.util.stream.Stream;

public class Poker
{
    public CardDeck[] tableCards = new CardDeck[5];
    private final int cardQuantityOnTable = 5;
    private CardDeck[] hand;
    private CardDeck[] otherHand;
    private Random random = new Random();
    private static HashMap<Integer,String> comboNames = new HashMap<>();


    public Poker(CardDeck[] hands, CardDeck[] other)
    {
        setInputCards(hands,other);
        setTableCards();
        System.out.println("Player1: ");
        System.out.println(Arrays.toString(hands));
        System.out.println("Player2: ");
        System.out.println(Arrays.toString(other));
    }




    public void handWinner()
    {
        System.out.println("Table:");
        for(CardDeck i : tableCards)
        {
            System.out.println(i);
        }
        var valueOfFirstCard = iterateOverComboes(hand);
        var valueOfSecondCard = iterateOverComboes(otherHand);
        if(valueOfFirstCard > valueOfSecondCard) {
            System.out.println("Winner is First Player: ");
            System.out.println(Arrays.toString(hand));
        }
        if(valueOfFirstCard < valueOfSecondCard) {
            System.out.println("Winner is Second Player: ");
            System.out.println(Arrays.toString(otherHand));
        }
        else
        {
            System.out.println("IT is draw!");
            System.out.println(Arrays.toString(hand));
            System.out.println(Arrays.toString(otherHand));
        }
    }

    private int iterateOverComboes(CardDeck[] cardDecks)
    {
        if(royalFlush(cardDecks)){
            comboNames.put(100,"RoyalFlush");
            return 100;
        }
        if(straightFlash(cardDecks)) {
            comboNames.put(90,"straightFlush");
            return 90;
        }
        if(fourOfAKind(cardDecks)){
            comboNames.put(80,"fourOfAKind");
            return 80;
        }
        if(fullHouse(cardDecks)) {
            comboNames.put(70,"fullHouse");
            return 70;
        }

        if(flush(cardDecks)){
            comboNames.put(60,"flush");
            return 60;
        }
        if(straight(cardDecks)){
            comboNames.put(50,"straight");
            return 50;
        }
        if(threeOfAKind(cardDecks)){
            comboNames.put(40,"threeOfAKind");
            return 40;
        }
        if(twoPair(cardDecks)){
            comboNames.put(30,"twoPair");
            return 30;
        }
        if(onePair(cardDecks)){
            comboNames.put(10,"onePair");
            return 10;
        }
        comboNames.put(0,"Draw");
        return 0;
    }
    private CardDeck[] concatHandWithTable(CardDeck[] cardDecks)
    {
        Stream<CardDeck> streamA = Arrays.stream(cardDecks);
        Stream<CardDeck> streamB = Arrays.stream(tableCards);
        var allCards =  Stream.concat(streamA,streamB).toArray(CardDeck[]::new);
        return allCards;
    }
    private boolean checkForDifferent(CardDeck tableCard)
    {
        for(CardDeck deck : hand)
        {
            if(deck.equals(tableCard))
                return false;
        }
        for (CardDeck deck : otherHand)
        {
            if(deck.equals(tableCard))
                return false;
        }
        int  i = 0;
        while(tableCards[i] != null)
        {
            if(tableCards[i].equals(tableCard))
                return false;
            i++;
        }
        return true;
    }

    private boolean onePair(CardDeck[] cardDecks)
    {
        if(cardDecks[0].getCardNumber() == cardDecks[1].getCardNumber())
            return true;
        for(CardDeck card : tableCards)
        {
            if(card.getCardNumber() == cardDecks[0].getCardNumber() || card.getCardNumber() == cardDecks[1].getCardNumber())
                return true;
        }
        return false;
    }
    private boolean twoPair(CardDeck[] cardDecks)
    {
        var allCards = concatHandWithTable(cardDecks);
        for(CardDeck card : allCards)
        {
            int number = card.getCardNumber();
            var count = Arrays.stream(allCards).filter(k -> k.getCardNumber() == number).count();
            if(count == 2)
                return true;
        }

        return false;
    }
    private boolean threeOfAKind(CardDeck[] cardDecks)
    {
        var allCards = concatHandWithTable(cardDecks);
        for(CardDeck card : allCards)
        {
            int number = card.getCardNumber();
            var count = Arrays.stream(allCards).filter(k -> k.getCardNumber() == number).count();
            if(count == 3)
                return true;
        }
        return false;
    }
    private boolean straight(CardDeck[] cardDecks)
    {
        var allCards = concatHandWithTable(cardDecks);
        int[] cardNumbers = new int[allCards.length];
        for (int i = 0; i < allCards.length; i++)
            cardNumbers[i] = allCards[i].getCardNumber();

        Arrays.sort(cardNumbers);


        return isStraight(cardNumbers);
    }
    private  boolean isStraight(int[] array)
    {
        if(array.length < 5)
            return false;
        int counter = 1;
        int element = array[0];
        for (int i = 1; i < array.length; i++)
        {
            if(element + 1 == array[i])
            {
                element = array[i];
                counter++;
            }
            if(counter == 5)
                return true;
        }
        int[] tailOfArray = new int[array.length - 1];
        for (int i = 1; i < array.length; i++)
        {
            tailOfArray[i-1] = array[i];
        }
        return isStraight(tailOfArray);
    }
    private boolean flush(CardDeck[] cardDecks)
    {
        var allCards = concatHandWithTable(cardDecks);

        for(CardDeck card : allCards)
        {
            String sign = card.getCardSign();
            var count = Arrays.stream(allCards).filter(k -> k.getCardSign().equals(sign)).count();
            if(count >= 5)
                return true;
        }
        return false;
    }
    private boolean fullHouse(CardDeck[] cardDecks)
    {
        var allCards = concatHandWithTable(cardDecks);
        boolean isThreeStacked = false;
        CardDeck[] threeOfThem = new CardDeck[3];
        //is it stacked of 3
        for(CardDeck card : allCards)
        {

            int number = card.getCardNumber();
            var count = Arrays.stream(allCards).filter(k -> k.getCardNumber() == number).count();
            if(count == 3)
            {
                threeOfThem = Arrays.stream(allCards).filter(k -> k.getCardNumber() == number).toArray(CardDeck[]::new);
                isThreeStacked = true;
                break;
            }
        }
        if(isThreeStacked)
        {
            ArrayList<CardDeck> list1 = new ArrayList<>(Arrays.asList(allCards));
            ArrayList<CardDeck> list2 = new ArrayList<>(Arrays.asList(threeOfThem));
            list1.removeAll(list2);
            var restCards = list1.toArray(CardDeck[]::new);

            //is other two pair
            for(CardDeck card : restCards)
            {
                int number = card.getCardNumber();
                var count = Arrays.stream(allCards).filter(k -> k.getCardNumber() == number).count();
                if(count == 2)
                    return true;
            }
        }
        return false;
    }
    private boolean fourOfAKind(CardDeck[] cardDecks)
    {   var allCards = concatHandWithTable(cardDecks);
        for(CardDeck card : allCards)
        {
            int number = card.getCardNumber();
            var count = Arrays.stream(allCards).filter(k -> k.getCardNumber() == number).count();
            if(count == 4)
                return true;
        }
        return false;
    }
    private boolean straightFlash(CardDeck[] cardDecks)
    {
        return flush(cardDecks) && straight(cardDecks);
    }
    private boolean royalFlush(CardDeck[] cardDecks)
    {
        return straightFlash(cardDecks) && cardDecks[0].getCardNumber() >= 10;
    }

    private void setInputCards(CardDeck[] hands,CardDeck[] other)
    {
        if(hands.length != other.length && hands.length != 2)
            throw new IllegalArgumentException("Input Card array should have length of 2 ");
        if(hands[0].equals(hands[1]) || other[0] == other[1])
            throw new IllegalArgumentException("Input Card cant be same");

        for(CardDeck card : hands)
        {
            for (CardDeck otherCard : other)
            {
                if(card.equals(otherCard))
                    throw new IllegalArgumentException("Input Card cant be same");
            }
        }
        this.hand = hands;
        this.otherHand = other;

    }
    private void setTableCards()
    {
        int number,sign;
        for (int i = 0; i < cardQuantityOnTable; i++)
        {
            number = random.nextInt(1,15);
            sign = random.nextInt(0,4);
            var tableCard = new CardDeck(number,CardDeck.getValidSigns()[sign]);
            if(!checkForDifferent(tableCard)) i--;
            else tableCards[i] = tableCard;
        }
    }
    public CardDeck[] getTableCards(){return tableCards;}

}
