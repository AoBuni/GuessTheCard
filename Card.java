public class Card {
    protected final String [] suits = {"Diamonds", "Clubs", "Hearts", "Spades"};
    protected final String [] kinds = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    protected String suit;
    protected String kind;
    private boolean faceUp;
    protected Card card;
    
    public Card() {
        suit = "Spades";
        kind = "Ace";
        faceUp = false;
    }

    public Card(String newSuit, String newKind) {
        for(int i=0; i<suits.length; i++) {
            if(newSuit.equals(suits[i])) {
                suit = newSuit;
                break;
            } else {
                suit = "Joker";
            }
        }
        for(int i=0; i<kinds.length; i++) {
            if(newKind.equals(kinds[i])) {
                kind = newKind;
                break;
            } else {
                kind = "Joker";
            }
        }
    }
    
    //Accessors
    public String getSuit() {
        return suit;
    }
    public String getKind() {
        return kind;
    }

    //Flips the card
    public boolean flip() {
        if(faceUp == false) {
            return faceUp = true;
        } else {
            return faceUp = false;
        }
    }

    //Compares suit value
    public boolean sameSuit(Card that) {
        if(this.suit.equals(that.suit)) {
            return true;
        } else {
            return false;
        }
    }

    //Compares kind value
    public boolean sameKind(Card that) {
        if(this.kind.equals(that.kind)) {
            return true;
        } else {
            return false;
        }
    }

    

    //Compares if the cards are the same
    public boolean compare(Card that) {               
        int position1 = -1;
        int position2 = -1;
        Deck d = new Deck();
        d.deckMaker();
        for(int i=0; i<d.finalDeck.length; i++) {
            if(this.kind.equals(d.finalDeck[i].kind) && this.suit.equals(d.finalDeck[i].suit)) {
                position1 = i;
            }
            if(that.kind.equals(d.finalDeck[i].kind) && that.suit.equals(d.finalDeck[i].suit)) {
                position2 = i;
            }
        }
        if(position1 == position2) {
            return true;
        } else {
            return false;
        }
    }

    //HiLow
    public int hiLow(Card that, String guess) {
        int position1 = -1;
        int position2 = -1;
        for(int i=0; i<kinds.length; i++) {
            if(this.kind.equals(kinds[i])) {
                position1 = i;
            }
            if(that.kind.equals(kinds[i])) {
                position2 = i;
            }
        }
        if(guess.equals("H") || guess.equals("h")) {
            if(position1 > position2) {
                return 1;
            } else {
                return 0;
            }
        } else {
            if(guess.equals("L") || guess.equals("l")) {
                if(position1 < position2) {
                    return 1;
                } else {
                    return 0;
                }
            } else {
                if(position1 == position2) {
                    return 2;
                } else {
                    return 0;
                }
            }
        }
    }

    public String toString() {
        if(faceUp == false) {
            return "The card is face down.";
        } else {
            return kind + " of " + suit;
        }
    }
}