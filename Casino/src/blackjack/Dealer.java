
package blackjack;

import java.util.ArrayList;
import java.util.Iterator; 
import constants.Constants;


public class Dealer implements IDealer{
    private ArrayList<Card> hand; 
    private int score; 
    private boolean busted;
    
    public Dealer(){
        hand = new ArrayList<Card>();
        score = 0;
        busted = false;
        
    }

    public void setBusted(boolean busted) {
        this.busted = busted;
    }

    public boolean isBusted() {
        return busted;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }

    public int getScore() {
        score = 0;
        for(Card getHand : hand){
           score+= getHand.getValue();  
        }
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    
    

    @Override
    public Card deal(Deck methodDeck){
        Card card = new Card();
        Iterator<Card> it = methodDeck.getDeck().iterator();
        while(it.hasNext()){
           card = it.next();
        } 
        
        methodDeck.getDeck().remove(card);
        return card;
    }
    
    @Override
    public int hitOrStand(){
       if(getScore() <= 16){
           return Constants.HIT;
       }
       else{
           return Constants.STAND;
       }
    }
}
