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
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.io.FileNotFoundException;


/**
 * Klasa obsługująca okno tworzenia nowego konta w programie
 * 
 * @author jbudz
 */
public class NewAccount implements ActionListener {
    
    JFrame frame = new JFrame();
    JTextField nameField = new JTextField();
    JTextField surnameField = new JTextField();
    JTextField peselField = new JTextField();
    JTextField numberField = new JTextField();
    JTextField addressField = new JTextField();
    JTextField postcodeField1 = new JTextField();
    JTextField postcodeField2 = new JTextField();
    JTextField cityField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JPasswordField passField = new JPasswordField();
    JLabel nameLabel = new JLabel("Imie: ");
    JLabel surnameLabel = new JLabel("Nazwisko: ");
    JLabel peselLabel = new JLabel("PESEL: ");
    JLabel numberLabel = new JLabel("Nr telefonu:");
    JLabel addressLabel = new JLabel("Ulica, nr domu/nr mieszkania: ");
    JLabel postcodeLabel = new JLabel("Kod pocztowy: ");
    JLabel postcodeLabel1 = new JLabel("-");
    JLabel cityLabel = new JLabel("Miasto: ");    
    JLabel passwordLabel = new JLabel("Hasło: ");
    JLabel passLabel = new JLabel("Potwierdź: "); 
    JLabel titleLabel = new JLabel("Uzupełnij formularz");
    JLabel messageLabel = new JLabel();
    JButton registerButton = new JButton("Rejestruj");
    String fileName = "wirus.png";
    
    File file = new File("save.txt");
    File file1 = new File("accounts.txt");

