package scratchOffs;
import casino.Player;
import constants.Constants;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ScratchOffs {
    ArrayList<Integer> playerNumbers;
    ArrayList<Integer> winningNumbers; 
    ArrayList<Character> bonusSymbols;
    ArrayList<Double> prizes;
    private String ticketName;
    private char[] symbols;
    private Player player; 
    private double bonusWorth;
    private int bonus; 
    private char bonusSymbol;
    private int base;
    private int numSymbols;
    private int yourNums;
    private int winNums;
    private int earnings; 
    private int numPrizes;
    private Random randNum;
    private boolean play;
    private Scanner scan;
    
    public ScratchOffs(Player player){
        this.player = player;
        setPlay(true);
        scan = new Scanner(System.in);
    }
    
    public ScratchOffs(){
    }
    
    public void play(){
        
        displayRules();
        int typeTicket; 
        int numTickets; 
        if(player.getCash() < 1){
            play = false;
            System.out.println("Sorry, you don't have enough cash to play.");
        }
        else{ 
            while(play){
                System.out.println("Which type of scratch off would you like (1 = One Dollar, 5 = Five Dollar, 10 = Ten Dollar");
                typeTicket = scan.nextInt();
                System.out.println("How many scratch offs wouls you like?");
                numTickets = scan.nextInt();
                System.out.println("Getting your scratch offs...");
                switch(typeTicket){
                    case Constants.ONE :
                        player.setCash(player.getCash() - (numTickets * Constants.ONE));
                        if(player.getCash() < Constants.ZERO){
                           System.out.println("Sorry you don't have enough cash");
                           play = false;
                           break;
                        }
                        for(int i = 0; i < numTickets; i++){
                          ScratchOffs oneDollar = new OneDollar();
                          oneDollar.setPlayer(player);
                          //System.out.println(oneDollar.getPlayer().getCash());
                          oneDollar.displayTicket();
                          oneDollar.cashTicket();
                        }
                        break;
                   
                    case Constants.FIVE : 
                        player.setCash(player.getCash() - (numTickets * Constants.FIVE));
                        if(player.getCash() < Constants.ZERO){
                           System.out.println("Sorry you don't have enough cash");
                           play = false;
                           break;
                        }
                        for(int i = 0; i < numTickets; i++){
                          ScratchOffs fiveDollar = new FiveDollar();
                          fiveDollar.setPlayer(player);
                          //System.out.println(fiveDollar.getPlayer().getCash());
                          fiveDollar.displayTicket();
                          fiveDollar.cashTicket();
                        }
                        break;
                        
                    case Constants.TEN :
                        player.setCash(player.getCash() - (numTickets * Constants.TEN));
                        if(player.getCash() < Constants.ZERO){
                           System.out.println("Sorry you don't have enough cash");
                           play = false;
                           break;
                        }
                        for(int i = 0; i < numTickets; i++){
                          ScratchOffs tenDollar = new TenDollar();
                          tenDollar.setPlayer(player);
                          //System.out.println(tenDollar.getPlayer().getCash());
                          tenDollar.displayTicket();
                          tenDollar.cashTicket();
                        }
                        break;
                        
                    default: 
                        System.out.println("Invalid selection");
                        break;
                }
                if(player.getCash() > Constants.ONE){
                    int temp;
                    System.out.println("Would you like to play agian? (1 = YES, 0 = NO)");
                    temp = scan.nextInt(); 
                    play = (temp == 1);
                }
                else{
                    play = false;
                }
            }
        }
        
        /*ScratchOffs tenDollar = new TenDollar();
        tenDollar.setPlayer(player);
        System.out.println(tenDollar.getPlayer().getCash());
        tenDollar.cashTicket();
        ScratchOffs twoDollar = new OneDollar();
        System.out.println(oneDollar.randomNumber(20));*/
        
    }
    
    public void displayRules(){
        System.out.println("Let's play scratch off tickets!");
        System.out.println("Players can select from One Dollar, Five Dollar and Ten Dollar tickets");
        System.out.println("Prizes are based on the ticket selected"); 
    }
    
    public void createTicket(){
        for(int i = 0; i < winNums; i++){
            winningNumbers.add(randomNumber(base));
        }
        for(int i = 0; i < yourNums; i++){
            playerNumbers.add(randomNumber(base));
        }
        for(int i = 0; i < numPrizes; i++){
            Double tempNum = (double)randomNumber(base);
            prizes.add(tempNum);
        }
        for(int i = 0; i < bonus; i++){ 
            bonusSymbols.add(symbols[randomNumber(symbols.length - 1)]);
        }
        
        /*for(int number : winningNumbers){
            System.out.println(number);
        }
        System.out.println();
        
        for(int number : playerNumbers){
            System.out.println(number);
        }
        
        System.out.println();
        
        for(double number : prizes){
            System.out.println(number);
        } 
        
        System.out.println(bonusSymbol);
        
        System.out.println();
        
        for(char symbol : bonusSymbols){
            System.out.println(symbol);
        }*/
    }
    
    public int randomNumber(int baseValue){
        randNum = new Random();
        int randReturn;
        randReturn = randNum.nextInt(baseValue) + 1;
        return randReturn;
    }
    
    public void cashTicket(){
        for(int i = 0; i < winningNumbers.size(); i++){
            for(int j = 0; j < playerNumbers.size(); j++){
                if(winningNumbers.get(i).equals(playerNumbers.get(j))){
                    player.setCash(player.getCash() + prizes.get(j).intValue());
                    earnings += prizes.get(j).intValue();
                }
            }
        }
        for(int i = 0; i < bonusSymbols.size(); i++){
            if(bonusSymbols.get(i) == bonusSymbol){
                player.setCash(player.getCash() + (int) bonusWorth);
                earnings += bonusWorth;
            }
        }
        System.out.println();
        System.out.println("Bonus symbol is " + bonusSymbol);
        System.out.printf("Bonus is worth $%.2f\n", bonusWorth);
        System.out.println("Your " + ticketName + " Scratch Off won you $" + earnings);
        System.out.println("CASH - $" + player.getCash());
    }
    
    public void displayTicket(){
    }
    
    public void generateBonus(){
        setBonusSymbol(symbols[randomNumber(symbols.length - 1)]);
    }
    
    
    
    
    
    
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public double getBonusWorth() {
        return bonusWorth;
    }

    public void setBonusWorth(double bonusWorth) {
        this.bonusWorth = bonusWorth;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getNumSymbols() {
        return numSymbols;
    }

    public void setNumSymbols(int numSymbols) {
        this.numSymbols = numSymbols;
    }

    public int getYourNums() {
        return yourNums;
    }

    public void setYourNums(int yourNums) {
        this.yourNums = yourNums;
    }

    public int getWinNums() {
        return winNums;
    }

    public void setWinNums(int winNums) {
        this.winNums = winNums;
    }

    public Random getRandNum() {
        return randNum;
    }

    public void setRandNum(Random randNum) {
        this.randNum = randNum;
    }
    
    public int getNumPrizes() {
        return numPrizes;
    }

    public void setNumPrizes(int numPrizes) {
        this.numPrizes = numPrizes;
    }
    
    public char getBonusSymbol() {
        return bonusSymbol;
    }

    public void setBonusSymbol(char bonusSymbol) {
        this.bonusSymbol = bonusSymbol;
    }
    
    public int getEarnings() {
        return earnings;
    }

    public void setEarnings(int earnings) {
        this.earnings = earnings;
    }
    
    public boolean isPlay() {
        return play;
    }

    public void setPlay(boolean play) {
        this.play = play;
    }
    
    public String getTicketName() {
        return ticketName;
    }

    public void setTicketName(String ticketName) {
        this.ticketName = ticketName;
    }
    
    public char[] getSymbols() {
        return symbols;
    }

    public void setSymbols(char[] symbols) {
        this.symbols = symbols;
    }
}
