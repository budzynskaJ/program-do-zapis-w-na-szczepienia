/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.util.ArrayList; 
import java.util.List;


/**
 * Klasa obsługująca okno wyboru terminu szczepienia
 * 
 * @author jbudz
 */
public class WhichVaccine implements ActionListener, ItemListener{
    
    int licznik = 0;
    
    JFrame frame = new JFrame();
    JLabel choice = new JLabel("Szczepionka:");
    JLabel messageLabel = new JLabel();
    JLabel msg = new JLabel();
    JButton returnButton = new JButton("Wróć");
    JButton logout = new JButton("Wyloguj się");
    String fileName = "wirus.png";
    ImageIcon image = new ImageIcon(fileName);
        
    Choice vaccine = new Choice();
    File file = new File("save.txt");
    File file2 = new File ("zapisy.txt");
    String whichVaccine;
    String day;
    String time;
    
    JLabel calendar = new JLabel("Kalendarz");
    JLabel pon = new JLabel("Pon");
    JLabel wt = new JLabel("Wt");
    JLabel sr = new JLabel("Śr");
    JLabel czw = new JLabel("Czw");
    JLabel pt = new JLabel("Pt");
    JLabel sob = new JLabel("Sob");
    JLabel nd = new JLabel("Nd");
   
    
    JButton pon1 = new JButton("10:00");
    JButton pon2 = new JButton("10:15");
    JButton pon3 = new JButton("10:30");
    JButton pon4 = new JButton("10:45");
    JButton pon5 = new JButton("11:00");
    
    JButton wt1 = new JButton("10:00");
    JButton wt2 = new JButton("10:15");
    JButton wt3 = new JButton("10:30");
    JButton wt4 = new JButton("10:45");
    JButton wt5 = new JButton("11:00");
    
    JButton sr1 = new JButton("10:00");
    JButton sr2 = new JButton("10:15");
    JButton sr3 = new JButton("10:30");
    JButton sr4 = new JButton("10:45");
    JButton sr5 = new JButton("11:00");
    
    JButton czw1 = new JButton("10:00");
    JButton czw2 = new JButton("10:15");
    JButton czw3 = new JButton("10:30");
    JButton czw4 = new JButton("10:45");
    JButton czw5 = new JButton("11:00");
    
    JButton pt1 = new JButton("10:00");
    JButton pt2 = new JButton("10:15");
    JButton pt3 = new JButton("10:30");
    JButton pt4 = new JButton("10:45");
    JButton pt5 = new JButton("11:00");
    
    JButton sob1 = new JButton("10:00");
    JButton sob2 = new JButton("10:15");
    JButton sob3 = new JButton("10:30");
    JButton sob4 = new JButton("10:45");
    JButton sob5 = new JButton("11:00");
    
    JButton nd1 = new JButton("10:00");
    JButton nd2 = new JButton("10:15");
    JButton nd3 = new JButton("10:30");
    JButton nd4 = new JButton("10:45");
    JButton nd5 = new JButton("11:00");
            
    JButton ponb[] = new JButton[5];
    JButton wtb[] = new JButton[5];
    JButton srb[] = new JButton[5];
    JButton czwb[] = new JButton[5];
    JButton ptb[] = new JButton[5];
    JButton sobb[] = new JButton[5];
    JButton ndb[] = new JButton[5];
    
    
    HashMap <String, Integer> aHour = new HashMap <String, Integer>();
    HashMap <String, HashMap <String,Integer>> aCalendar = new HashMap <String, HashMap<String, Integer>>();
    
    HashMap <String, Integer> jHour = new HashMap <String, Integer>();
    HashMap <String, HashMap <String,Integer>> jCalendar = new HashMap <String, HashMap<String, Integer>>();
    
    HashMap <String, Integer> mHour = new HashMap <String, Integer>();
    HashMap <String, HashMap <String,Integer>> mCalendar = new HashMap <String, HashMap<String, Integer>>();
    
    HashMap <String, Integer> pHour = new HashMap <String, Integer>();
    HashMap <String, HashMap <String,Integer>> pCalendar = new HashMap <String, HashMap<String, Integer>>();
    
    
    List<String> mponList = new ArrayList<String>();
    List<String> mwtList = new ArrayList<String>();
    List<String> msrList = new ArrayList<String>();
    List<String> mczwList = new ArrayList<String>();
    List<String> mptList = new ArrayList<String>();
    List<String> msobList = new ArrayList<String>();
    List<String> mndList = new ArrayList<String>();
    
    List<String> aponList = new ArrayList<String>();
    List<String> awtList = new ArrayList<String>();
    List<String> asrList = new ArrayList<String>();
    List<String> aczwList = new ArrayList<String>();
    List<String> aptList = new ArrayList<String>();
    List<String> asobList = new ArrayList<String>();
    List<String> andList = new ArrayList<String>();
    
