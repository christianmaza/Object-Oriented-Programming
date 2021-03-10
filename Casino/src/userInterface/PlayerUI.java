/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import casino.Player;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author CHRISTIANMAZA-MAC
 */
public class PlayerUI extends JPanel {

    private Player player; 
    private JLabel cashBalance; 
    private JLabel cashLabel; 
    
    public PlayerUI(Player playerP){
        player = playerP; 
        initComponents();
    }
    
    public void initComponents(){
        String playerName = JOptionPane.showInputDialog(null, "Enter the name of player."); 
        String playerInputCash = JOptionPane.showInputDialog(null, "Enter cash to play."); 
        
        player.setPlayerName(playerName);
        player.setCash(Integer.parseInt(playerInputCash));
        this.setPreferredSize(new Dimension(200, 600));
        this.setBorder(BorderFactory.createTitledBorder("Player"));
        cashBalance = new JLabel("Cash Balance $"); 
        cashLabel = new JLabel(Integer.toString(player.getCash()));
        
        this.add(cashBalance);
        this.add(cashLabel);
        
    }
    
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public JLabel getCashBalance() {
        return cashBalance;
    }

    public void setCashBalance(JLabel cashBalance) {
        this.cashBalance = cashBalance;
    }

    public JLabel getCashLabel() {
        return cashLabel;
    }

    public void setCashLabel(JLabel cashLabel) {
        this.cashLabel = cashLabel;
    }
    
}
