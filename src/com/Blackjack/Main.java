package com.Blackjack;

import java.util.Scanner;
import java.lang.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println();
        System.out.println("Welcome to...");
        System.out.println(" _______  _______  _______  __   __  __  _______");
        System.out.println("|       ||       ||   _   ||  \\ |  ||  ||       |");
        System.out.println("|     __||    ___||  |_|  ||   \\|  | \\_||     __|");
        System.out.println("|    |__ |   |__  |       ||       |    |    |__ ");
        System.out.println("|__     ||    __| |       ||       |    |__     | ");
        System.out.println(" __|    ||   |___ |   _   ||  |\\   |     __|    |");
        System.out.println("|_______||_______||__| |__||__| \\__|    |_______|");
        System.out.println(" _______  ___      _______  _______  ___   _      ___  _______  _______  ___   _  __ ");
        System.out.println("|  _    ||   |    |   _   ||       ||   | | |    |   ||   _   ||       ||   | | ||  |");
        System.out.println("| |_|   ||   |    |  |_|  ||       ||   |_| |    |   ||  |_|  ||       ||   |_| ||  |");
        System.out.println("|       ||   |    |       ||      _||      _|    |   ||       ||      _||      _||  |");
        System.out.println("|  _   | |   |___ |       ||     |  |     |_  ___|   ||       ||     |  |     |_ |__|");
        System.out.println("| |_|   ||       ||   _   ||     |_ |    _  ||       ||   _   ||     |_ |    _  | __ ");
        System.out.println("|_______||_______||__| |__||_______||___| |_||_______||__| |__||_______||___| |_||__|");

        Player player = new Player();
        Dealer dealer = new Dealer(player);

        System.out.println("Welcome to my Blackjack game!");
        System.out.print("What is your name?: ");
        player.playerName = sc.next();
        System.out.println("Welcome to my game "+ player.playerName+".");
        System.out.println("I have gone ahead and given you 1000 credits to bet with,");
        System.out.println("Let's begin!");
        System.out.println(player.getPlayerBank());
        dealer.startGame();

//  --------------------------------------------------------------------------------------------------------------------

//      Deck Tester
//        Deck deck = new Deck();
//        for (Card card : deck.getCards()) {
//            System.out.println(card);
//        }
//        System.out.println(deck.getNumberOfCards()+" cards");

//      Shoe Tester
//        Shoe shoe = new Shoe();
//        System.out.println(shoe);
//        shoe.shoeShuffle();
//        System.out.println(shoe);
//        System.out.println(shoe.getNumberOfDecks()+ " decks");
//        System.out.println(shoe.getNumberOfCards()+ " cards");
//        System.out.println(shoe.dealNextCard());
//        System.out.println(shoe.dealNextCard());

//      Hand Tester
//        Hand hand  = new Hand();
//        Hand hand1 = new Hand();
//        Hand hand2 = new Hand();
//        Hand hand3 = new Hand();
//
//        Card ace   = new Card(CardSuit.HEARTS, CardFace.ACE);
//        Card king  = new Card(CardSuit.DIAMONDS, CardFace.KING);
//        Card eight = new Card(CardSuit.SPADES, CardFace.EIGHT);
//        Card ten   = new Card(CardSuit.CLUBS, CardFace.TEN);
//        Card two   = new Card(CardSuit.HEARTS, CardFace.TWO);
//        Card three = new Card(CardSuit.DIAMONDS, CardFace.THREE);
//
//        hand.addCard(ace);
//        hand.addCard(king);
//
//        hand1.addCard(eight);
//        hand1.addCard(ten);
//        hand1.addCard(three);
//
//        hand2.addCard(two);
//        hand2.addCard(two);
//        hand2.addCard(two);
//        hand2.addCard(two);
//        hand2.addCard(three);
//        hand2.addCard(three);
//        hand2.addCard(three);
//
//        hand3.addCard(king);
//        hand3.addCard(ten);
//        hand3.addCard(eight);
//
//        System.out.println(hand.getSizeOfHand());
//        System.out.println(hand.getValueOfHand());
//        System.out.println(hand);
//        System.out.println("Do you have blackjack?: "  + hand.handIsBlackJack());
//        System.out.println("Do you have twenty one?: " + hand.handIsTwentyOne());
//        System.out.println("Do you have charlie?: "    + hand.handIsCharlie());
//        System.out.println("Did you bust?: "           + hand.handIsBust());

//        Player Tester
//        Player player = new Player();
//        System.out.print("Name?: ");
//        player.playerName = sc.next();
//        System.out.print("Would you like to see your name? (Y/N): ");
//        if (sc.next().equals("Y"))
//            System.out.println(player.getPlayerName());
//        else if (sc.next().equals("N"))
//            System.out.println("Ok, let's play!");
//        else
//            System.out.println("I'm sorry I don't recognize that response.");
//        player.hit(shoe.dealNextCard());
//        player.hit(shoe.dealNextCard());
//        System.out.println(player.getHand());
//        player.playerAction();
//        player.hit(shoe.dealNextCard());
//        System.out.println(player.getHand());

//        Game Tester
//        Player player = new Player();
//        Dealer dealer = new Dealer(player);
//
//
//
//        player.playerName = "Tester";
//
//        Card ace   = new Card(CardSuit.HEARTS, CardFace.ACE);
//        Card king  = new Card(CardSuit.HEARTS, CardFace.KING);
//        Card queen = new Card(CardSuit.HEARTS, CardFace.QUEEN);
//        Card jack  = new Card(CardSuit.HEARTS, CardFace.JACK);
//        Card ten   = new Card(CardSuit.HEARTS, CardFace.TEN);
//        Card nine  = new Card(CardSuit.HEARTS, CardFace.NINE);
//        Card eight = new Card(CardSuit.HEARTS, CardFace.EIGHT);
//        Card seven = new Card(CardSuit.HEARTS, CardFace.SEVEN);
//        Card six   = new Card(CardSuit.HEARTS, CardFace.SIX);
//        Card five  = new Card(CardSuit.HEARTS, CardFace.FIVE);
//        Card four  = new Card(CardSuit.HEARTS, CardFace.FOUR);
//        Card three = new Card(CardSuit.HEARTS, CardFace.THREE);
//        Card two   = new Card(CardSuit.HEARTS, CardFace.TWO);
//
//        player.getHand().addCard(ace);
//        player.getHand().addCard(king);
//        dealer.getDealPlayerHand().addCard(ace);
//        dealer.getDealPlayerHand().addCard(king);
//
//        dealer.gameCycle();







    }
}
