/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.io.IOException;


/**
 * KLasa obsługująca działanie calego programu
 * 
 * @author jbudz
 */
public class Login {


    /**
     * Funkcja głowna programu 
     * 
     * @param args .
     * @throws IOException reprezentuje operację wyjątku wejścia
     */
    public static void main(String[] args) throws IOException {
       Account account1 = new Account();
       account1.AccountMap();
       LoginPage loginPage= new LoginPage(account1.getLogPas(),account1.getPatients());
    }
    
}
