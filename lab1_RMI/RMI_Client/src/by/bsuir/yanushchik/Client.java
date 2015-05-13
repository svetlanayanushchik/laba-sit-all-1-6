/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.yanushchik;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
/**
 *
 * @author Света
 */
public class Client {
     public static void main(String... args) throws Exception {
        Registry registry = LocateRegistry.getRegistry("localhost", 2099);
       Hello service = (Hello) registry.lookup("sample/HelloService");
        String[] CardNumber = {"80203040", "56253698", "12546985", "10101010"};
        String[] CardBank = {"BPS-bank", "IDEA-bank", "Belarus-Bank", "Swis-Bank"};
        String[] Cash = {"1$", "10000000$", "0.5$", "zero!!!"};
        for (int i=0; i<CardNumber.length; i++ ) {
            
                    System.out.println(service.sayHello(CardNumber[i], CardBank[i],
                            Cash[i]));
                }
           
        
    }

}


