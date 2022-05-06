package com.company;
import java.util.Arrays;

public class Main {
    public static void main(String[] args)
    {

        CardDeck[] player1 = {new CardDeck(10,"hearts"),new CardDeck(12,"hearts")};
        CardDeck[] player2 = {new CardDeck(9,"hearts"),new CardDeck(11,"spades")};

        Poker poker = new Poker(player1,player2);
        poker.handWinner();

    }


}