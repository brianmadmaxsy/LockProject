/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LockClasses;

/**
 *
 * @author brianmadmaxsy
 */
import java.io.RandomAccessFile;
import java.io.IOException;
public class Hidden {
    public void setHiddenData(String username,String loc)
    {
        try
        {
            //String loc="C://ProgramData/lock_setup_temp.txt";
            RandomAccessFile raf = new RandomAccessFile(loc, "rw");

            // write something in the file
            raf.writeUTF(username);
            
        }
        catch(IOException io)
        {
            System.out.print(io);
        }
    }
    public String seekHiddenData(String loc)
    {
        try
        {
            //String loc="C://ProgramData/lock_setup_temp.txt";
            String username;
            RandomAccessFile raf = new RandomAccessFile(loc, "rw");
            // set the file pointer at 0 position
            raf.seek(0);
            // read and print the contents of the file
            username=raf.readUTF();

            return username;
        }
        catch(IOException io)
        {
            return "";
        }
    }
}
