package casino;

import blackjack.Card;
import java.util.Scanner;
import constants.Constants;
import java.util.ArrayList;

public class Player implements IPlayer {
    private int cash; 
    private String playerName;
    private Scanner scan;
    private ArrayList<Card> hand; 
    private int score; 
    private boolean play;
    private boolean busted;
    
    public Player(){
       /*
       int money; 
       String name;
       scan = new Scanner(System.in);
       
       System.out.println("Enter player name ");
       name = scan.next(); 
       System.out.println("Enter amount of money to play(minimum $10) ");
       money = scan.nextInt();
       setCash(money); 
       setPlayerName(name);
       hand = new ArrayList<Card>(); 
       score = 0; 
       busted = false;
       */
       
    }
    
    @Override 
    public int hitOrStand(){
        int choice;
        System.out.println("Player, another card? (0 = STAND, 1 = HIT)");
        choice = scan.nextInt();
        //while(choice > Constants.HIT || choice < Constants.STAND){
            if(choice == Constants.HIT){
                choice = Constants.HIT;
                
            }
            else if(choice == Constants.STAND){
                choice = Constants.STAND;
            }
            //else{
            //    System.out.println("Invalid choice");
            //    System.out.println("Player, another card? (0 = STAND, 1 = HIT)");
            //    choice = scan.nextInt();
            //}
        //}
        return choice;
    } 
    
    public boolean playAgain(){
        int choice; 
        System.out.println("Play another hand? (0 = YES, 1 = NO)");
        choice = scan.nextInt();
        //while(choice > Constants.ONE || choice < Constants.ZERO){
            if(choice == 1){
                play = false;
            }
            else if(choice == 0){
                play = true;
            }
            //else{
                //System.out.println("Invalid choice");
                //System.out.println("Player, another hand? (0 = YES, 1 = NO)");
                //choice = scan.nextInt();
            //}
        //}
        return play;
        
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
    
    public void setPlayerName(String name){
        this.playerName = name;
    } 
    
    public void setCash(int money){
        this.cash = money;
    }
    
    public int getCash(){
        return this.cash;
    } 
    
    public String getPlayerName(){
        return this.playerName;
    } 
    
    public void setPlay(boolean play) {
        this.play = play;
    }

    public void setBusted(boolean busted) {
        this.busted = busted;
    }

    public boolean isPlay() {
        return play;
    }

    public boolean isBusted() {
        return busted;
    }
    
}
