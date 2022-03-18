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
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.io.File;
import java.io.FileWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


/**
 * Klasa obsługująca okno wyboru działania użytkownika w programie
 * 
 * @author jbudz
 */
public class WelcomePage implements ActionListener, WindowListener {
    
    JFrame frame = new JFrame();
    JLabel label = new JLabel("Co chciał(a)byś zrobić?");
    JButton b1 = new JButton("Zapis na szczepienie");
    JButton b2 = new JButton("Informacje o szczepionkach");
    JMenuBar menubar = new JMenuBar();
    JMenu menu = new JMenu("Menu");
    JMenuItem logout = new JMenuItem("Wyloguj się");
    JMenuItem profile = new JMenuItem("Mój profil");
    String fileName = "wirus.png";
    ImageIcon image = new ImageIcon(fileName);
    
    File file = new File("save.txt");
    
    
    /**
     * Konstruktor klasy WelcomePage
     * Tworzy graficzną stronę okna
     */
    WelcomePage()
    {
        label.setBounds(135, 70, 350, 25);
        label.setFont(new Font(null, Font.ROMAN_BASELINE, 22));
        
        b1.setBounds(100, 135, 300, 70);
        b1.setFocusable(false);
        b1.addActionListener(this);
        b1.setBackground(new Color(148, 197, 246));
        b1.setForeground(Color.white);
        b1.setFont(new Font(null, Font.BOLD, 14));
        
        b2.setBounds(100, 225, 300, 70);
        b2.setFocusable(false);
        b2.addActionListener(this); 
        b2.setBackground(new Color(148, 197, 246));
        b2.setForeground(Color.white);
        b2.setFont(new Font(null, Font.BOLD, 14));

        
        menu.setFocusable(false);
        menu.setVisible(true);
        menu.add(profile);
        menu.add(logout);
        menu.setFont(new Font(null, Font.ROMAN_BASELINE, 15));
        
        menubar.add(menu);
        menubar.setBackground(Color.WHITE);
        menubar.setBorderPainted(false);
        logout.addActionListener(this);
        profile.addActionListener(this);
               
        frame.setJMenuBar(menubar);
        
        frame.setTitle("Menu");
        frame.setResizable(false);
        frame.getContentPane().setBackground(new Color(176, 196, 222));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        try {
            frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("wirus_miniaturka.png")))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        frame.setIconImage(image.getImage());
        
        frame.add(label);
        frame.add(b1);
        frame.add(b2);
        frame.addWindowListener(this);
        
    }

    
    /** 
     * Metoda obsługująca interakcje użytkownika z programem na poziomie okna WelcomePage
     *
     * @param e reperezentuje rodzaj działania użytkownika
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == b1)
        {
            WhichVaccine page = new WhichVaccine();
        }
        else if (e.getSource() == b2)
        {
           Vaccinations page = new Vaccinations(); 
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
