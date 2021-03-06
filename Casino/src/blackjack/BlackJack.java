package blackjack;

import casino.Player;
import constants.Constants;
import java.util.Scanner;
//import deck.Deck; 

public class BlackJack {
    private Player player;
    private Scanner scan; 
    private boolean play; 
    private Deck deck;
    
    public BlackJack(Player player){
        this.player = player;
        scan = new Scanner(System.in);
        play = true; 
        deck = new Deck();
    }
    
    public void play(){
        displayRules();
        
    } 
    
    private void displayRules(){
        System.out.println("Let's play Black Jack!");
        System.out.println("Your cash balance is $" + player.getCash());
        System.out.println("The bet is $" + Constants.BET_BLACKJACK);
        System.out.println("The dealer must HIT if their score is 16 or less");
        System.out.println("The dealer must STAND if their score is 17 or higher");
        System.out.println("If the player wins the hand, they recieve $" + Constants.BLACKJACK_PAYOUT);
        System.out.println("If the dealer wins the hand, the $" + Constants.BET_BLACKJACK + " bet is lost");
        System.out.println("If it is a PUSH, the player keeps their $" + Constants.BET_BLACKJACK + " bet");
    }
}
