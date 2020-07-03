import java.util.Random;

public class Deck {
    Card two = new Card();
    protected Card [] finalDeck = new Card[two.suits.length * two.kinds.length];
    protected Card [] copyDeck = new Card[finalDeck.length];
    private int drawCount = 1;

    //Makes the deck
    public void deckMaker() {
        int count = 0;
        for(int i=0; i<two.suits.length; i++) {
            for(int j=0; j<two.kinds.length; j++) {
                Card c = new Card(two.suits[i], two.kinds[j]);
                two.suits[i] = c.suit;
                two.kinds[j] = c.kind;
                finalDeck[count] = c;
                //System.out.println(finalDeck[count].kind + " of " + finalDeck[count].suit);            //TEST TO DISPLAY FULL DECK
                count++;
            }
        }
    }

    //Copies the deck so we can have a finalDeck
    public void copyDeck() {
        for(int i=0; i<finalDeck.length; i++) {
            copyDeck[i] = finalDeck[i];
        }
    }
    
    //Shuffle the deck, 100 cards are switched
    public void shuffle() {
        int place1;
        int place2;
        Card temp;
        for(int i=0; i<100; i++) {
            Random shuffle = new Random();
            place1 = shuffle.nextInt(finalDeck.length);
            place2 = shuffle.nextInt(finalDeck.length);
            if(place1 == place2) {      //This makes sure that the positions are not the same
                if(place1 == 0) {
                    place2++;
                }
                if(place1 == 51) {
                    place2--;
                }
            }
            temp = copyDeck[place1];
            copyDeck[place1] = copyDeck[place2];
            copyDeck[place2] = temp;
        }
        /*
        for(int i=0; i<copyDeck.length; i++) {      //TEST FOR SHUFFLE COPYDECK
            System.out.println(copyDeck[i].kind + " of " + copyDeck[i].suit);
        }
        */
    }    

    //Draws two card
    public Card draw() {
        two = copyDeck[copyDeck.length - drawCount];
        copyDeck[copyDeck.length - drawCount] = null;
        new Card(two.suit, two.kind);
        //System.out.println(c.kind + " of " + c.suit);     //TEST TO DISPLAY FIRST DRAWN CARD OF THE COPYDECK
        drawCount++;
        return two;
    }
}