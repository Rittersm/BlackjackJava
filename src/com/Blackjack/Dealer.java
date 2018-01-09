package com.Blackjack;

import java.util.Scanner;

// This is an ugly ass class, way too many methods and the methods are way too long.
// Need to break it down further, maybe into another class and
// maybe incorporate an interface for "Dealable" to handle some of the dealer responsibilities.
// That would allow me to add more AI players without much difficulty.
// As it is now, it's rigid and not great code for the time being.

// YOU FORGOT TO ADD SHIFTING ACE VALUES AND SPLITTING!!!

public class Dealer {

    private Player player;
    private Shoe shoe;
    private Hand dealPlayerHand;
    private Scanner sc = new Scanner(System.in);
    private Scanner betSc = new Scanner(System.in);
    private Scanner doubleDownSc = new Scanner(System.in);


    Dealer(Player p) {
        shoe = new Shoe();
        dealPlayerHand = new Hand();
        player = p;
    }

    private final static int YES = 1;
    private final static int NO = 2;

    private final static int HIT = 1;
    private final static int STAY = 2;

//  ********************************************************************

    public void startGame() {
        needMoreCards();
        getOpeningBet();
    }

    private void needMoreCards(){
        if (shoe.getNumberOfCards() <= 14) {
            shoe = new Shoe();
        }
    }

    private void getOpeningBet(){
        System.out.println("Your Bank: "+player.getPlayerBank());
        System.out.print("How much would you like to bet?: ");
        player.playerBet = betSc.nextDouble();
        player.updatePlayerBankWithBetResuts(-1);
        dealNewHand();
    }

    private void dealNewHand(){
        emptyPlayerAndDealerHands();
        hit(player);
        hit(player);
        dealerHit();
        dealerHit();
        revealPlayerAndDealerCards();
    }

    private void emptyPlayerAndDealerHands(){
        player.getHand().emptyHand();
        dealPlayerHand.emptyHand();
    }

    //Dealable interface will now allow me to eliminate the dealerHit method and use this for both player and dealer.
    private void hit(Player player) {
        player.hit(shoe.dealNextCard());
    }

    private void dealerHit() {
        dealPlayerHand.addCard(shoe.dealNextCard());
    }

    private void revealPlayerAndDealerCards(){
        if (dealPlayerHand.handIsBlackJack()) {
            System.out.println("Dealer Hand: " + getDealPlayerHand());
        } else {
            System.out.println("Dealer shows: " + dealPlayerHand.dealerHandShowOneCard());
        }
        System.out.println("Your Hand: " + player.getHand());
        blackjackCheck();
    }

    private void blackjackCheck() {
        if (player.getHand().handIsBlackJack() && dealPlayerHand.handIsBlackJack()) {
            System.out.println("Dealer Hand: " + getDealPlayerHand());
            System.out.println("We both have Blackjack\nIt's a draw!");
            player.updatePlayerBankWithBetResuts(1);
            playAnotherHand();
        } else if (player.getHand().handIsBlackJack()) {
            System.out.println("Dealer Hand: " + getDealPlayerHand());
            System.out.println("Blackjack!\nYou Win " + player.playerName + "!");
            player.updatePlayerBankWithBetResuts(2.5);
            playAnotherHand();
        } else if (dealPlayerHand.handIsBlackJack()) {
            System.out.println("Dealer has Blackjack\nDealer Wins!");
            player.updatePlayerBankWithBetResuts(0);
            playAnotherHand();
        } else {
            checkIfPlayerCanDoubleDown();
        }

    }

    private void checkIfPlayerCanDoubleDown(){
        if (player.hasOptionToDoubleDown()){
            System.out.print("Would you like to double down? Y(1)/N(2): ");
            int playerChoice = doubleDownSc.nextInt();
            if (1 == playerChoice){
                player.updatePlayerBankWithBetResuts(-1);
                player.adjustPlayerBetForDoubleDown(2);
                System.out.println("Your New Bet: "+player.getPlayerBet());
                hit(player);
                System.out.println("Your Hand: " + player.getHand());
            }
        }
        gameCycle();
    }

    private void gameCycle() {
        if (!player.getHand().handIsTwentyOne()) {
            willPlayerHitOrStay();
        }
        dealerPlay();
        winOrLossChecks();
    }

    private void willPlayerHitOrStay(){
        int playerAction = player.playerAction();
        while (playerAction != STAY && !player.getHand().handIsBust()) {
            if (playerAction == HIT) {
                hit(player);
                System.out.println(player.getHand());
                bustCheck();
                gameCycle();
            }
            else{
            System.out.println("Sorry, that is not a valid response");
            }
            gameCycle();
        }
    }
    private void dealerPlay() {
        while (dealerCanPlay()) {
            dealerHit();
            dealerBustCheck();
        }
        revealFullDealerAndPlayerHands();
    }

