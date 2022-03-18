/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;


/**
 * Klasa obsługująca okno profilu pacjenta, można w niej sprawdzić kto jest 
 * akrualnie zalogowany jak również informacje o wizycie na szczepienie.
 * @author jbudz
 */

public class MyAccount implements ActionListener, WindowListener, MouseListener{
    JFrame frame = new JFrame("Mój profil");
    JButton returnButton1 = new JButton("Wróć");
    JButton returnButton2 = new JButton("Wróć");

    JTabbedPane tp = new JTabbedPane();
    
    JPanel panel1 = new JPanel();
    JPanel parentPanel1 = new JPanel();
    JPanel helpPanel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel parentPanel2 = new JPanel();
    JPanel helpPanel2 = new JPanel();
    
    JLabel namesurname = new JLabel();
    JLabel pesel = new JLabel();
    JLabel number = new JLabel();
    JLabel address = new JLabel();
    JLabel postcode = new JLabel();
    JLabel city = new JLabel();
    JLabel password = new JLabel();
    JLabel info = new JLabel();
    JLabel where = new JLabel();
    JLabel ad = new JLabel();
    JLabel helpLabel = new JLabel();
    JLabel helpLabel1 = new JLabel();
    JLabel helpLabel2 = new JLabel();
    JLabel helpLabel3 = new JLabel();
    
    JLabel p1 = new JLabel();
    JLabel p2 = new JLabel();
    JLabel p3 = new JLabel();
    JLabel p4 = new JLabel();

    JLabel h1 = new JLabel();
    JLabel h2 = new JLabel();
    JLabel h3 = new JLabel();
       
    JLabel vaccine = new JLabel();
    JLabel date = new JLabel();
    JLabel hour = new JLabel();
    
    String filename = "wirus.png";
    ImageIcon image = new ImageIcon(filename);
    String s = "  ";
      
    File file = new File("save.txt");
    File file1 = new File("zapisy.txt");
    
    /**
     * Konstruktor klasy MyAccount
     * Tworzy graficzną stronę okna
     * 
     * @throws FileNotFoundException obsługuje wyjątek nie znaleznienia pliku
     * @throws IOException obsługuje wyjątek operacji wejścia
     */
    
    MyAccount() throws FileNotFoundException, IOException
    {        
        namesurname.setFont(new Font(null, Font.ITALIC | Font.BOLD, 40));
        namesurname.setHorizontalAlignment(namesurname.CENTER);

        pesel.setFont(new Font(null, Font.ITALIC, 20));
        number.setFont(new Font(null, Font.ITALIC, 20));
        address.setFont(new Font(null, Font.ITALIC, 20));
        postcode.setFont(new Font(null, Font.ITALIC, 20));        
        city.setFont(new Font(null, Font.ITALIC, 20));        
        password.setBounds(50, 250, 300, 30);
        password.setFont(new Font(null, Font.ITALIC, 20));   
               
        vaccine.setFont(new Font(null, Font.ITALIC, 18));
        date.setFont(new Font(null, Font.ITALIC, 18));
        hour.setFont(new Font(null, Font.ITALIC, 18));
              
        where.setFont(new Font(null, Font.ITALIC, 18));
        ad.setFont(new Font(null, Font.ITALIC, 18));
        
        frame.setResizable(false);
        frame.getContentPane().setBackground(new Color (176, 196, 222));
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
        

        returnButton1.setFocusable(false);
        returnButton1.setForeground(Color.black);
        returnButton1.setBackground(new Color(252, 179, 179));  
        returnButton1.setForeground(Color.white);
        returnButton1.setFont(new Font(null, Font.BOLD, 16));
        returnButton1.addActionListener(this);
        returnButton1.setVisible(true);
        
        returnButton2.setFocusable(false);
        returnButton2.setForeground(Color.black);
        returnButton2.setBackground(new Color(252, 179, 179));  
        returnButton2.setForeground(Color.white);
        returnButton2.setFont(new Font(null, Font.BOLD, 16));
        returnButton2.addActionListener(this);
        returnButton2.setVisible(true);
                
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
        panel1.setBackground(new Color(229, 244, 252));
        
        p1.setText(s);
        p2.setText(s);
        p3.setText(s);
        p4.setText(s);
           
        panel1.add(p1);
        p1.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel1.add(p2);
        p2.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel1.add(pesel);
        pesel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel1.add(p3);
        p3.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel1.add(number);
        number.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel1.add(p4);
        p4.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel1.add(address);
        address.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel1.add(postcode);
        postcode.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel1.add(city);
        city.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        helpLabel.setText(" ");
        helpLabel1.setText(" ");
        helpLabel2.setText(" ");
        helpLabel3.setText(" ");
                
        helpPanel1.setLayout(new GridLayout(1, 3));
        helpPanel1.setBackground(new Color (229, 244, 252));
        helpPanel1.add(helpLabel);
        helpPanel1.add(returnButton1);
        helpPanel1.add(helpLabel1);
        
        parentPanel1.setBackground(new Color (229, 244, 252));
        parentPanel1.setLayout(new BorderLayout());
        parentPanel1.add(namesurname, BorderLayout.PAGE_START);
        parentPanel1.add(panel1, BorderLayout.CENTER);
        parentPanel1.add(helpPanel1, BorderLayout.SOUTH);
        
        
        info.setText("Twoje szczepienie:");
        info.setFont(new Font(null, Font.BOLD | Font.ITALIC, 35));
        info.setHorizontalAlignment(info.CENTER);
             
        h1.setText(s);
        h2.setText(s);
        h3.setText(s);    
        
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
        panel2.setBackground(new Color(229, 244, 252));
        panel2.add(h1);
        h1.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel2.add(h2);
        h2.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel2.add(vaccine);
        vaccine.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel2.add(date);
        date.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel2.add(hour);
        hour.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel2.add(h3);
        h3.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel2.add(where);
        where.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel2.add(ad);
        ad.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        helpPanel2.setLayout(new GridLayout(1, 3));
        helpPanel2.setBackground(new Color (229, 244, 252));
        helpPanel2.add(helpLabel2);
        helpPanel2.add(returnButton2);
        helpPanel2.add(helpLabel3);
        
        parentPanel2.setBackground(new Color(229, 244, 252));
        parentPanel2.setLayout(new BorderLayout());
        parentPanel2.add(info, BorderLayout.NORTH);
        parentPanel2.add(panel2, BorderLayout.CENTER);
        parentPanel2.add(helpPanel2, BorderLayout.SOUTH);
                
        tp.setTabPlacement(JTabbedPane.TOP);
        tp.setBounds(0, 0, 500, 465);
        tp.addTab("Dane", parentPanel1);
        tp.addTab("Szczepienia", parentPanel2);
        tp.setVisible(true);
        tp.addMouseListener(this);
                
  
        frame.add(tp);
        frame.addWindowListener(this);
        
        data();
    }

