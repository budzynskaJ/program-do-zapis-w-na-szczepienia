/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.io.File;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * Klasa reprezentujaca pacjenta
 * 
 * 
 * @author aleks
 */
public class Account {

    String name;
    String surname;
    String pesel;
    String number;
    String address;
    String postcode;
    String city;
    String password;
    
    
    HashMap<String, List> patients = new HashMap<String, List>();
    HashMap<String, String> logPas = new HashMap<String, String>();
        
    
    /**
    * Konstruktor klasy Acconut 
    */
    Account() {
    }
    
    
    /**
     * Konstruktor z parametrami klasy Acconut
     * 
     * @param pes reprezentuje pesel pacjenta
     * @param n reprezentuje imie pacjenta
     * @param s reprezentuje nazwisko pacjenta
     * @param num reprezentuje numer telefonu pacjenta
     * @param ad reprezentuje adres zamieszkania pacjenta
     * @param pc reprezentuje kod pocztowy adresu pacjenta
     * @param c reprezentuje miasto zamieszkania pacjenta
     * @param pas reprezentuje haslo dostepu do konta pacjenta
     */
    Account(String pes, String n, String s, String num, String ad, String pc, String c, String pas) {
        this.name = n;
        this.surname = s;
        this.pesel = pes;
        this.number = num;
        this.address = ad;
        this.postcode = pc;
        this.city = c;
        this.password = pas;

    }
    
    
    /**
     * Metoda zapisujaca dane pacjenta do pliku bedacego baza danych (accounts.txt)
     * 
     * @throws IOException obsluguje wyjatek operacji wyjscia
     */
    void SavingAccount() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("accounts.txt", true));
        writer.append("Pacjent:\t");
        writer.append(this.pesel + "\t");
        writer.append(this.name + "\t");
        writer.append(this.surname + "\t");
        writer.append(this.number + "\t");
        writer.append(this.address + "\t");
        writer.append(this.postcode + "\t");
        writer.append(this.city + "\t");
        writer.append(this.password + "\t\n");
        writer.close();
    }
    
    /** 
     * Metoda zapisujaca dane wszytskich pacjentow z bazy danych w postaci 
     * pliku tekstowego do HashMap, której kluczem jest numer pesel
     * 
     * @throws IOException obsługuje wyjątek operacji wejścia
     */

    void AccountMap() throws IOException {
        ArrayList<String> patient = new ArrayList<>();
        
        try (Scanner sc = new Scanner(new File("accounts.txt")).useDelimiter("\t")) {
             while (sc.hasNext()) {
                    patient.add(sc.next());
             } 
        }
        
        int size = patient.size();
        
        for (int j = 9; j<size-9; j = j+9) {
            ArrayList<String> tmplist = new ArrayList<>();
            String key = " ";
            String pass = " ";
            for (int i = j; i<=j+8; i++) {
                if(i==j) {
                    String tmp = patient.get(i);
                }
                else if (i==j+1) {
                    key = patient.get(i);
                }
                
                else {
                    tmplist.add(patient.get(i));
                    if (i == j+8){
                        pass = patient.get(i);
                    }
                }
            }
            patients.put(key, tmplist);
            logPas.put(key, pass);
        }
        
        System.out.println(patients);  
    }
    
    
    /**
     * Metoda udzielajaca dostepu do kluczy i wartosci HashMapy logPas
     * 
     * @return zwraca mape zawierajaca pesele (loginy) i hasla pacjentow
     */
    protected HashMap getLogPas()
    {
        return logPas;
    }
    
    /**
     * Metoda udzielajaca dostepu do kluczy i wartosci HashMapy patients
     * 
     * @return zwraca mape zawierajaca dane osobowe pacjentow
     */
    protected HashMap getPatients() {
        return patients;
    }
}
