/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LockClasses;
import java.io.*;
import java.sql.*;

/**
 *
 * @author brianmadmaxsy
 */
public class samplegetsite {
    public static void main(String args[])
    {
        try
        {
            Model db = new Model();
            ResultSet result;
            String childid="385253ae2b2de3fb41f01251dc3710+24603ee79d83a682119053b371e690c894399a69e9f7=jeffreyang123+Child";

            result=db.getBlocklist(childid);
            
            while(result.next())
            {
                System.out.println(result.getString("website"));
            }
        }catch(Exception e)
        {
            System.out.print(e);
        }
    }
}
