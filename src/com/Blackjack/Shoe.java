package com.Blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Shoe {
    private List<Deck> decks;
    private List<Card> shoeDeck;


    Shoe(){
        decks = new ArrayList<>();
        for (int i = 0; i<=6;i++){
            decks.add(new Deck());
            shoeDeck = new ArrayList<>(364);
            for (Deck deck : decks){
                shoeDeck.addAll(deck.getCards());
            }
        }
        Collections.shuffle(shoeDeck);
    }

    public Card dealNextCard(){
        Card card = shoeDeck.get(0);
        shoeDeck.remove(0);
        return card;
    }

    public int getNumberOfCards(){
        return shoeDeck.size();
    }

    @Override

    public String toString(){
       StringBuilder sb = new StringBuilder();
        for (Card aShoeDeck : this.shoeDeck) {
            sb.append(", " + aShoeDeck.toString());
        }
       return sb.toString().substring(2);

    }

}
