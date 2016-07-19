/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LockClasses;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author brianmadmaxsy
 */
public class main {
    public static void main(String args[]) throws Exception
    {
        /*
        String userid="";
        HideFile hide = new HideFile();
        userid=hide.seekUserid();
        
        System.out.println(userid);
         * 
         */
        String facebook = "127.0.0.1 www.facebook.com";
        try
        {
            String loc="C://Windows/System32/drivers/etc";
            RandomAccessFile raf = new RandomAccessFile(loc, "rw");

            // write something in the file
            raf.writeUTF(facebook);
            
        }
        catch(IOException io)
        {
            System.out.print(io);
        }
    }

    
}
