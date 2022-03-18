/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;


import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;


/**
 * Klasa obsługująca okno informujące o pomyślnej rejrestracji na szczepienie
 * 
 * @author jbudz
 */
public class Registration implements ActionListener {
    
    JFrame frame = new JFrame();
    JLabel label = new JLabel("Rejestracja przebiegła pomyślnie");
    JButton action = new JButton("OK");
                
    String fileName = "wirus.png";
    ImageIcon image = new ImageIcon(fileName);
    
    /**
     * Konstruktor klasy Registration
     * Tworzy graficzna stronę okna
     */            
    Registration() {
        label.setBounds(50, 25, 300, 40);
        label.setFont(new Font(null, Font.ROMAN_BASELINE, 20));
                
        action.setBounds(160, 100, 100, 40);
        action.setFocusable(false);
        action.addActionListener(this);
        action.setBackground(new Color(252, 179, 179));  
        action.setForeground(Color.white);
        action.setFont(new Font(null, Font.BOLD, 16));
                
                
        frame.setTitle("Stan rejestracji");
        frame.setResizable(false);
        frame.getContentPane().setBackground(new Color(152, 205, 205));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
                
        frame.add(label);
        frame.add(action);
        frame.setIconImage(image.getImage());
    }
    
    
    /**
     * Metoda osbługująca interakcje użytkownika z programem na poziomie okna Registration
     * 
     * @param e reprezentuje rodzaj działania użytkownika z programem 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
               
        if(e.getSource() == action) {
            frame.dispose();
            WelcomePage welcomePage = new WelcomePage();
        }
    }
    
}
