import java.util.*;

public class HiLow {
    public static void main(String [] args) {
        int cards = 6;
        int turn = 0;
        int playerAScore = 0;
        int playerBScore = 0;
        int answer = 0;
        Deck deck = new Deck();
        Card [] playerA = new Card[cards];
        Card [] playerB = new Card[cards];
        Scanner guess = new Scanner(System.in);
        String input = "";

        deck.deckMaker();                                   //Makes the deck
        deck.copyDeck();                                    //Creates copy of deck
        deck.shuffle();                                     //Shuffle copy deck

        for(int i=0; i<cards; i++) {                        //Players draws 6 cards
            playerA[i] = deck.draw();
            playerB[i] = deck.draw();
        }
        while(cards != 0) {
            if(turn == 0) {                                 //PlayerB guesses first
                playerA[cards-1].flip();
                System.out.println("PlayerA card is " + playerA[cards-1].toString());
                System.out.print("PlayerB guess H or L: ");
                input = guess.next();
                while(!(input.equals("H") || input.equals("h") || input.equals("L") || input.equals("l"))) {
                    System.out.print("PlayerB guess H or L: ");
                    input = guess.next();
                }
                playerB[cards-1].flip();
                System.out.println("PlayerB card is " + playerB[cards-1].toString());
                if(input.equals("H") || input.equals("h")) {
                    answer = playerA[cards-1].hiLow(playerB[cards-1], input);
                    if(answer != 2) {
                        if(answer == 1) {
                            System.out.println("PlayerA wins");
                            playerAScore++;
                        } else {
                            System.out.println("PlayerB wins");
                            playerBScore++;
                        }
                    } else {
                        System.out.println("Draw");
                    }
                    cards--;
                } else {
                    if(input.equals("L") || input.equals("l")) {
                        answer = playerA[cards-1].hiLow(playerB[cards-1], input);
                        if(answer == 0) {
                            System.out.println("PlayerB wins");
                            playerBScore++;
                        } else {
                            System.out.println("PlayerA wins");
                            playerAScore++;
                        }
                        cards--;
                    } else {
                        System.out.print("Enter H or L: ");
                        input = guess.next();
                    }
                }
                turn++;
            }
            System.out.println("");
            if(turn == 1) {                                 //PlayerA guesses
                playerB[cards-1].flip();
                System.out.println("PlayerB card is " + playerB[cards-1].toString());
                System.out.print("PlayerA guess H or L: ");
                input = guess.next();
                while(!(input.equals("H") || input.equals("h") || input.equals("L") || input.equals("l"))) {
                    System.out.print("PlayerA guess H or L: ");
                    input = guess.next();
                }
                playerA[cards-1].flip();
                System.out.println("PlayerA card is " + playerA[cards-1].toString());
                if(input.equals("H") || input.equals("h")) {
                    answer = playerB[cards-1].hiLow(playerA[cards-1], input);
                    if(answer != 2) {
                        if(answer == 1) {
                            System.out.println("PlayerB wins");
                            playerBScore++;
                        } else {
                            System.out.println("PlayerA wins");
                            playerAScore++;
                        }
                    } else {
                        System.out.println("Draw");
                    }
                    cards--;
                } else {
                    if(input.equals("L") || input.equals("l")) {
                        answer = playerB[cards-1].hiLow(playerA[cards-1], input);
                        if(answer == 0) {
                            System.out.println("PlayerA wins");
                            playerAScore++;
                        } else {
                            System.out.println("PlayerB wins");
                            playerBScore++;
                        }
                        cards--;
                    } else {
                        System.out.print("Enter H or L: ");
                        input = guess.next();
                    }
                }
                turn--;
            }
            System.out.println("");
        }
        System.out.println("PlayerA wins = " + playerAScore + " and PlayerB wins = " + playerBScore);
    }
}