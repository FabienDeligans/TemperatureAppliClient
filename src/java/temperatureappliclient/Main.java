/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temperatureappliclient;

import conv.ConvertirRemote;
import java.util.Scanner;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Admin
 */
public class Main {

    private static ConvertirRemote convertir; 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            Context ctx = new InitialContext(); 
            convertir = (ConvertirRemote)ctx.lookup("java:global/TemperatureAppli-ejb/Convertir"); 
            menu(); 
            
        } catch (NamingException ne) {
            System.out.println(ne.getMessage());
        }

    }
    
    public static void menu() {
        Scanner sc = new Scanner(System.in); 
        int choix; 
        double temp; 
        
        System.out.println("Choisir la convertion");
        System.out.println("1 = F -> C ");
        System.out.println("2 = C -> F ");
        choix = sc.nextInt(); 
        
        System.out.println("Choisir la valeur à convertir : ");
        temp = sc.nextDouble(); 
        
        switch (choix){
            case 1:
                temp = convertir.convertirFahrenheitToCelcius(temp); 
                break; 
            case 2 : 
                temp = convertir.convertirCelciusToFahrenheit(temp); 
                break; 
        }
        System.out.println(temp);
        
    }
    
}
