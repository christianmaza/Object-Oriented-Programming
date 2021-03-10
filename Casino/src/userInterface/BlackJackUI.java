
package userInterface;
import casino.Player;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class BlackJackUI extends JPanel {
    private CasinoUI casinoUi; 
    private Player player; 
    private JLabel data; 
    
    public BlackJackUI(Player playerP, CasinoUI casinoUiP){
        player = playerP; 
        casinoUi = casinoUiP;   
        initComponents();
    }
    
    public void initComponents(){
        data = new JLabel("Welcome to Knights Casino Black Jack"); 
        this.add(data);
    }
}
