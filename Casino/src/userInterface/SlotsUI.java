
package userInterface;

import casino.Player;
import constants.Constants;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SlotsUI extends JPanel {
    Random random;
    private CasinoUI casinoUi; 
    private Player player; 
    private JLabel data;
    private JLabel bet;
    private JLabel grid1; 
    private JLabel grid2; 
    private JLabel grid3; 
    private JPanel headerPanel; 
    private JPanel slotsPanel;
    private JButton spin;
    private SpinListener spinListen;
    private ArrayList<ImageIcon> images;  
    private ArrayList<ImageIcon> spinIcons;

    
    public SlotsUI(Player playerP, CasinoUI casinoUiP ){
        player = playerP; 
        casinoUi = casinoUiP;
        initComponents();
        initImages();
    }
    
    public void initComponents(){
        data = new JLabel("Welcome to Knights Casino Slots");
        bet = new JLabel("The bet is $" + Constants.BET);
        spin = new JButton("Spin"); 
        spinListen = new SpinListener();
        spin.addActionListener(spinListen);
        
        headerPanel = new JPanel();
        headerPanel.setLayout(new GridLayout(3, 1));
        headerPanel.add(data);
        headerPanel.add(bet); 
        headerPanel.add(spin);
        slotsPanel = new JPanel(); 
        slotsPanel.setLayout(new GridLayout(1, 3));
        slotsPanel.setBorder(BorderFactory.createTitledBorder("Your Spin"));
       
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(headerPanel); 
        this.add(slotsPanel);
    }
    
    private class SpinListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            spin(); 
            results();
        }
        
    } 
    
    public void initImages(){
        images = new ArrayList<ImageIcon>(); 
        
        Path dir = Paths.get("./src/images/slots");
        System.out.println(dir.toAbsolutePath());
        try(DirectoryStream<Path> stream = Files.newDirectoryStream(dir)){
            for(Path file : stream) {
                ImageIcon temp = new ImageIcon(file.toString());
                imageResize(temp);
                images.add(temp);
                //System.out.println(file.toString());
            }
        }
        catch (IOException | DirectoryIteratorException x){
            System.err.println(x);
        }
    } 
    
    public ImageIcon imageResize(ImageIcon imageP){
        Image image = imageP.getImage();
        Image tempImage = image; 
        tempImage.getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
        imageP = new ImageIcon(tempImage);
        return imageP;
    }
    
    public void spin(){
        random = new Random();
        spinIcons = new ArrayList<ImageIcon>();
        ArrayList<Image> rawImages = new ArrayList<Image>();
        player.setCash(player.getCash() - Constants.BET);
        casinoUi.updatePlayerUI();
        slotsPanel.removeAll(); 
        
        for(ImageIcon icon : images){
            spinIcons.add(images.get(random.nextInt(images.size())));
        }
        
        grid1 = new JLabel(spinIcons.get(0));
        grid2 = new JLabel(spinIcons.get(1));
        grid3 = new JLabel(spinIcons.get(2));
        
        slotsPanel.add(grid1); 
        slotsPanel.add(grid2); 
        slotsPanel.add(grid3); 
        
        slotsPanel.repaint();
        slotsPanel.revalidate();
    } 
    
    public void results(){
        
        if(grid1.getIcon().equals(grid2.getIcon()) && grid2.getIcon().equals(grid3.getIcon()) && grid1.getIcon().equals(grid3.getIcon())){
               JOptionPane.showMessageDialog(null, "Three symbols matched, you won $" + Constants.TRIPLE_PAYOUT);
               player.setCash(player.getCash() + Constants.TRIPLE_PAYOUT);
               casinoUi.updatePlayerUI();
           }
           else if(grid1.getIcon().equals(grid2.getIcon()) || grid2.getIcon().equals(grid3.getIcon()) || grid1.getIcon().equals(grid3.getIcon())){
               player.setCash(player.getCash() + Constants.PAIR_PAYOUT);
               JOptionPane.showMessageDialog(null, "Two symbols matched, you won $" + Constants.PAIR_PAYOUT); 
               casinoUi.updatePlayerUI();
           }
           else{
               JOptionPane.showMessageDialog(null, "No symbols matched");
               casinoUi.updatePlayerUI();
           }
           
           /*if(player.getCash() >= Constants.BET){
               
               System.out.println("Would you like to play again (Yes = 1, No = 0)?");  
               
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
           }*/
    }
}
