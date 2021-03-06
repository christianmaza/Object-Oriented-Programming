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
    private Dealer dealer;
    
    public BlackJack(Player player){
        this.player = player;
        scan = new Scanner(System.in);
        play = true; 
        deck = new Deck();
        dealer = new Dealer();
    }
    
    public void play(){
        displayRules();
        if(player.getCash() < Constants.BET_BLACKJACK){
            play = false; 
            System.out.println("Sorry, you don't have enough cash to play.");
        }
        else{
          //maybe instanciate player hand here instead 
          //maybe instanciate dealer hand here instead
          while(play){
            player.setCash(player.getCash() - Constants.BET_BLACKJACK);
            System.out.println("Players cash $" + player.getCash());
            System.out.println("Dealing...");
            for(int i = 0; i < 2; i++){
               dealer.getHand().add(dealer.deal(deck)); 
               player.getHand().add(dealer.deal(deck));
            }
            System.out.println("Player score " + player.getScore());
            int anotherCard = 1;
            while((anotherCard > 0) && !player.isBusted() && !dealer.isBusted()){
                anotherCard = player.hitOrStand();
                if(anotherCard > 0){
                    player.getHand().add(dealer.deal(deck));
                    if(player.getScore() > Constants.BUST){
                       player.setBusted(true);
                    }
                }
                else{
                    play = false;
                }
                
                while(dealer.hitOrStand() > 0 && !player.isBusted()){
                    System.out.println("Dealer score " + dealer.getScore());
                    dealer.getHand().add(dealer.deal(deck));
                    
                }
                if(!player.isBusted()){
                System.out.println("Dealer score " + dealer.getScore());
                }
                anotherCard = 0;
                play = false;
                
                if(player.getScore() > Constants.BUST || dealer.getScore() > Constants.BUST){
                    if(player.getScore() > Constants.BUST){
                        System.out.println("Player busted! You lost the hand!");
                        player.setBusted(true);
                        play = false;
                    }
                    else{
                        System.out.println("Dealer busted!");
                        dealer.setBusted(true);
                        play = false;
                    }
                }
                System.out.println("Player score " + player.getScore());
                System.out.println("Dealer score " + dealer.getScore());
            }
            results();
            if(player.getCash() < Constants.BET_BLACKJACK){
                System.out.println("You are out of cash, you cannot play");
                break;
            }
            play = player.playAgain();
            if(play){
               reset();
            }
          }
        }
    }
    public void results(){
        if(dealer.isBusted()){
            System.out.println("Dealer BUSTED! Player wins $" + Constants.BET_BLACKJACK);
            player.setCash(player.getCash() + Constants.BET_BLACKJACK);
        }
        else if((!player.isBusted()) && (player.getScore() > dealer.getScore())){
            System.out.println("Player WINS the hand! Player wins $" + Constants.BLACKJACK_PAYOUT);
            player.setCash(player.getCash() + Constants.BLACKJACK_PAYOUT);
        }
        else if((!dealer.isBusted()) && (dealer.getScore() > player.getScore())){
            System.out.println("Dealer WINS the hand!");
        }
        else if(player.getScore() == dealer.getScore()){
            System.out.println("It was a PUSH! Player wins $" + Constants.BET_BLACKJACK);
            player.setCash(player.getCash() + Constants.BET_BLACKJACK);
        }
        
    } 
    
    public void reset(){
        player.setBusted(false);
        dealer.setBusted(false);
        player.getHand().clear();
        dealer.getHand().clear();
        player.setScore(0);
        dealer.setScore(0);
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
