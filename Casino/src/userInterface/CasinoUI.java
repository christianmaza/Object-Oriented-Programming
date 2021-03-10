
package userInterface;

import casino.Casino; 
import constants.Constants;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel; 

public class CasinoUI implements ActionListener{
    private JFrame frame; 
    private Casino casino; 
    private PlayerUI playerUi; 
    private SlotsUI slotsUi;
    private ScratchOffsUI scratchOffsUi;
    private BlackJackUI blackJackUi;
    private JPanel casinoPanel; 
    private JPanel buttonPanel; 
    private JPanel playerPanel; 
    private JPanel slotsPanel;
    private JPanel blackJackPanel;
    private JPanel gamePanel;
    private JButton slots; 
    private JButton scratchers; 
    private JButton blackJack;
    private static final String SLOTS = "Slots";
    private static final String BLACKJACK = "Black Jack"; 
    private static final String SCRATCHERS = "Scratch Offs"; 
    private CardLayout cardLayout; 
    
    public CasinoUI(Casino casinoP){
       casino = casinoP; 
       initObjects(); 
       initComponents(); 
    }
    
    public void initObjects(){
        playerUi = new PlayerUI(casino.getPlayer());
        blackJackUi = new BlackJackUI(casino.getPlayer(), this); 
        slotsUi = new SlotsUI(casino.getPlayer(), this);
        scratchOffsUi = new ScratchOffsUI(casino.getPlayer(), this);
        cardLayout = new CardLayout();
    }

    public void initComponents(){
        frame = new JFrame("Knights Casino");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setSize(1000,720);
        
        buttonPanel = new JPanel();
        blackJack = new JButton("Black Jack");
        slots = new JButton("Slots"); 
        scratchers = new JButton("Scratch Offs"); 
        blackJack.addActionListener(this); 
        slots.addActionListener(this); 
        scratchers.addActionListener(this); 
        
        buttonPanel.add(blackJack);
        buttonPanel.add(slots);
        buttonPanel.add(scratchers);
        
        
        gamePanel = new JPanel(); 
        gamePanel.setLayout(cardLayout); 
        gamePanel.setPreferredSize(new Dimension(900, 600));
        gamePanel.setBorder(BorderFactory.createTitledBorder("Games"));
        
        gamePanel.add(blackJackUi, "Black Jack");
        gamePanel.add(slotsUi, "Slots");
        gamePanel.add(scratchOffsUi, "Scratch Offs");
        
        
        frame.add(buttonPanel, BorderLayout.NORTH);
        frame.add(gamePanel, BorderLayout.CENTER);
        frame.add(playerUi, BorderLayout.WEST);
        
        frame.pack();
        frame.setVisible(true);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        cardLayout.show(gamePanel, (String)e.getActionCommand());
        frame.revalidate();
        frame.repaint();
        
    }
    
    public void updatePlayerUI(){
        playerUi.getCashLabel().setText(Integer.toString(playerUi.getPlayer().getCash()));
        
    }
    
    
}
