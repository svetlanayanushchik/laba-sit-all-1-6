/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.yanushchik;

/**
 *
 * @author Света
 */
import java.rmi.Remote;
import java.rmi.RemoteException;

import java.rmi.*;

public interface Hello extends Remote {

    Object sayHello(String CardNumber, String CardBank, String Cash) throws RemoteException;

}
