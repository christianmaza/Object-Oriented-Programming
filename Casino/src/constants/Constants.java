
package constants;

public class Constants {
    public static final int BLACK_JACK = 1; 
    public static final int SCRATCH = 2;
    public static final int SLOTS = 3; 
    public static final int BET = 5; 
    public static final int PAIR_PAYOUT = 5; 
    public static final int TRIPLE_PAYOUT = 50; 
    public static final int BET_BLACKJACK = 10; 
    public static final int BLACKJACK_PAYOUT = 20; 
    public static final int NUM_CARDS_IN_DECK = 52;
    
    public enum Colors{
    RED, 
    BLACK
    } 

    public enum Suits{
        SPADES,
        CLUBS,
        DIAMONDS,
        HEARTS
    }

    public enum FaceValue{
        ACE,TWO,
        THREE,FOUR,
        FIVE,SIX, 
        SEVEN,EIGHT,
        NINE,TEN,
        JACK,QUEEN,
        KING
    }
    
}

