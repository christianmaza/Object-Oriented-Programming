package casino;

import java.util.Scanner;

public class Player {
    private int cash; 
    private String playerName;
    private Scanner scan;
    
    public Player(){
       int money; 
       String name;
       scan = new Scanner(System.in);
       
       System.out.println("Enter player name ");
       name = scan.next(); 
       System.out.println("Enter amount of money to play(minimum $5) ");
       money = scan.nextInt();
       
       setCash(money); 
       setPlayerName(name);
       
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
    
}
