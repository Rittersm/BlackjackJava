package com.Blackjack;

import java.util.Scanner;

public class Player {

    public String playerName;
    private Hand hand;
    public double playerBank;
    public double playerBet;


    Player(){
        playerName = "";
        hand = new Hand();
        playerBank = 1000.0;
        playerBet = 0.0;
    }

    private final static int HIT = 1;
    private final static int STAY = 2;

    public int playerAction(){
        Scanner choice = new Scanner(System.in);
        System.out.print("Would you like to hit(1) or stay(2)?:");
        int action;
        try{
            action = choice.nextInt();
        }
        catch(java.util.InputMismatchException e){
            System.out.println("That is not a valid response.");
            action = playerAction();
        }
        if (action == HIT)
            return 1;
        else if (action == STAY)
            return 2;
        else
            return 3;
    }

    public void hit(Card card){
        hand.addCard(card);
    }

    public boolean hasOptionToDoubleDown(){
        if (hand.getValueOfHand() <= 11 && hand.getValueOfHand() >=9)
           return true;
        else
            return false;
    }

    public void adjustPlayerBetForDoubleDown(double betMultiplier){
        playerBet = (playerBet * betMultiplier);
    }

    public void updatePlayerBankWithBetResuts(double betMultiplier){
        playerBank += (playerBet * betMultiplier);
    }

    public Hand getHand(){
        return hand;
    }

    public double getPlayerBank(){
        return playerBank;
    }

    public boolean isNotBankrupt(){
        if(0 < getPlayerBank()){
            return true;
        }
        else{
            return false;
        }
    }

    public double getPlayerBet(){
        return playerBet;
    }

}
