package dungen.View;


import Dungeon.Controler.GameControler;
import javax.swing.JFrame;

public class DungenGamestartMain {
    
    
    public static void main(String[] args) 
    {
       JFrame Frame1 = new JFrame("DUNGEON GAME");               
       Frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       Frame1.setVisible(true);              
       Frame1.getContentPane().add(new JPanelLogInDungeonGame());        
       Frame1.pack();     
    }
    
                          
    
   
}