    ImageIcon image = new ImageIcon(fileName);

    
    /**
     * Konstruktor klasy NewAccount
     * Tworzy graficzna strone okna
     */
    NewAccount() {
        titleLabel.setBounds(200, 15, 200, 30);
        titleLabel.setFont(new Font(null, Font.ROMAN_BASELINE, 22));
        
        nameLabel.setBounds(15, 75, 100, 30);
        nameLabel.setFont(new Font(null, Font.ROMAN_BASELINE, 20));
        
        surnameLabel.setBounds(250, 75, 100, 30);
        surnameLabel.setFont(new Font(null, Font.ROMAN_BASELINE, 20));
        
        peselLabel.setBounds(15, 130, 125, 30);
        peselLabel.setFont(new Font(null, Font.ROMAN_BASELINE, 20));
        
        numberLabel.setBounds(250, 130, 125, 30);
        numberLabel.setFont(new Font(null, Font.ROMAN_BASELINE, 20));
        
        addressLabel.setBounds(15, 185, 275, 30);
        addressLabel.setFont(new Font(null, Font.ROMAN_BASELINE, 20));
        
        postcodeLabel.setBounds(15, 240, 200, 30); 
        postcodeLabel.setFont(new Font(null, Font.ROMAN_BASELINE, 20));
        
        postcodeLabel1.setBounds(180, 240, 10, 30);
        postcodeLabel1.setFont(new Font(null, Font.ROMAN_BASELINE, 20));
        
        cityLabel.setBounds(250, 240, 100, 30);
        cityLabel.setFont(new Font(null, Font.ROMAN_BASELINE, 20));
        
        passwordLabel.setBounds(15, 295, 150, 30);
        passwordLabel.setFont(new Font(null, Font.ROMAN_BASELINE, 20));
        
        passLabel.setBounds(250, 295, 200, 30);
        passLabel.setFont(new Font(null, Font.ROMAN_BASELINE, 20));
        
        messageLabel.setBounds(170, 350, 300, 30);
        messageLabel.setFont(new Font(null, Font.ROMAN_BASELINE, 16));
        messageLabel.setForeground(Color.red);
        
        nameField.setBounds(75, 75, 155, 30);
        nameField.setFont(new Font(null, Font.ROMAN_BASELINE, 20));
        
        surnameField.setBounds(350, 75, 200, 30);
        surnameField.setFont(new Font(null, Font.ROMAN_BASELINE, 20));
                
        peselField.setBounds(100, 130, 130, 30);
        peselField.setFont(new Font(null, Font.ROMAN_BASELINE, 20));
        
        numberField.setBounds(360, 130, 190, 30);
        numberField.setFont(new Font(null, Font.ROMAN_BASELINE, 20));
        
        addressField.setBounds(290, 185, 260, 30);
        addressField.setFont(new Font(null, Font.ROMAN_BASELINE, 20));
        
        postcodeField1.setBounds(150, 240, 30, 30); //80
        postcodeField1.setFont(new Font(null, Font.ROMAN_BASELINE, 20));
        postcodeField2.setBounds(190, 240, 45, 30);
        postcodeField2.setFont(new Font(null, Font.ROMAN_BASELINE, 20));
        
        cityField.setBounds(330, 240, 220, 30);
        cityField.setFont(new Font(null, Font.ROMAN_BASELINE, 20));
               
        passwordField.setBounds(80, 295, 150, 30);
        passwordField.setFont(new Font(null, Font.ROMAN_BASELINE, 20));        
        
        passField.setBounds(350, 295, 200, 30);
        passField.setFont(new Font(null, Font.ROMAN_BASELINE, 20));
               
        registerButton.setBounds(210, 400, 150, 40);
        registerButton.setFocusable(false);
        registerButton.addActionListener(this);
        registerButton.setBackground(new Color(252, 179, 179));  
        registerButton.setForeground(Color.white);
        registerButton.setFont(new Font(null, Font.BOLD, 16));
        
        try {
            frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("wirus_miniaturka.png")))));
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
                        
        frame.setTitle("Załóż konto");
        frame.setResizable(false);
        frame.getContentPane().setBackground(new Color(176, 196, 222));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(570, 500);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        
        frame.add(nameLabel);
        frame.add(surnameLabel);
        frame.add(peselLabel);
        frame.add(numberLabel);
        frame.add(addressLabel);
        frame.add(postcodeLabel);
        frame.add(cityLabel);
        frame.add(passwordLabel);
        frame.add(passLabel);
        frame.add(titleLabel);
        frame.add(messageLabel);
        frame.add(registerButton);
        frame.add(nameField);
        frame.add(surnameField);
        frame.add(peselField);
        frame.add(numberField);
        frame.add(addressField);
        frame.add(postcodeField1);
        frame.add(postcodeField2);
        frame.add(postcodeLabel1);
        frame.add(cityField);
        frame.add(passwordField);
        frame.add(passField);
        frame.setIconImage(image.getImage());
        
                
    }   
    
    /**
     * Metoda zapisująca dane nowo zarejestrowanego użytkownika
     * do pliku save.txt, który przetrzymuje dane o aktualnie zalogowanym
     * pacjencie.
     * 
     * @throws IOException obsługije wyjątek operacji wejścia
     */
        public void save() throws IOException 
    {
        try
        {
            if(file.exists())
            {
                String pc1 = postcodeField1.getText();
                String pc2 = postcodeField2.getText();
        
                BufferedWriter bw = new BufferedWriter(new FileWriter(file.getAbsolutePath()));
                bw.write(peselField.getText() + ", ");
                bw.write(nameField.getText() + ", ");
                bw.write(surnameField.getText() + ", ");
                bw.write(numberField.getText() + ", ");
                bw.write(addressField.getText() + ", ");
                bw.write(pc1 + "-" + pc2 + ", ");
                bw.write(cityField.getText() + ", ");
                bw.write(passwordField.getPassword());
                bw.close();
            }
            
        } catch(IOException e){e.printStackTrace();}
    }
        

   
    /**
     * Metoda obsługująca interakcje użytkownika z programem na poziomie okna NewAccount
     * 
     * @param e reprezentuje rodzaj działania użytkownika
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == registerButton) {
             String tmp = "ok";
             ArrayList<String> pesele = new ArrayList<>();
            
            String pc1 = postcodeField1.getText();
            String pc2 = postcodeField2.getText();
            String userPostcode = pc1 + "-" + pc2;
                        
            String userName = nameField.getText();
            String userSurname = surnameField.getText();
            String userPesel = peselField.getText();
            String userNumber = numberField.getText();
            String userAddress = addressField.getText();
            String userPostcode1 = pc1 + pc2;
            String userCity = cityField.getText();
            String userPassword = String.valueOf(passwordField.getPassword());
            String userPass = String.valueOf(passField.getPassword());
            
                    
            try {
                BufferedReader br = new BufferedReader(new FileReader(file1));
                String line;
                while ((line = br.readLine()) != null){
                               String[] p = line.split("\t");
                               String pes = p[1];
                               System.out.println(pes);
                               pesele.add(pes);
                }

            } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
            } catch (IOException ex2) {
                    ex2.printStackTrace();
            }
                 
        for (int i = 0; i<pesele.size(); i++) {
            if (userPesel.equals(pesele.get(i))) {
                tmp = "wrongPes";
                break;
            }
        } 
        
        if(tmp == "wrongPes") {
            messageLabel.setText("Użytkownik o takim peselu juz istnieje!");
        } 
                             
        else if(userName.length()== 0 || userSurname.length() == 0 || userPesel.length() == 0 || userNumber.length() == 0 || userAddress.length() == 0 || userPostcode1.length() == 0 || userCity.length() == 0 || userPassword.length() == 0)
        {
            messageLabel.setText("Pola nie mogą być puste!");
            
        }
        else if (userName.matches("[0-9]+") == true || userSurname.matches("[0-9]+") == true)
        {
            messageLabel.setText("Twoja godność nie może zawierać cyfr!");
        }
        else if (userPesel.length() != 11)
        {
            messageLabel.setText("Nieprawidłowa długość nr PESEL!");
        }
        else if(userPesel.matches("[0-9]+") == false)
        {
            messageLabel.setText("PESEL nie może zawierać liter!");
        }
        else if(userNumber.length() != 9)
        {
            messageLabel.setText("Nieprawdiłowa długość nr telefonu!");
        }
        else if(userNumber.matches("[0-9]+") == false)
        {
            messageLabel.setText("Nr telefonu nie może zawierać liter!");
        }
        else if (userPostcode1.length() != 5)
        {
            messageLabel.setText("Nieprawidłowa długość kodu pocztowego!");
        }
       
        else if (userPostcode1.matches("[0-9]+") == false)
        {
           messageLabel.setText("Nieprawidłowy kod pocztowy!");
        }
        else if (userPassword.length()<5)
        {
            messageLabel.setText("Zbyt krótkie hasło!");
        }
        else if(!userPassword.equals(userPass)) 
        {
            messageLabel.setText("Podane hasła różnią się!");
        }

        else if(userPassword.equals(userPass))
        {
            frame.dispose();
            Registration action = new Registration();


            try {
                save();
            } catch (IOException ex) {
                Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
                }
            Account account = new Account(userPesel, userName, userSurname, userNumber, userAddress, userPostcode, userCity, userPassword);

            try {
                account.SavingAccount();
                account.AccountMap();
            }catch (IOException exc) {
                exc.printStackTrace();
            } 
        }
       
    }
  }
}