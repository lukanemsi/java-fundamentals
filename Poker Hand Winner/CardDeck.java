package com.company;


import java.util.Comparator;
import java.util.Locale;
import java.util.Objects;

public class CardDeck
{
    private int cardNumber;
    private String cardSign;
    private final static String[] validSigns = {"HEARTS","DIAMONDS","CLUBS","SPADES"};

    public CardDeck(int cardNumber,String cardSign)
    {
        setCardNumber(cardNumber);
        setCardSign(cardSign);
    }

    private void setCardNumber(int cardNumber)
    {
        if(cardNumber < 1 || cardNumber > 14)
            throw new IllegalArgumentException("Card number between 1-14");
        this.cardNumber = cardNumber;
    }
    private void setCardSign(String cardSign)
    {
        boolean isValid = false;
        for (int i = 0; i < validSigns.length; i++) {
            if (cardSign.toUpperCase(Locale.ROOT).equals(validSigns[i])) {
                isValid = true;
                break;
            }
        }
        if(!isValid)
            throw new IllegalArgumentException("Illegal card Sign");
        this.cardSign = cardSign.toUpperCase(Locale.ROOT);

    }
    public int getCardNumber(){return cardNumber;}
    public String getCardSign(){return cardSign;}
    public static String[] getValidSigns(){return  validSigns;}

    @Override
    public String toString() {
        return "Card { " +
                 cardNumber + " : " +
                 cardSign + " }";

    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardDeck cardDeck = (CardDeck) o;
        return cardNumber == cardDeck.cardNumber && Objects.equals(cardSign, cardDeck.cardSign);
    }
    @Override
    public int hashCode() {
        return Objects.hash(cardNumber, cardSign);
    }
}