    /**
     * Metoda pobierająca dane o aktualnie zalogowanym kliencie. Pobiera 
     * jego dane osobowe oraz informacje o umówionych wizytach, oraz
     * wypisuje je w odpowiednich miejscach wyznaczonych przez konstruktor
     * klasy.
     * Dane pobierane są z pliku save.txt (dane osobowe) oraz z zapisy.txt
     * (dane o wizycie).
     */
    public void data(){
            
        if (file.exists()){
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line;
                                    
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split(", ");
                    String PESEL = parts[0];
                    String imie = parts[1];
                    String nazwisko = parts[2];
                    String telefon = parts[3];
                    String adres = parts[4];
                    String kod = parts[5];
                    String miasto = parts[6];
                   
                    
                    namesurname.setText(imie + " " + nazwisko);

                    pesel.setText("PESEL: " + PESEL);
                    number.setText("Nr tel: " + telefon);
                    address.setText("Ulica:  " + adres);
                    postcode.setText("Kod:  " + kod);
                    city.setText("Miasto:  " + miasto);
                      
                    if(file1.exists())
                    {
                        try{
                            BufferedReader br1 = new BufferedReader(new FileReader(file1));
                            String line1;
                            line1 = br1.readLine();
                            while(line1 != null){
                                
                                String[] parts1 = line1.split("  ");
                                String PESEL1 = parts1[0];
                                String szczepionka = parts1[8];
                                String data = parts1[9];
                                String godzina = parts1[10];
                                                               
                                if(PESEL1.equals(PESEL)){
                                    vaccine.setText("Szczepionka: " + szczepionka);
                                    date.setText("dzień: " + data);
                                    hour.setText("godzina: " + godzina);
                                    
                                    if (szczepionka.equals("Moderna")){
                                        where.setText("Placówka: przychodnia Rekol-Med,");
                                        ad.setText("ul. Sonaty 5, Warszawa");
                                    }
                                    else if (szczepionka.equals("Pfizer")){
                                        where.setText("Placówka: Punkt Szczepień Powszechnych,");
                                        ad.setText("ul. M.Ossowskiego 25, Warszawa");
                                    }
                                    else if (szczepionka.equals("Astra Zeneca")){
                                        where.setText("Placówka: CM Medycyna Rodzinna,");
                                        ad.setText("ul. Wrocławska 7A, Warszawa");
                                    }
                                    else if (szczepionka.equals("Johnson & Johnson")){
                                        where.setText("Placówka: przychodnia Wilanów,");
                                        ad.setText("ul. Sarmacka 10, Warszawa");
                                    }
                                    
                                }
                                line1 = br1.readLine();
                                
                                

                            }
                            br1.close();
                        }catch (IOException exception){
                            exception.printStackTrace();
                        }
                    
                    }                   
                }
                br.close();
            }catch (IOException exception)
            {
                exception.printStackTrace();
            }

        }    
        
    }
    /**
     * Metoda obsługująca zdarzenia kliknięcia przycisku "Wróć" w obydwu
     * zakładkach okna MyAccount.
     * Po naciśnięciu przycisku "Wróć" okno "Mój profil" zamyka się, wracamy do
     * poprzedniego okna.
     * 
     * @param e reprezentuje działanie użytkownika
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == returnButton1)
        {
            frame.dispose();
        }
        else if (e.getSource() == returnButton2) {
            frame.dispose();
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
     * 
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


    /**
     * Metoda śledząca kliknięcia myszką. Jeśli klikniemy w obszar zakładki
     * "Dane" (w lewym górnym rogu okna) zostajemy do niego przeniesieni,
     * analogicznie z zakładką "Szczepienia".
     * @param me reprezentuje działanie użytkownika
     */
    @Override
    public void mouseClicked(MouseEvent me) {
        if(me.getSource() == parentPanel1)
        {
            parentPanel1.setVisible(true);
            parentPanel2.setVisible(false);
        }
        else{
            parentPanel2.setVisible(true);
            parentPanel1.setVisible(false);
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent me) {
       //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  

}
    
