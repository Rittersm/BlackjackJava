package com.Blackjack;

import java.util.ArrayList;

public class Hand {

   private ArrayList<Card> hand;

   Hand(){
       hand = new ArrayList<>();
   }

   public int getValueOfHand(){
       int handValue = 0;
       if (hand.size() > 0){
         for (Card card : hand){
             handValue += card.getCardValue();
         }
       }

       return handValue;
   }

   public boolean handIsBust(){
       boolean bust;
       bust = getValueOfHand() > 21;
       return bust;
   }

   public boolean handIsBlackJack(){
       boolean blackJack;
       blackJack = getSizeOfHand() == 2 && getValueOfHand() == 21;
       return blackJack;
   }

   public boolean handIsTwentyOne(){
       boolean twentyOne;
       twentyOne = getSizeOfHand() > 2 && getValueOfHand() == 21;
       return twentyOne;
   }

   public boolean handIsCharlie(){
       boolean charlie;
       charlie = getSizeOfHand() >= 7 && getValueOfHand() < 21;
       return charlie;
   }

   private int getSizeOfHand(){
       return hand.size();
   }

   public void addCard(Card card){
       hand.add(card);
   }

   public void emptyHand(){
       hand.clear();
   }

   public Card dealerHandShowOneCard(){
       return hand.get(0);
   }

   @Override

    public String toString(){
       StringBuilder sb = new StringBuilder();
       for (Card aHand : hand) {
           sb.append(aHand.toString());
       }
       return sb.toString() + " for: " + getValueOfHand();
     //  return hand + " for " +getValueOfHand();
    }
}