    List<String> pponList = new ArrayList<String>();
    List<String> pwtList = new ArrayList<String>();
    List<String> psrList = new ArrayList<String>();
    List<String> pczwList = new ArrayList<String>();
    List<String> pptList = new ArrayList<String>();
    List<String> psobList = new ArrayList<String>();
    List<String> pndList = new ArrayList<String>();
    
    List<String> jponList = new ArrayList<String>();
    List<String> jwtList = new ArrayList<String>();
    List<String> jsrList = new ArrayList<String>();
    List<String> jczwList = new ArrayList<String>();
    List<String> jptList = new ArrayList<String>();
    List<String> jsobList = new ArrayList<String>();
    List<String> jndList = new ArrayList<String>();
    
    
    /**
     * Konstruktor klasy WhichVaccine
     * Tworzy graficzną stronę okna
     */
    WhichVaccine()
    {
        frame.setTitle("Którą szczepionką chcesz się zaszczepić?");
        frame.setResizable(false);
        frame.getContentPane().setBackground(new Color (176, 196, 222));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(560, 500);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        choice.setBounds(75, 20, 120, 40);
        choice.setFont(new Font(null, Font.ROMAN_BASELINE, 20));

        returnButton.setBounds(200,400,150,40);
        returnButton.setFocusable(false);
        returnButton.setForeground(Color.black);
        returnButton.setBackground(new Color(252, 179, 179));  
        returnButton.setForeground(Color.white);
        returnButton.setFont(new Font(null, Font.BOLD, 16));
        returnButton.addActionListener(this);

        logout.setBounds(425, 15, 98, 15);
        logout.setFocusable(false);
        logout.addActionListener(this);
        logout.setBackground(Color.white);
        logout.setForeground(Color.black);
        logout.setFont(new Font(null, Font.ITALIC, 12));

        vaccine.setBounds(195, 30, 150, 50);
        vaccine.setBackground(Color.WHITE);
        vaccine.setVisible(true);
        vaccine.setFocusable(false);
        vaccine.add(" ");
        vaccine.add("Moderna");
        vaccine.add("Pfizer");
        vaccine.add("Astra Zeneca");
        vaccine.add("Johnson & Johnson");
        vaccine.addItemListener(this);

        messageLabel.setBounds(30, 50, 500, 80);
        messageLabel.setFont(new Font(null, Font.ITALIC, 16));

        msg.setBounds(130, 90, 500, 80);
        msg.setFont(new Font(null, Font.BOLD, 20));
        msg.setForeground(new Color(208, 28, 28));


        try {
           frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("wirus_miniaturka.png")))));
        } catch (IOException e) {
        }

        
        frame.add(choice);
        frame.add(vaccine);
        frame.add(returnButton);
        frame.add(logout);
        frame.setIconImage(image.getImage());
        frame.add(messageLabel);
        frame.add(msg);

        frame.add(calendar);
        frame.add(pon);
        frame.add(wt);
        frame.add(sr);
        frame.add(czw);
        frame.add(pt);
        frame.add(sob);
        frame.add(nd);
        frame.add(pon1);
        frame.add(pon2);
        frame.add(pon3);
        frame.add(pon4);
        frame.add(pon5);
        frame.add(wt1);
        frame.add(wt2);
        frame.add(wt3);
        frame.add(wt4);
        frame.add(wt5);
        frame.add(sr1);
        frame.add(sr2);
        frame.add(sr3);
        frame.add(sr4);
        frame.add(sr5);
        frame.add(czw1);
        frame.add(czw2);
        frame.add(czw3);
        frame.add(czw4);
        frame.add(czw5);
        frame.add(pt1);
        frame.add(pt2);
        frame.add(pt3);
        frame.add(pt4);
        frame.add(pt5);
        frame.add(sob1);
        frame.add(sob2);
        frame.add(sob3);
        frame.add(sob4);
        frame.add(sob5);
        frame.add(nd1);
        frame.add(nd2);
        frame.add(nd3);
        frame.add(nd4);
        frame.add(nd5);
   }

    
    /**
     * Metoda tworząca przyciski klasy JButton odpowiadające godzinom w kalendarzu
     * rejestracji na szczepienie
     */
    public void buttons() {
       calendar.setBounds(225, 150, 150, 40);
       calendar.setFont(new Font(null, Font.ROMAN_BASELINE, 20));
       calendar.setForeground(Color.black);

       pon.setBounds(25, 180, 70, 30);
       pon.setFont(new Font(null, Font.BOLD, 20));
       pon.setForeground(new Color(148, 197, 246));
       ponb[0] = (pon1);
       ponb[1] = (pon2);
       ponb[2] = (pon3);
       ponb[3] = (pon4);
       ponb[4] = (pon5);

       ponb[0].setBounds(10, 220, 65, 22);
       ponb[1].setBounds(10, 250, 65, 22);
       ponb[2].setBounds(10, 280, 65, 22);
       ponb[3].setBounds(10, 310, 65, 22);
       ponb[4].setBounds(10, 340, 65, 22);

       for (int i=0; i< 5; i++) {
           ponb[i].setFocusable(false);
           ponb[i].setBackground(Color.white);  
           ponb[i].setForeground(Color.black);
           ponb[i].setFont(new Font(null, Font.ROMAN_BASELINE, 12));
           ponb[i].addActionListener(this);
           ponb[i].setVisible(true);
       }

       wt.setBounds(102, 180, 70, 30);
       wt.setFont(new Font(null, Font.BOLD, 20));
       wt.setForeground(new Color(148, 197, 246));
       wtb[0] = (wt1);
       wtb[1] = (wt2);
       wtb[2] = (wt3);
       wtb[3] = (wt4);
       wtb[4] = (wt5);

       wtb[0].setBounds(85, 220, 65, 22);
       wtb[1].setBounds(85, 250, 65, 22);
       wtb[2].setBounds(85, 280, 65, 22);
       wtb[3].setBounds(85, 310, 65, 22);
       wtb[4].setBounds(85, 340, 65, 22);

       for (int i=0; i< 5; i++) {
           wtb[i].setFocusable(false);
           wtb[i].setBackground(Color.white);  
           wtb[i].setForeground(Color.black);
           wtb[i].setFont(new Font(null, Font.ROMAN_BASELINE, 12));
           wtb[i].addActionListener(this);
           wtb[i].setVisible(true);
       }

       sr.setBounds(179, 180, 70, 30);
       sr.setFont(new Font(null, Font.BOLD, 20));
       sr.setForeground(new Color(148, 197, 246));
       srb[0] = (sr1);
       srb[1] = (sr2);
       srb[2] = (sr3);
       srb[3] = (sr4);
       srb[4] = (sr5);

       srb[0].setBounds(160, 220, 65, 22);
       srb[1].setBounds(160, 250, 65, 22);
       srb[2].setBounds(160, 280, 65, 22);
       srb[3].setBounds(160, 310, 65, 22);
       srb[4].setBounds(160, 340, 65, 22);

       for (int i=0; i< 5; i++) {
           srb[i].setFocusable(false);
           srb[i].setBackground(Color.white);  
           srb[i].setForeground(Color.black);
           srb[i].setFont(new Font(null, Font.ROMAN_BASELINE, 12));
           srb[i].addActionListener(this);
           srb[i].setVisible(true);
       }

       czw.setBounds(256, 180, 70, 30);
       czw.setFont(new Font(null, Font.BOLD, 20));
       czw.setForeground(new Color(148, 197, 246));
       czwb[0] = (czw1);
       czwb[1] = (czw2);
       czwb[2] = (czw3);
       czwb[3] = (czw4);
       czwb[4] = (czw5);

       czwb[0].setBounds(242, 220, 65, 22);
       czwb[1].setBounds(242, 250, 65, 22);
       czwb[2].setBounds(242, 280, 65, 22);
       czwb[3].setBounds(242, 310, 65, 22);
       czwb[4].setBounds(242, 340, 65, 22);

       for (int i=0; i< 5; i++) {
           czwb[i].setFocusable(false);
           czwb[i].setBackground(Color.white);  
           czwb[i].setForeground(Color.black);
           czwb[i].setFont(new Font(null, Font.ROMAN_BASELINE, 12));
           czwb[i].addActionListener(this);
           czwb[i].setVisible(true);
       }

       pt.setBounds(344, 180, 65, 30);
       pt.setFont(new Font(null, Font.BOLD, 20));
       pt.setForeground(new Color(148, 197, 246));
       ptb[0] = (pt1);
       ptb[1] = (pt2);
       ptb[2] = (pt3);
       ptb[3] = (pt4);
       ptb[4] = (pt5);

       ptb[0].setBounds(325, 220, 65, 22);
       ptb[1].setBounds(325, 250, 65, 22);
       ptb[2].setBounds(325, 280, 65, 22);
       ptb[3].setBounds(325, 310, 65, 22);
       ptb[4].setBounds(325, 340, 65, 22);

       for (int i=0; i< 5; i++) {
           ptb[i].setFocusable(false);
           ptb[i].setBackground(Color.white);  
           ptb[i].setForeground(Color.black);
           ptb[i].setFont(new Font(null, Font.ROMAN_BASELINE, 12));
           ptb[i].addActionListener(this);
           ptb[i].setVisible(true);
       }

       sob.setBounds(410, 180, 70, 30);
       sob.setFont(new Font(null, Font.BOLD, 20));
       sob.setForeground(new Color(252, 179, 179));
       sobb[0] = (sob1);
       sobb[1] = (sob2);
       sobb[2] = (sob3);
       sobb[3] = (sob4);
       sobb[4] = (sob5);

       sobb[0].setBounds(400, 220, 65, 22);
       sobb[1].setBounds(400, 250, 65, 22);
       sobb[2].setBounds(400, 280, 65, 22);
       sobb[3].setBounds(400, 310, 65, 22);
       sobb[4].setBounds(400, 340, 65, 22);

       for (int i=0; i< 5; i++) {
           sobb[i].setFocusable(false);
           sobb[i].setBackground(Color.white);  
           sobb[i].setForeground(Color.black);
           sobb[i].setFont(new Font(null, Font.ROMAN_BASELINE, 12));
           sobb[i].addActionListener(this);
           sobb[i].setVisible(true);
       }

       nd.setBounds(487, 180, 70, 30);
       nd.setFont(new Font(null, Font.BOLD, 20));
       nd.setForeground(new Color(252, 179, 179));
       ndb[0] = (nd1);
       ndb[1] = (nd2);
       ndb[2] = (nd3);
       ndb[3] = (nd4);
       ndb[4] = (nd5);

       ndb[0].setBounds(475, 220, 65, 22);
       ndb[1].setBounds(475, 250, 65, 22);
       ndb[2].setBounds(475, 280, 65, 22);
       ndb[3].setBounds(475, 310, 65, 22);
       ndb[4].setBounds(475, 340, 65, 22);

       for (int i=0; i< 5; i++) {
           ndb[i].setFocusable(false);
           ndb[i].setBackground(Color.white);  
           ndb[i].setForeground(Color.black);
           ndb[i].setFont(new Font(null, Font.ROMAN_BASELINE, 12));
           ndb[i].addActionListener(this);
           ndb[i].setVisible(true);
       }
       
 
                
    }

    
    /**
     * Metoda tworząca HashMapy odpowiadające dniom i godzinom w kalendarzu
     * rejestracji
     * 
     * @param vCalendar reprezentuje kalendarz odpowiadający wybranej przez
     * użytkownika szczepionce
     * @param vHour reprezentuje godziny odpowiadające kalendarzowi
     * danej szczepionki
     */
    public void calendar(HashMap vCalendar, HashMap vHour) {
       vHour.put("10:00", 0);
       vHour.put("10:15", 0);
       vHour.put("10:30", 0);
       vHour.put("10:45", 0);
       vHour.put("11:00", 0);
       System.out.println(vHour);
       vCalendar.put("poniedziałek", vHour);
       vCalendar.put("wtorek", vHour);
       vCalendar.put("środa", vHour);
       vCalendar.put("czwartek", vHour);
       vCalendar.put("piątek", vHour);
       vCalendar.put("sobota", vHour);
       vCalendar.put("niedziela", vHour);   
    }

    
    /**
     * Metoda czyta z pliku niedostępne terminy szczepień, a następnie
     * przekazuje je jako argumenty do metody update
     */
    public void cal() {
       if (file2.exists()) {
           try {
               Scanner reader = new Scanner(file2);
               while (reader.hasNextLine()) {
                   String tmp = reader.nextLine();

                   String[] parts = tmp.split("  ");
                   String szczepionka = parts[8];
                   String dzień = parts[9];
                   String godzina = parts[10];

                   System.out.println(szczepionka + ", " + dzień + ", " + godzina);

                   if (szczepionka.equals("Astra Zeneca")) {
                       update(aCalendar, aHour, dzień, godzina, szczepionka);
                   }

                   if (szczepionka.equals("Johnson & Johnson")) {
                       update(jCalendar, jHour, dzień, godzina, szczepionka);
                   }

                   if (szczepionka.equals("Pfizer")) {
                       update(pCalendar, pHour, dzień, godzina, szczepionka);
                   }

                   if (szczepionka.equals("Moderna")) {
                       update(mCalendar, mHour, dzień, godzina, szczepionka);
                   }
               }

           } catch (FileNotFoundException e2) {
               e2.printStackTrace();
           }   
       }  
    }

    
    /**
     * Metoda uzupełniająca HashMapę i aktualizująca dostępne terminy
     * 
     * @param vCalendar reprezentuje kalendarz danej szczepionki wybranej przez
     * użytkownika
     * @param vHour reprezentuje HashMapę godzin odpowiadająca danemu
     * kalendarzowi szczepionki
     * @param d reprezentuje dzień niedostępnego terminu
     * @param h reprezentuje niedostępna godzinę w danym dniu 
     * @param vac reprezentuje szczepionkę, której kalendarz jest aktualizowany
     */
    public void update(HashMap vCalendar, HashMap vHour, String d, String h, String vac) {
        
       HashMap <String, Integer> tmpHour = new HashMap <String, Integer>();

      
       tmpHour.put("10:00", 0);
       tmpHour.put("10:15", 0);
       tmpHour.put("10:30", 0);
       tmpHour.put("10:45", 0);
       tmpHour.put("11:00", 0);
       
       switch(vac) {
           case ("Moderna"):
               switch(d) {
                    case("poniedziałek"):
                        mponList.add(h);
                        for(int i =0; i<mponList.size(); i++) {
                            tmpHour.put(mponList.get(i), 1);
                        }
                        vCalendar.put(d, tmpHour);
                        break;
                    case("wtorek"):
                        mwtList.add(h);
                        for(int i =0; i<mwtList.size(); i++) {
                            tmpHour.put(mwtList.get(i), 1);
                        }
                        vCalendar.put(d, tmpHour);
                        break;
                    case("środa"):
                        msrList.add(h);
                        for(int i =0; i<msrList.size(); i++) {
                            tmpHour.put(msrList.get(i), 1);
                        }
                        vCalendar.put(d, tmpHour);
                        break;
                    case("czwartek"):
                        mczwList.add(h);
                        for(int i =0; i<mczwList.size(); i++) {
                            tmpHour.put(mczwList.get(i), 1);
                        }
                        vCalendar.put(d, tmpHour);
                        break;
                    case("piątek"):
                        mptList.add(h);
                        for(int i =0; i<mptList.size(); i++) {
                            tmpHour.put(mptList.get(i), 1);
                        }
                        vCalendar.put(d, tmpHour);
                        break;
                    case("sobota"):
                        msobList.add(h);
                        for(int i =0; i<msobList.size(); i++) {
                            tmpHour.put(msobList.get(i), 1);
                        }
                        vCalendar.put(d, tmpHour);
                        break;
                    case("niedziela"):
                        mndList.add(h);
                        for(int i =0; i<mndList.size(); i++) {
                            tmpHour.put(mndList.get(i), 1);
                        }
                        vCalendar.put(d, tmpHour);
                        break;
                }
               break;
           case("Pfizer"):
               switch(d) {
                    case("poniedziałek"):
                        pponList.add(h);
                        for(int i =0; i<pponList.size(); i++) {
                            tmpHour.put(pponList.get(i), 1);
                        }
                        vCalendar.put(d, tmpHour);
                        break;
                    case("wtorek"):
                        pwtList.add(h);
                        for(int i =0; i<pwtList.size(); i++) {
                            tmpHour.put(pwtList.get(i), 1);
                        }
                        vCalendar.put(d, tmpHour);
                        break;
                    case("środa"):
                        psrList.add(h);
                        for(int i =0; i<psrList.size(); i++) {
                            tmpHour.put(psrList.get(i), 1);
                        }
                        vCalendar.put(d, tmpHour);
                        break;
                    case("czwartek"):
                        pczwList.add(h);
                        for(int i =0; i<pczwList.size(); i++) {
                            tmpHour.put(pczwList.get(i), 1);
                        }
                        vCalendar.put(d, tmpHour);
                        break;
                    case("piątek"):
                        pptList.add(h);
                        for(int i =0; i<pptList.size(); i++) {
                            tmpHour.put(pptList.get(i), 1);
                        }
                        vCalendar.put(d, tmpHour);
                        break;
                    case("sobota"):
                        psobList.add(h);
                        for(int i =0; i<psobList.size(); i++) {
                            tmpHour.put(psobList.get(i), 1);
                        }
                        vCalendar.put(d, tmpHour);
                        break;
                    case("niedziela"):
                        pndList.add(h);
                        for(int i =0; i<pndList.size(); i++) {
                            tmpHour.put(pndList.get(i), 1);
                        }
                        vCalendar.put(d, tmpHour);
                        break;
                }
               break;
           case("Astra Zeneca"):
               switch(d) {
                    case("poniedziałek"):
                        aponList.add(h);
                        for(int i =0; i<aponList.size(); i++) {
                            tmpHour.put(aponList.get(i), 1);
                        }
                        vCalendar.put(d, tmpHour);
                        break;
                    case("wtorek"):
                        awtList.add(h);
                        for(int i =0; i<awtList.size(); i++) {
                            tmpHour.put(awtList.get(i), 1);
                        }
                        vCalendar.put(d, tmpHour);
                        break;
                    case("środa"):
                        asrList.add(h);
                        for(int i =0; i<asrList.size(); i++) {
                            tmpHour.put(asrList.get(i), 1);
                        }
                        vCalendar.put(d, tmpHour);
                        break;
                    case("czwartek"):
                        aczwList.add(h);
                        for(int i =0; i<aczwList.size(); i++) {
                            tmpHour.put(aczwList.get(i), 1);
                        }
                        vCalendar.put(d, tmpHour);
                        break;
                    case("piątek"):
                        aptList.add(h);
                        for(int i =0; i<aptList.size(); i++) {
                            tmpHour.put(aptList.get(i), 1);
                        }
                        vCalendar.put(d, tmpHour);
                        break;
                    case("sobota"):
                        asobList.add(h);
                        for(int i =0; i<asobList.size(); i++) {
                            tmpHour.put(asobList.get(i), 1);
                        }
                        vCalendar.put(d, tmpHour);
                        break;
                    case("niedziela"):
                        andList.add(h);
                        for(int i =0; i<andList.size(); i++) {
                            tmpHour.put(andList.get(i), 1);
                        }
                        vCalendar.put(d, tmpHour);
                        break;
                }
               break;
           case("Johnson & Johnson"):
               switch(d) {
                    case("poniedziałek"):
                        jponList.add(h);
                        for(int i =0; i<jponList.size(); i++) {
                            tmpHour.put(jponList.get(i), 1);
                        }
                        vCalendar.put(d, tmpHour);
                        break;
                    case("wtorek"):
                        jwtList.add(h);
                        for(int i =0; i<jwtList.size(); i++) {
                            tmpHour.put(jwtList.get(i), 1);
                        }
                        vCalendar.put(d, tmpHour);
                        break;
                    case("środa"):
                        jsrList.add(h);
                        for(int i =0; i<jsrList.size(); i++) {
                            tmpHour.put(jsrList.get(i), 1);
                        }
                        vCalendar.put(d, tmpHour);
                        break;
                    case("czwartek"):
                        jczwList.add(h);
                        for(int i =0; i<jczwList.size(); i++) {
                            tmpHour.put(jczwList.get(i), 1);
                        }
                        vCalendar.put(d, tmpHour);
                        break;
                    case("piątek"):
                        jptList.add(h);
                        for(int i =0; i<jptList.size(); i++) {
                            tmpHour.put(jptList.get(i), 1);
                        }
                        vCalendar.put(d, tmpHour);
                        break;
                    case("sobota"):
                        jsobList.add(h);
                        for(int i =0; i<jsobList.size(); i++) {
                            tmpHour.put(jsobList.get(i), 1);
                        }
                        vCalendar.put(d, tmpHour);
                        break;
                    case("niedziela"):
                        jndList.add(h);
                        for(int i =0; i<jndList.size(); i++) {
                            tmpHour.put(jndList.get(i), 1);
                        }
                        vCalendar.put(d, tmpHour);
                        break;
                }
               break;     
       }

    }

    
    /**
     * Metoda ustawiająca niedostępność przyciskom odpowiadającym zajętym terminom
     * w kalendarzu
     * 
     * @param vCalendar reprezentuje kalendarz terminów wybranej przez uzytkownika
     * szczepionki
     */
    public void available(HashMap <String, HashMap <String,Integer>> vCalendar) {
       reset();
       for (HashMap.Entry<String, HashMap <String,Integer>> entry : vCalendar.entrySet()) {
           String dzień = entry.getKey();
           HashMap <String,Integer> vHour = entry.getValue();
           for (HashMap.Entry<String, Integer> entry2 : vHour.entrySet()) {
               int tmp = entry2.getValue();

               
                   if(dzień.equals("poniedziałek")) {
                       for (int i =0; i < 5; i++ ) {
                           if (ponb[i].getText() == entry2.getKey()) {
                               if (tmp == 1) {
                                   ponb[i].setBackground(new Color(198, 198, 198));
                                   ponb[i].setEnabled(false);
                               }
                           }
                       }
                   }
                   if(dzień.equals("wtorek")) {
                       for (int i =0; i < 5; i++ ) {
                           if (wtb[i].getText() == entry2.getKey()) {
                               if (tmp == 1) {
                                   wtb[i].setBackground(new Color(198, 198, 198));
                                   wtb[i].setEnabled(false);
                               }
                           }
                       }
                   }
                   if(dzień.equals("środa")) {
                       for (int i =0; i < 5; i++ ) {
                           if (srb[i].getText() == entry2.getKey()) {
                               if (tmp == 1) {
                                   srb[i].setBackground(new Color(198, 198, 198));
                                   srb[i].setEnabled(false);
                               }
                           }
                       }
                   }
                   if(dzień.equals("czwartek")) {
                       for (int i =0; i < 5; i++ ) {
                           if (czwb[i].getText() == entry2.getKey()) {
                               if (tmp == 1) {
                                   czwb[i].setBackground(new Color(198, 198, 198));
                                   czwb[i].setEnabled(false);
                               }
                           }
                       }
                   }
                   if(dzień.equals("piątek")) {
                       for (int i =0; i < 5; i++ ) {
                           if (ptb[i].getText() == entry2.getKey()) {
                               if (tmp == 1) {
                                   ptb[i].setBackground(new Color(198, 198, 198));
                                   ptb[i].setEnabled(false);
                               }
                           }
                       }
                   }
                   if(dzień.equals("sobota")) {
                       for (int i =0; i < 5; i++ ) {
                           if (sobb[i].getText() == entry2.getKey()) {
                               if (tmp == 1) {
                                   sobb[i].setBackground(new Color(198, 198, 198));
                                   sobb[i].setEnabled(false);
                               }
                           }
                       }
                   }
                   if(dzień.equals("niedziela")) {
                       for (int i =0; i < 5; i++ ) {
                           if (ndb[i].getText() == entry2.getKey()) {
                               if (tmp == 1) {
                                   ndb[i].setBackground(new Color(198, 198, 198));
                                   ndb[i].setEnabled(false);
                               }
                           }
                       }
                   }


           }
       }
    }
    
  
    /**
     * Metoda ustawiajaca mozliwosc nacisniecia wszytskich przyciskow
     */
    public void reset() {
       for(int i = 0; i <5; i++) {
           ponb[i].setEnabled(true);
           wtb[i].setEnabled(true);
           srb[i].setEnabled(true);
           czwb[i].setEnabled(true);
           ptb[i].setEnabled(true);
           sobb[i].setEnabled(true);
           ndb[i].setEnabled(true);
       }
    }

    
    /**
     * Metoda blokujaca mozliwosc nacisnienia wszystkim przyciskom
     */
    public void block() {
       for(int i = 0; i <5; i++) {
           ponb[i].setEnabled(false);
           wtb[i].setEnabled(false);
           srb[i].setEnabled(false);
           czwb[i].setEnabled(false);
           ptb[i].setEnabled(false);
           sobb[i].setEnabled(false);
           ndb[i].setEnabled(false);
       }
       vaccine.removeItemListener(this);
    }

    
    /**
     * Metoda blokujaca wszystkim przyciskom ceche ActionListener
     */
    public void cl() {
       for(int i = 0; i <5; i++) {
           ponb[i].removeActionListener(this);
           wtb[i].removeActionListener(this);
           srb[i].removeActionListener(this);
           czwb[i].removeActionListener(this);
           ptb[i].removeActionListener(this);
           sobb[i].removeActionListener(this);
           ndb[i].removeActionListener(this);
       }
   }

    
    /**
     * Metoda zapisujaca pacjenta i wybrany przez niego termin do pliku
     * 
     * @param day reprezentuje dzien szczepienia wybrany przez pacjenta
     * @param time reprezentuje godzine szczepienia wybrana przez pacjenta
     */
    public void write(String day, String time) {
       if (file.exists()) {
           try{
               Scanner reader = new Scanner(file);
               String zdanie = reader.nextLine();

               String[] parts = zdanie.split(", ");
               String pesel = parts[0];
               String imie = parts[1];
               String nazwisko = parts[2];
               String telefon = parts[3];
               String adres = parts[4];
               String kod = parts[5];
               String miasto = parts[6];
               String haslo = parts[7];


               try {
                   BufferedReader br = new BufferedReader(new FileReader(file2));
                   String line;
                   line = br.readLine();
                   if (line == null){
                       BufferedWriter writer = new BufferedWriter(new FileWriter(file2.getAbsolutePath(), true));
                       writer.append(pesel + "  " + imie + "  " + nazwisko + "  " + telefon + "  " + adres + "  " + kod + "  " + miasto + "  " + haslo + "  " + whichVaccine + "  " + day + "  " + time + "\n");  
                       writer.close();
                   }
                   else{
                       BufferedReader br1 = new BufferedReader(new FileReader(file2));
                       String line1;
                       while ((line1 = br1.readLine()) != null){
                           String[] p = line1.split("  ");
                           String pes = p[0];

                           if (pesel.equals(pes)){
                               msg.setText("Jesteś już zapisany na wizytę!!!");
                               System.out.println(pesel + " " + pes);
                               break;
                           }
                           else {
                               msg.setText(" ");
                           }
                        }
                        
                        if (msg.getText().equals(" ")) {
                              BufferedWriter writer1 = new BufferedWriter(new FileWriter(file2.getAbsolutePath(), true));
                              msg.setText(" ");
                              writer1.append(pesel + "  " + imie + "  " + nazwisko + "  " + telefon + "  " + adres + "  " + kod + "  " + miasto + "  " + haslo + "  " + whichVaccine + "  " + day + "  " + time + "\n");
                              writer1.close();
                        }
                       br1.close();
                   }

                   br.close();                         
                   } catch (IOException exception) {
                       exception.printStackTrace();
                   }
               reader.close();
               } catch(FileNotFoundException e) {
                   e.printStackTrace();
               }
       } 
    }
    
    /**
     * Metoda odczytujaca konkretny dzien i godzine odpowiadajaca przyciskowi 
     * wybranemu przez pacjenta a nastepnie przekazuje je funkcji write
     * 
     * @param b reprezentuje przycisk wybrany przez pacjenta
     */
    public void Date(JButton b) {
       int x = b.getX();
       time = b.getText();

       switch (x) {
           case 10: {
               day = "poniedziałek";
               write(day, time);
               break;
           }
           case 85: {
               day = "wtorek";
               write(day, time);
               break;
           }
           case 160: {
               day = "środa";
               write(day, time);
               break;
           }
           case 242: {
               day = "czwartek";
               write(day, time);
               break;
           }
           case 325: {
               day = "piątek";
               write(day, time);
               break;
           }
           case 400: {
               day = "sobota";
               write(day, time);
               break;
           }
           case 475: {
               day = "niedziela";
               write(day, time);
               break;
           }

       }
       b.setBackground(new Color(148, 197, 246));
    }


    /**
     * Metoda obslugujaca interakcje uzytkownika z programem na poziomie okna WhichVaccine
     * 
     * @param e reprezentuje rodzaj dzialania uzytkownika
     */
     @Override
       public void actionPerformed(ActionEvent e) {    

           JButton button = (JButton)e.getSource();
           if(e.getSource() == returnButton)
           {
               frame.dispose();
           }
           else {
               Date(button);
               block();
           }

           if (e.getSource() == logout)
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
           else {
               String tmp_text = msg.getText();     
               if (tmp_text.equals(" ")){

                   try {
                       Appointment appointment = new Appointment(whichVaccine, day, time);
                   } catch (FileNotFoundException ex) {
                       Logger.getLogger(WhichVaccine.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               else if (tmp_text.equals("Jesteś już zapisany na wizytę!!!")) {
                   whichVaccine = null;
                   day = null;
                   time = null;

               }
           }
       }


       /**
        * Metoda obslugujaca wybory uzytkownika w liscie rozwijanej - wyboru rodzaju szczepienia
        * 
        * @param ie reprezentuje rodzaj dzialania uzytkownika
        */
       @Override
       public void itemStateChanged(ItemEvent ie) {

           if (licznik == 0) {
               buttons();
           }

           if(vaccine.getSelectedItem().matches("Moderna"))
           {
               messageLabel.setText("<html>Szczepionką "+vaccine.getSelectedItem()+ " szczepimy w przychodni Rekol-Med. <br/> Adres: Sonaty 5, Warszawa</html>");
               cl();
               buttons();
               calendar(mCalendar, mHour);
               whichVaccine = "Moderna";
               cal();
               available(mCalendar);

           }
           else if (vaccine.getSelectedItem().matches("Pfizer"))
           {
               messageLabel.setText("<html>Szczepionką "+vaccine.getSelectedItem()+ " szczepimy w Punkcie Szczepień Powszechnych. <br/> Adres: M.Ossowskiego 25, Warszawa</html>");
               cl();
               buttons();
               calendar(pCalendar, pHour);
               whichVaccine = "Pfizer";
               cal();
               available(pCalendar);

           }
           else if(vaccine.getSelectedItem().matches("Astra Zeneca"))
           {
               messageLabel.setText("<html>Szczepionką "+vaccine.getSelectedItem()+ " szczepimy w CM Medycyna Rodzinna. <br/> Adres: Wrocławska 7A, Warszawa</html>");
               cl();
               buttons();
               calendar(aCalendar, aHour);
               whichVaccine = "Astra Zeneca";
               cal();
               available(aCalendar);

           }
           else if(vaccine.getSelectedItem().matches("Johnson & Johnson"))
           {
               messageLabel.setText("<html>Szczepionką "+vaccine.getSelectedItem()+ " szczepimy w przychodni Wilanów. <br/> Adres: Sarmacka 10, Warszawa</html>");
               cl();
               buttons();
               calendar(jCalendar, jHour);
               whichVaccine = "Johnson & Johnson";
               cal();
               available(jCalendar);
           }  
           licznik++;
       } 

   }

