package com.Blackjack;

public class Card {

    private CardFace face;
    private CardSuit suit;


    Card(CardSuit suit, CardFace face) {
        this.suit = suit;
        this.face = face;
    }

    private CardFace getFace() {
        return face;
    }

    private CardSuit getSuit(){
        return suit;
    }

    public int getCardValue(){
        return face.getValueOfCardFace(face);
    }

    @Override
    public String toString(){
        return "|"+getFace().getFaceSymbol()+" "+getSuit().getSymbolCode()+"|";
    }

}