    private boolean dealerCanPlay(){
        return (dealPlayerHand.getValueOfHand() < 17);
    }

    private void dealerBustCheck() {
        if (dealPlayerHand.handIsBust()) {
            System.out.println("Dealer Busts!\nYou Win " + player.playerName + "!");
            player.updatePlayerBankWithBetResuts(2);
            playAnotherHand();
        }
    }

    private void revealFullDealerAndPlayerHands(){
        getDealPlayerHand().getValueOfHand();
        System.out.println("Your hand:" + player.getHand());
        System.out.println("Dealer hand: " + getDealPlayerHand());
    }

    private Hand getDealPlayerHand() {
        return dealPlayerHand;
    }

    private void winOrLossChecks(){
        bustCheck();
        twentyOneCheck();
        charlieCheck();
        checkForNormalWinner();
    }

    private void bustCheck() {
        if (player.getHand().handIsBust()) {
            System.out.println("You Busted!");
            player.updatePlayerBankWithBetResuts(0);
            playAnotherHand();
        }
    }

    private void twentyOneCheck() {
        if (player.getHand().handIsTwentyOne() && dealPlayerHand.handIsTwentyOne()) {
            System.out.println("We both have 21\nIt's a draw!");
            player.updatePlayerBankWithBetResuts(1);
            playAnotherHand();
        } else if (player.getHand().handIsTwentyOne()) {
            System.out.println("21! You Win " + player.playerName + "!");
            player.updatePlayerBankWithBetResuts(2);
            playAnotherHand();
        } else if (dealPlayerHand.handIsTwentyOne()) {
            System.out.println("Dealer had 21\nDealer Wins!");
            player.updatePlayerBankWithBetResuts(0);
            playAnotherHand();
        }

    }

    private void charlieCheck() {
        if (player.getHand().handIsCharlie() && dealPlayerHand.handIsCharlie()) {
            System.out.println("We both have Seven Card Charlie\nIt's a draw!");
            player.updatePlayerBankWithBetResuts(1);
            playAnotherHand();
        } else if (player.getHand().handIsCharlie()) {
            System.out.println("Seven Card Charlie!\nYou Win " + player.playerName + "!");
            player.updatePlayerBankWithBetResuts(2);
            playAnotherHand();
        } else if (dealPlayerHand.handIsCharlie()) {
            System.out.println("Dealer has Seven Card Charlie\nDealer Wins!");
            player.updatePlayerBankWithBetResuts(0);
            playAnotherHand();
        }
    }

    private void checkForNormalWinner() {
        if (player.getHand().getValueOfHand() == dealPlayerHand.getValueOfHand() && dealPlayerHand.getValueOfHand() <= 21) {
            System.out.println("It's a draw!");
            player.updatePlayerBankWithBetResuts(1);
            playAnotherHand();
        } else if (player.getHand().getValueOfHand() > dealPlayerHand.getValueOfHand() && player.getHand().getValueOfHand() <= 21) {
            System.out.println("You Win " + player.playerName + "!");
            player.updatePlayerBankWithBetResuts(2);
            playAnotherHand();
        } else if (player.getHand().getValueOfHand() < dealPlayerHand.getValueOfHand() && dealPlayerHand.getValueOfHand() <= 21) {
            System.out.println("Dealer Wins!");
            player.updatePlayerBankWithBetResuts(0);
            playAnotherHand();
        }
    }

    private void playAnotherHand() {
        playerCanContinue();
    }

    private void playerCanContinue(){
        if (player.isNotBankrupt()) {
            requestNewHand();
        }
        else if (!player.isNotBankrupt()){
            informPlayerOfLoss();
        }
    }

    private void requestNewHand(){
        System.out.println("Would you like to play another hand? Yes(1) or No(2): ");
        int cont = sc.nextInt();
        if (cont == YES) {
            startGame();
        }
        else if (cont == NO) {
            terminateGame();
        }
        else {
            System.out.println("Please enter a valid response!");
            playAnotherHand();
        }
    }

    private void terminateGame(){
        System.out.println("Thanks for playing, " + player.playerName + "!");
        determinePlayerEarningsOrLosses();
        System.exit(0);
    }

    private void determinePlayerEarningsOrLosses(){
        System.out.println("You finished the game with: " + player.getPlayerBank() + " credits!");
        if ((playerHasWonMoney())) reportPlayerEarnings();
        else reportPlayerLosses();
    }

    private void reportPlayerEarnings(){
        System.out.println("You won " + (player.getPlayerBank() - 1000) + " credits!");
    }

    private void reportPlayerLosses(){
        System.out.println("You lost " + (1000 - player.getPlayerBank()) + " credits!");
    }

    private boolean playerHasWonMoney(){
        return player.getPlayerBank() > 1000;
    }

    private void informPlayerOfLoss(){
        System.out.println("Sorry, you ran out of money.\nBetter luck next time...");
        System.exit(0);
    }

}
