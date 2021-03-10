package slots;
import casino.Player;
import constants.Constants;
import java.util.Random;
import java.util.Scanner;

public class Slots {
    private Player player;
    private char spins[];
    private boolean play; 
    private Random rand;
    private Scanner scan; 
    
    private static final char SYMBOLS[] = {'$', '%', '&', '#', '@', '!'};
    private static final int SLOTS = 3;
    
    public Slots(Player player){
       this.player = player;
       this.play = true;
       scan = new Scanner(System.in);
       rand = new Random(); 
       spins = new char[SLOTS];
    }
    
    private int randomSymbol(){
        int symbolReturn = rand.nextInt(SYMBOLS.length - 1);
        
        return symbolReturn;
    }
    
    public void play(){
       int input; 
       
       
       System.out.println("Let's play the slot machines!");
       System.out.println("Your current balance is $" + player.getCash());
       System.out.println("The bet is $" + Constants.BET);
       System.out.println("Match two symbols to win $" + Constants.PAIR_PAYOUT);
       System.out.println("Match all three symbols to win $" + Constants.TRIPLE_PAYOUT);
       
       
       if(player.getCash() < Constants.BET){
           System.out.println("Sorry, you don't have enough money to play.");
           play = false;
       } 
       
       while(play == true){
           player.setCash(player.getCash() - Constants.BET);
           System.out.println("Spinning...");
           for(int i = 0; i < spins.length; i++){
               spins[i] = SYMBOLS[randomSymbol()];
               System.out.print(spins[i] + " ");
           }
           System.out.println();
           if(spins[0] == spins[1] && spins[1] == spins[2] && spins[1] == spins[2]){
               System.out.println("Three symbols matched, you won $" 
                                   + Constants.TRIPLE_PAYOUT);
               player.setCash(player.getCash() + Constants.TRIPLE_PAYOUT);
           }
           else if(spins[0] == spins[1] || spins[1] == spins[2] || spins[0] == spins[2]){
               System.out.println("Two symbols matched, you won $" 
                                   + Constants.PAIR_PAYOUT);  
               player.setCash(player.getCash() + Constants.PAIR_PAYOUT);
           }
           else{
               System.out.println("No symbols matched, you won $0");
           }
           
           if(player.getCash() >= Constants.BET){
               System.out.println("CASH = $" + player.getCash());
               System.out.println("Would you like to play again (Yes = 1, No = 0)?"); 
               input = scan.nextInt(); 
               
               if(input == 1){
                   play = true;
               }
               else{
                   play = false;
                   System.out.println("Thank you for playing slots at Knights Casino! Your cash out is $" + player.getCash());
               }
           } 
           else{
               System.out.println("You are out of money, you cannot play");
               System.out.println("Thank you for playing slots at Knights Casino! Your cash out is $" + player.getCash());
               play = false;
           }

       }
    }
}
