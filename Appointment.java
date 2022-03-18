/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;



import java.awt.Color;
import java.awt.Font;
import java.awt.Window;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.ImageIcon;


/**
 * Klasa obsługująca okno informujące o poprawnym zapisie na szczepienie
 * 
 * @author aleks
 */
public class Appointment implements ActionListener{
    JFrame frame = new JFrame();
    JLabel label1 = new JLabel();
    JLabel label2 = new JLabel();
    JButton action = new JButton("OK");
    JButton logout = new JButton("Wyloguj się");
    
    String fileName = "wirus.png";
    ImageIcon image = new ImageIcon(fileName);
    
    
    
    /**
     * Konstruktor z parametrami klasy Appointment
     * Tworzy graficzna strone okna
     * 
     * @param vaccine reprezentuje rodzaj szczepionki, na która zapisał się pacjent
     * @param day reprezentuje dzień szczepienia
     * @param hour reprezentuje godzinę szczepienia
     * @throws FileNotFoundException obsługuje wyjątek nie znalezienia pliku
     */
    Appointment(String vaccine, String day, String hour) throws FileNotFoundException {
  
        frame.setResizable(false);
        frame.getContentPane().setBackground(new Color(212, 236, 234));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 250);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        
        action.setBounds(200, 150, 100, 40);
        action.setFocusable(false);
        action.addActionListener(this);
        action.setBackground(new Color(252, 179, 179));  
        action.setForeground(Color.white);
        action.setFont(new Font(null, Font.BOLD, 16));
        
        logout.setBounds(390, 15, 98, 15);
        logout.setFocusable(false);
        logout.addActionListener(this);
        logout.setBackground(Color.white);
        logout.setForeground(Color.black);
        logout.setFont(new Font(null, Font.ITALIC, 12));
        
        label1.setBounds(25, 25, 450, 50);
        label1.setVisible(true);
        label1.setOpaque(false);
        label1.setBackground(new Color (0, 0, 0, 0));
        
        label2.setBounds(25, 60, 450, 50);
        label2.setVisible(true);
        label2.setOpaque(false);
        label2.setBackground(new Color (0, 0, 0, 0));
                 
        String t1 = ("Zapisałeś się na szczepienie: " + vaccine);
        String t2 = ("Termin: " + day + " " + hour);

        label1.setText(t1);
        label1.setFont(new Font(null, Font.ITALIC | Font.BOLD, 18));
        label2.setText(t2);
        label2.setFont(new Font(null, Font.ITALIC | Font.BOLD, 18));
        

        frame.add(label1);
        frame.add(label2);
        frame.add(action);
        frame.add(logout);
        frame.setIconImage(image.getImage());
    }
    

    
    /**
     * Metoda obsługujacą interakcje użytkownika z programem na poziomie okna Appointment
     * 
     * @param e reprezentuje rodzaj działania użytkownika
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == action) {
            frame.dispose();
            for (Window window : Window.getWindows()) {
                window.dispose();
            }
            WelcomePage welcomePage = new WelcomePage();
        }   
        else if (e.getSource() == logout) {
            System.exit(0);
        }
    }   
}
