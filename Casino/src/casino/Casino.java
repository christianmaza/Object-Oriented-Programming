package casino;
import java.util.Scanner;
import constants.Constants; 
import blackjack.BlackJack; 
import scratchOffs.ScratchOffs;
import slots.Slots;  
import userInterface.CasinoUI;

public class Casino { 
    
    private static BlackJack blackjack;
    private static ScratchOffs scratchers; 
    private static Slots slots;
    private static Player player;
    private static Scanner scan; 
    private static CasinoUI ui;
    
    /*
    private static int displayMenu(){
        int select;
        
        do{
            
            System.out.println("Welcome to Knights Casino!");
            System.out.println();
            System.out.println("Select the game to play"); 
            System.out.println("1. Black Jack");
            System.out.println("2. Scratch Off Tickets");
            System.out.println("3. Slot Machines");
            System.out.println("Enter the number of your choice:");
            
            select = scan.nextInt();
            
        }while(select < Constants.BLACK_JACK || select > Constants.SLOTS);
        
        return select;
    }
    */
    
    public static void main(String[] args) {
       int game; 
       scan = new Scanner(System.in); 
       
       player = new Player(); 
       
       ui = new CasinoUI(new Casino());
       
       /*
       game = displayMenu();
       
       switch(game){
            case Constants.BLACK_JACK: 
               blackjack = new BlackJack(player);
               blackjack.play();
               break;
           
            case Constants.SCRATCH: 
               scratchers = new ScratchOffs(player);
               scratchers.play();
               break;
           
            case Constants.SLOTS: 
               slots = new Slots(player);
               slots.play();
               break;
           
            default:
               System.out.println("Game selection was invalid.");
               break;
             
       }
       */
    }

    public static BlackJack getBlackjack() {
        return blackjack;
    }

    public static void setBlackjack(BlackJack blackjack) {
        Casino.blackjack = blackjack;
    }

    public static ScratchOffs getScratchers() {
        return scratchers;
    }

    public static void setScratchers(ScratchOffs scratchers) {
        Casino.scratchers = scratchers;
    }

    public static Slots getSlots() {
        return slots;
    }

    public static void setSlots(Slots slots) {
        Casino.slots = slots;
    }

    public static Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player player) {
        Casino.player = player;
    }
}
