package scratchOffs;

import casino.Player;
import java.util.ArrayList;
import java.util.Random;

public class TenDollar extends ScratchOffs{
    private char[] symbolList = new char[]{'$', '%', '#', '@', '!', '{', ']'};
    public TenDollar(){
        setTicketName("Ten Dollar");
        setEarnings(0);
        setBase(60);
        setYourNums(15);
        setWinNums(4);
        setBonus(4);
        setBonusWorth(30.00);
        setNumPrizes(15);
        setSymbols(symbolList);
        playerNumbers = new ArrayList<Integer>();
        winningNumbers = new ArrayList<Integer>();
        bonusSymbols = new ArrayList<Character>();
        prizes = new ArrayList<Double>();
        generateBonus();
        createTicket();
        //cashTicket();
    }
    
    @Override
    public void displayTicket(){
        int count = 0; 
        final int BREAK = 5;
        System.out.printf("+------------------------------------------+\n");
        System.out.printf("| WINNING NUMBERS "); 
        for(Integer i : winningNumbers){
            System.out.printf("%5d", i);
        }
        System.out.printf("%5s|\n|%42s|\n", " ", " ");
        System.out.printf("| YOUR NUMBERS%29s|\n|", " ");
        for(int i = 0; i < playerNumbers.size(); i++){
            count++;
            System.out.printf("%8d", playerNumbers.get(i));
            
            if((count % BREAK) == 0){
                System.out.printf("%2s|\n|", " ");
                
            }
        }
        System.out.printf("%42s|\n", " ");
        System.out.printf("| PRIZES%35s|\n", " ");
        System.out.printf("| %41s|\n|", " ");
        
        count = 0;
        
        for(int i = 0; i < prizes.size(); i++){
            count++;
            System.out.printf("%8.2f", prizes.get(i));
            
            if((count % BREAK) == 0){
                System.out.printf("%2s|\n|", " ");
            }
        }
        
        System.out.printf("%42s|\n", " ");
        System.out.printf("| SYMBOLS%34s|\n", " ");
        System.out.printf("| %41s|\n|", " ");
        
        for(Character c : bonusSymbols){
            System.out.printf("%8c", c);
        }
        
        System.out.printf("%10s|\n+------------------------------------------+", " ");
    }
}
