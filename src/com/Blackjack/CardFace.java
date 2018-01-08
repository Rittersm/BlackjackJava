package com.Blackjack;

public enum CardFace {
    ACE     ("A "),
    TWO     ("2 "),
    THREE   ("3 "),
    FOUR    ("4 "),
    FIVE    ("5 "),
    SIX     ("6 "),
    SEVEN   ("7 "),
    EIGHT   ("8 "),
    NINE    ("9 "),
    TEN     ("10"),
    JACK    ("K "),
    QUEEN   ("Q "),
    KING    ("J ");

    private final String faceSymbol;
    CardFace(String faceSymbol) {
        this.faceSymbol = faceSymbol;
    }

    public String getFaceSymbol(){
        return faceSymbol;
    }

    public int getValueOfCardFace(CardFace face){
        switch(face){
            case ACE: return 11;
            case KING:
            case QUEEN:
            case JACK: return 10;
            default:
                return face.ordinal() + 1;
        }
    }
}
