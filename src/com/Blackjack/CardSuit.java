package com.Blackjack;

public enum CardSuit {
    HEARTS    (9829),
    DIAMONDS  (9830),
    SPADES    (9824),
    CLUBS     (9827);

    private final int symbolCode;
    CardSuit(int symbolCode){
        this.symbolCode = symbolCode;
    }

    public String getSymbolCode(){
        return Character.toString((char)symbolCode);
    }


}
