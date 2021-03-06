
package blackjack;

import java.util.HashSet;
import java.util.Set;
import constants.Constants;
import constants.Constants.Colors;
import constants.Constants.FaceValue;
import constants.Constants.Suits;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Deck {
    private Set<Card> deck;
    Colors Color;
    FaceValue Face;
    Suits Suit;
    
    public Deck(){
        generateDeck();
        System.out.println("*******************************");
        System.out.println("Displaying the deck of cards");
        System.out.println("*******************************");
        displayDeck();
        shuffleDeck();
        System.out.println("*******************************");
        System.out.println("Displaying the shuffled deck of cards");
        System.out.println("*******************************");
        displayDeck();      
    }
    
    public void generateDeck(){
        deck = new HashSet<Card>(Constants.NUM_CARDS_IN_DECK);
        
        for(Suits suit: Suits.values()){
            for(FaceValue face: FaceValue.values()){
                Card card = new Card();
                card.setSuit(suit);
                card.setFace(face);
                if(suit.equals(Suits.CLUBS)|| suit.equals(Suits.SPADES)){
                    card.setColor(Colors.BLACK);
                }
                else{
                    card.setColor(Colors.RED);
                }
                if(!deck.contains(card)){
                deck.add(card);
                }
            }
        }
    }
    
    public void displayDeck(){
        Iterator<Card> it = deck.iterator();
    
        System.out.println("Deck size: " + Constants.NUM_CARDS_IN_DECK + " cards");
        System.out.println("Deck includes: ");
       //int counter = 0;
       //^Used for printing a counter along with cards
        while(it.hasNext()){
           Card card = it.next();
           //System.out.print(counter + " "); 
           //^Used for printing a counter along with cards
           System.out.print("Card: ");
           System.out.println(card.getFace() + " of " + card.getSuit() + " is color " + card.getColor());
           //counter++;
           //^Used for printing a counter along with cards
       }
    }
    
    public void shuffleDeck(){
        System.out.println("*******************************");
        System.out.println("Shuffling the deck of cards");
        System.out.println("*******************************");
        List arrayDeck = new ArrayList<Card>(deck); 
        Collections.shuffle(arrayDeck); 
         
        Set<Card> newDeck = new HashSet<Card>(arrayDeck);
         
        deck = newDeck;
    }
}
