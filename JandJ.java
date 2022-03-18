/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Klasa obsługująca okno wyświetlajace informacje o szczepionce JandJ
 * 
 * @author aleks
 */
public class JandJ implements ActionListener, WindowListener {
    
    JFrame frame = new JFrame();
    JButton returnButton = new JButton("Wróć");
    JMenuBar menubar = new JMenuBar();
    JMenu menu = new JMenu("Menu");
    JMenuItem logout = new JMenuItem("Wyloguj się");
    JMenuItem profile = new JMenuItem("Mój profil");
    //JButton logout = new JButton("Wyloguj się");
    String fileName = "wirus.png";
    ImageIcon image = new ImageIcon(fileName);
    
    JTextPane tekst = new JTextPane();
    File file = new File("save.txt");
    
    
    /**
     * Konstruktor klasy JandJ
     * Tworzy graficzna stronę okna.
     * Informacje o szczepionce pobierane są z odpowiedniego pliku.txt.
     */
     JandJ() {
         
        returnButton.setBounds(200, 400, 150, 40);
        returnButton.setFocusable(false);
        returnButton.addActionListener(this);
        returnButton.setForeground(Color.black);
        returnButton.setBackground(new Color(252, 179, 179));  
        returnButton.setForeground(Color.white);
        returnButton.setFont(new Font(null, Font.BOLD, 16));
        
        menu.setFocusable(false);
        menu.setVisible(true);
        menu.add(profile);
        menu.add(logout);
        menubar.add(menu);
        menubar.setBackground(Color.WHITE);
        menubar.setBorderPainted(false);
        logout.addActionListener(this);
        profile.addActionListener(this);
        
                
        tekst.setBounds(25, 20, 500, 350);
        tekst.setFont(new Font(null, Font.ROMAN_BASELINE, 20));
        tekst.setVisible(true);
        tekst.setEditable(false);
        tekst.setOpaque(false);
        tekst.setBackground(new Color (0, 0, 0, 0));
        
        
        try {
            frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("wirus_miniaturka.png")))));
            
        } catch (IOException e) {
            e.printStackTrace();
        }
         
        frame.setTitle("Jonhson&Jonhson vaccine information");
        frame.setResizable(false);
        frame.getContentPane().setBackground(new Color (245, 207, 207));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(550, 500);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setIconImage(image.getImage());
        
        try {
            String sciezka = "JandJ.txt";
            File file = new File(sciezka);

            FileReader fr = new FileReader(file);
            do {
                tekst.read(fr,null);
            }
            while (fr.read() != -1);
            fr.close();
        } catch (IOException exception) {
            exception.printStackTrace();
          }
      
        
        frame.setJMenuBar(menubar);
        frame.add(tekst);
        frame.add(returnButton);
        frame.addWindowListener(this);


    }
    
     
     /**
      * Metoda obsługująca interakcje użytkownika z programem na poziomie okna JandJ
      * 
      * @param e reprezentuje rodzaj działania użytkownika
      */
     @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == returnButton)
        {
            frame.dispose(); 
        }
        else if (e.getSource() == profile)
        {
            try {
                MyAccount page = new MyAccount();
            } catch (IOException ex) {
                Logger.getLogger(WelcomePage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if (e.getSource() == logout)
        {
            if(file.exists()) {
                try {
                     BufferedWriter bw = new BufferedWriter(new FileWriter(file.getAbsolutePath()));
                     bw.write("");
                     bw.newLine();
                     bw.close();
                    } catch (IOException exception) {
                      exception.printStackTrace();
                      }
            }
            System.exit(0);
        }
        
}
    /**
     * Metoda obsługująca zdarzenie naciśnięcia czerwonego X (przycisku 
     * zamknięcia całego programu). W momencie naciśnięcia na przycisk
     * aplikacja zamyka się i aktualnie zalogowany użytkownik zostaje
     * wylogowany. Plik save.txt jest czyszczony.
     * @param we reprezentuje działanie użytkownika
     */
    @Override
    public void windowClosing(WindowEvent we) {
        if(file.exists()) {
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter(file.getAbsolutePath()));
                bw.write("");
                bw.newLine();
                bw.close();
            } catch (IOException exception) {
              exception.printStackTrace();
              }
        }
        System.exit(0);

    }

    @Override
    public void windowOpened(WindowEvent we) {
        
    }

    @Override
    public void windowClosed(WindowEvent we) {
        
    }

    @Override
    public void windowIconified(WindowEvent we) {
        
    }

    @Override
    public void windowDeiconified(WindowEvent we) {
        
    }

    @Override
    public void windowActivated(WindowEvent we) {
        
    }

    @Override
    public void windowDeactivated(WindowEvent we) {
        
    }

    
}
