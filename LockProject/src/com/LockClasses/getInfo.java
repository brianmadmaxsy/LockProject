/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LockClasses;
import java.util.*;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * @author brianmadmaxsy
 */
public class getInfo{
    
    public String ipAddress;
    
    public void getIP()
    {
        try
        {
            InetAddress IP=InetAddress.getLocalHost();
            this.ipAddress=IP.toString();
        
        } 
        catch (UnknownHostException ex) 
        {
            System.out.println("Error in getIP()");
        }
    }
    public void getuserid()
    {
        
    }
}
