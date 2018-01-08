package com.Blackjack;

import java.util.ArrayList;
import java.util.List;

public class Deck {

    private List<Card> cards;

    Deck(){
        cards = new ArrayList<>();
        for (CardSuit suit : CardSuit.values()){
            for (CardFace face : CardFace.values()){
                cards.add(new Card(suit, face));
            }
        }
    }

    public List<Card> getCards(){
        return cards;
    }

    @Override
    public String toString(){
        return cards.toString();
    }

}
