package userInterface;

import casino.Player;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class ScratchOffsUI extends JPanel {
    private Player player; 
    private CasinoUI casinoUi; 
    private JLabel data;
    private JLabel data2;
    
    public ScratchOffsUI(Player playerP, CasinoUI casinoUiP){
        player = playerP; 
        casinoUi = casinoUiP; 
        initComponents();
    }
    
    public void initComponents(){
        data = new JLabel("Welcome to Knights Casino! ScratchOffs"); 
        this.add(data);
    }
}
