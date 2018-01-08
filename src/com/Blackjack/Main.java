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
    }
}
