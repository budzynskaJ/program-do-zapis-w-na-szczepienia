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
import java.io.BufferedWriter;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.Map;


/**
 * Klasa obsługująca pierwsze okno programu dotyczące logowania lub tworzenia konta
 * 
 * @author jbudz
 */


public class LoginPage implements ActionListener{
    
    JFrame frame= new JFrame();
    JButton loginButton= new JButton("Zaloguj");
    JButton resetButton= new JButton("Resetuj");
    JButton registrationButton = new JButton("Rejestruj się");
    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField= new JPasswordField();
    JLabel loginLabel= new JLabel("Zaloguj się:");
    JLabel userIDLabel = new JLabel("PESEL");
    JLabel registrationLabel = new JLabel("Nie masz jeszcze konta? Utwórz nowe.");
    JLabel userPasswordLabel= new JLabel("Hasło");
    JLabel messageLabel = new JLabel();
    String fileName = "wirus.png";
    
    File file = new File("save.txt");
    File file2 = new File("accounts.txt");

    ImageIcon image = new ImageIcon(fileName); 
    
    HashMap<String, String> logininfo= new HashMap<String, String>();
    HashMap<String, String> logPas = new HashMap<String, String>();
    HashMap<String, List> patients = new HashMap<String, List>();

    
    /**
     * Konstruktor z parametrami klasy LoginPage 
     * tworzy graficzną stronę okna
     * 
     * @param loginInfoOriginal reprezentuje HashMape przechowująca pesele i hasła 
     * pacjentów
     * @param currentpatient reprezentuje HashMape przechowująca dane pacjentów
     */
    LoginPage(HashMap<String, String> loginInfoOriginal, HashMap<String, List> currentpatient)
    {
        
        logPas=loginInfoOriginal;
        patients = currentpatient;
        
        loginLabel.setBounds(75, 60, 200, 40);
        loginLabel.setFont(new Font(null, Font.ROMAN_BASELINE, 25));
        userIDLabel.setBounds(90, 125, 75, 25);
        userIDLabel.setFont(new Font(null, Font.ROMAN_BASELINE, 18));
        userPasswordLabel.setBounds(90, 175, 75, 25);
        userPasswordLabel.setFont(new Font(null, Font.ROMAN_BASELINE, 18));
        
        registrationLabel.setBounds(95, 300, 400, 25);
        registrationLabel.setFont(new Font(null, Font.ROMAN_BASELINE, 20));
        
        messageLabel.setBounds(160, 260, 275, 35);
        messageLabel.setFont(new Font(null, Font.ITALIC, 25));

        
        userIDField.setBounds(160, 125, 200, 25);
        userIDField.setFont(new Font(null, Font.ROMAN_BASELINE, 17));
        userPasswordField.setBounds(160, 175, 200, 25);
        userPasswordField.setFont(new Font(null, Font.ROMAN_BASELINE, 17));
        
        resetButton.setBounds(160, 225, 100, 30);
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);
        resetButton.setBackground(new Color(252, 179, 179)); 
        resetButton.setForeground(Color.white);
        resetButton.setFont(new Font(null, Font.BOLD, 16));
        
        loginButton.setBounds(260, 225, 100, 30);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);
        loginButton.setBackground(new Color(88, 215, 215)); 
        loginButton.setForeground(Color.white);
        loginButton.setFont(new Font(null, Font.BOLD, 16));
        
        
        registrationButton.setBounds(160, 340, 200, 30);
        registrationButton.setFocusable(false);
        registrationButton.addActionListener(this);
        registrationButton.setBackground(new Color(148, 197, 246));
        registrationButton.setForeground(Color.white);
        registrationButton.setFont(new Font(null, Font.BOLD, 16));
        
        frame.setTitle("Kontrola szczepień");
        frame.setIconImage(image.getImage());
        frame.setResizable(false);
        frame.getContentPane().setBackground(new Color(176, 196, 222));
       
        try {
            frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("wirus_miniaturka.png")))));
        } catch (IOException e) {
            e.printStackTrace();
        }
       
        
        frame.add(loginLabel);
        frame.add(userIDLabel);
        frame.add(userPasswordLabel);
        frame.add(registrationLabel);
        frame.add(messageLabel);
        frame.add(userIDField);
        frame.add(userPasswordField);
        frame.add(loginButton);
        frame.add(resetButton);
        frame.add(registrationButton);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null); 
    }

    LoginPage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    /**
     * Metoda obsługująca interakcje użytkownika z programem na poziomie okna LoginPage
     * 
     * @param e reprezentuje rodzaj działania użytkownika
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource()==resetButton)
        {
            userIDField.setText("");
            userPasswordField.setText("");
            
        }
        
        if(e.getSource()==loginButton)
        {   
            String userID=userIDField.getText();
            String password=String.valueOf(userPasswordField.getPassword());

            if(logPas.containsKey(userID))
            {
                if(logPas.get(userID).equals(password))
                {
                                                          
                    frame.dispose(); 
                    WelcomePage welcomePage = new WelcomePage();
                    
                    if(patients.containsKey(userID)) {
                         if(file.exists()) {
                             try {
                                for (Map.Entry<String, List> entry : patients.entrySet()) {
                                BufferedWriter bw = new BufferedWriter(new FileWriter(file.getAbsolutePath()));
                                List tmp = patients.get(userID);
                                String pacjent = String.join(", ", tmp);
                                bw.write(userID + ", ");
                                bw.write(pacjent);
                                bw.newLine();
                                bw.close();
                                }
                             } catch (IOException exception) {
                                 exception.printStackTrace();
                             }
                        }
                    }
                }
                
                else
                {
                    messageLabel.setForeground(Color.red);
                    messageLabel.setFont(new Font(null, Font.ITALIC, 15));
                    messageLabel.setText("<html>Nieprawidłowe hasło. <br/> Spróbuj ponownie.</html>");
                }
            }
            else
            {
                messageLabel.setForeground(Color.red);
                messageLabel.setFont(new Font(null, Font.ITALIC, 15));
                
                messageLabel.setText("<html>Taki użytkownik nie istnieje. <br/> Spróbuj ponownie.</html>");
            }
        }
        
        if (e.getSource() == registrationButton)
        {
            frame.dispose(); 
            NewAccount newaccount = new NewAccount();
        }
    }   
}
