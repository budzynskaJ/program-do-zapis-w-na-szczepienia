/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedWriter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


/**
 * Klasa obsługująca okno wyboru szczepienia, o którym pacjent chce się dowiedzieć 
 * 
 * @author jbudz
 */
public class Vaccinations implements ActionListener, WindowListener{
    
    JFrame frame = new JFrame();
    JLabel pfizerInfo = new JLabel();
    JLabel modernaInfo = new JLabel();
    JLabel JandJInfo = new JLabel();
    JLabel astraInfo = new JLabel();
    JButton returnButton = new JButton("Wróć");
    JButton modernaButton = new JButton("Moderna");
    JButton pfizerButton = new JButton("Pfizer");
    JButton astraZenecaButton = new JButton("AstraZeneca");
    JButton johnsonButton = new JButton("Johnson&Johnson");
    JMenuBar menubar = new JMenuBar();
    JMenu menu = new JMenu("Menu");
    JMenuItem logout = new JMenuItem("Wyloguj się");
    JMenuItem profile = new JMenuItem("Mój profil");
    String fileName = "wirus.png";
    
    ImageIcon image = new ImageIcon(fileName);
    
    File file = new File("save.txt");
    
    
    /**
     * Konstruktor klasy Vaccinations 
     * Tworzy graficzną stronę okna
     */
    Vaccinations()
    {
        
        returnButton.setBounds(175,350,150,40);
        returnButton.setFocusable(false);
        returnButton.addActionListener(this);
        returnButton.setForeground(Color.black);
        returnButton.setBackground(new Color(252, 179, 179));  
        returnButton.setForeground(Color.white);
        returnButton.setFont(new Font(null, Font.BOLD, 16));
        
        modernaButton.setBounds(115,60,275,40);
        modernaButton.setFocusable(false);
        modernaButton.addActionListener(this);
        modernaButton.setBackground(new Color(148, 197, 246));
        modernaButton.setForeground(Color.white);
        modernaButton.setFont(new Font(null, Font.BOLD, 14));
        
        pfizerButton.setBounds(115,120,275,40);
        pfizerButton.setFocusable(false);
        pfizerButton.addActionListener(this);
        pfizerButton.setBackground(new Color(148, 197, 246));
        pfizerButton.setForeground(Color.white);
        pfizerButton.setFont(new Font(null, Font.BOLD, 14));
        
        astraZenecaButton.setBounds(115,180,275,40);
        astraZenecaButton.setFocusable(false);
        astraZenecaButton.addActionListener(this);
        astraZenecaButton.setBackground(new Color(148, 197, 246));
        astraZenecaButton.setForeground(Color.white);
        astraZenecaButton.setFont(new Font(null, Font.BOLD, 14));
        
        johnsonButton.setBounds(115,240,275,40);
        johnsonButton.setFocusable(false);
        johnsonButton.addActionListener(this);
        johnsonButton.setBackground(new Color(148, 197, 246));
        johnsonButton.setForeground(Color.white);
        johnsonButton.setFont(new Font(null, Font.BOLD, 14));
        
        
        menu.setFocusable(false);
        menu.setVisible(true);
        menu.add(profile);
        menu.add(logout);
        menubar.add(menu);
        menubar.setBackground(Color.WHITE);
        menubar.setBorderPainted(false);
        logout.addActionListener(this);
        profile.addActionListener(this);
        
        frame.setJMenuBar(menubar);
        
        try {
            frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("wirus_miniaturka.png")))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        frame.setTitle("Informacje o szczepionkach");
        frame.setResizable(false);
        frame.getContentPane().setBackground(new Color (176, 196, 222));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        
        frame.add(pfizerInfo);
        frame.add(modernaInfo);
        frame.add(JandJInfo);
        frame.add(astraInfo);
        frame.add(returnButton);
        frame.add(modernaButton);
        frame.add(pfizerButton);
        frame.add(astraZenecaButton);
        frame.add(johnsonButton);
        frame.setIconImage(image.getImage());
        frame.addWindowListener(this);
    }

    
    /**
     * Metoda obsługująca interakcje użytkownika z programem na poziomie okna Vaccinations
     * 
     * @param e reprezentuje rodzaj działania użytkownika 
     */
    @Override
    public void actionPerformed(ActionEvent e) {    
        
        if(e.getSource() == returnButton)
        {
            frame.dispose();
        }
        else if(e.getSource()== modernaButton) {
            try {
                Moderna moderna = new Moderna();
            } catch (IOException ex) {
                Logger.getLogger(Vaccinations.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(e.getSource()== pfizerButton) {
            Pfizer pfizer = new Pfizer();
        }
        else if(e.getSource()== astraZenecaButton) {
            AstraZeneca astraZeneca = new AstraZeneca();
        }
        else if(e.getSource()== johnsonButton) {
            JandJ jandj = new JandJ();
        }
        else if (e.getSource() == profile)
        {
            try {
                MyAccount page = new MyAccount();
            } catch (IOException ex) {
                Logger.getLogger(WelcomePage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(e.getSource() == logout)
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

    @Override
    public void windowOpened(WindowEvent we) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public void windowClosed(WindowEvent we) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowIconified(WindowEvent we) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeiconified(WindowEvent we) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowActivated(WindowEvent we) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeactivated(WindowEvent we) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
