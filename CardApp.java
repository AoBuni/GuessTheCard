public class CardApp {
    public static void main(String [] args) {
        Deck deck = new Deck();
        Card one = new Card();
        Card onePointTwo = new Card();

        deck.deckMaker();                                   //Makes the deck
        deck.copyDeck();                                    //Creates copy of deck
        deck.shuffle();                                     //Shuffle copy deck

        one = deck.draw();                                  //Draws one card
        System.out.println(one.toString());                 //Tries to check card when facedown
        one.flip();                                         //Flips the card face up
        System.out.println(one.toString());                 //Displays the card
        one.flip();                                         //Flips it back again
        System.out.println(one.toString());                 //Test to see if the you can see the card when it's facedown

        onePointTwo = deck.draw();                          //Draws another card
        System.out.println(onePointTwo.toString());         //Tries to check card when facedown
        onePointTwo.flip();                                 //Flips the card face up
        System.out.println(onePointTwo.toString());         //Displays the card

        System.out.println(one.sameKind(onePointTwo));      //Compares kind
        System.out.println(one.sameSuit(onePointTwo));      //Compares suit
        System.out.println(one.compare(onePointTwo));       //Compares the cards, are they the same

        Card a = new Card("Hearts", "2");
        Card b = new Card("Hearts", "2");
        System.out.println(a.compare(b));                   //This should return true
    }
}