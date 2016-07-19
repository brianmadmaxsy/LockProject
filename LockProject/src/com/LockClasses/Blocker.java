/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LockClasses;

/**
 *
 * @author brianmadmaxsy
 */



import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.sql.*;
public class Blocker 
{
    
    public void enablePermission()
    {
        try
        {
            File file = new File("C://Windows/System32/drivers/etc/hosts");

            //set write permission on file only for owner
            if (file.exists()) {
                boolean bval = file.setWritable(true); //enable
                //boolean bval = file.setWritable(false); //disable
                 //System.out.println("set the owner's write permission: "+ bval);
            } 
            else 
            {
                 System.out.println("File cannot exists: ");
            }

            //Set write permission on File for all.
            if (file.exists()) 
            {
                boolean bval = file.setWritable(true,false); //enable
                //boolean bval = file.setWritable(false,true); //disable
                //System.out.println("set the every user write permission: "+ bval);
            } 
            else 
            {
                System.out.println("File cannot exists: ");
            }
        }catch(SecurityException se)
        {
            System.out.println(se);
        }
    }
    
    public void disablePermission()
    {
        try
        {
            File file = new File("C://Windows/System32/drivers/etc/hosts");
        
            //set write permission on file only for owner
            if (file.exists()) {
                //boolean bval = file.setWritable(true); //enable
                boolean bval = file.setWritable(false); //disable
                 //System.out.println("set the owner's write permission: "+ bval);
            } else {
                 System.out.println("File cannot exists: ");
            }

            //Set write permission on File for all.
            if (file.exists()) {
                //boolean bval = file.setWritable(true,false); //enable
                boolean bval = file.setWritable(false,true); //disable
                //System.out.println("set the every user write permission: "+ bval);
            } else {
                System.out.println("File cannot exists: ");
            }


        }catch(SecurityException se)
        {
            System.out.println(se);
        }
    }
    
    public void resetHost()
    {
        try
        {
            String data = "";
    		
            File file =new File("C://Windows/System32/drivers/etc/hosts");
    		
            //if file doesnt exists, then create it
            if(!file.exists()){
    		file.createNewFile();
            }
    		
            FileWriter fileWritter = new FileWriter(file,false); //true = append file
    	    BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
                
    	    bufferWritter.write(data);
    	    bufferWritter.close();
    	    System.out.println("Done");
	        
    	}
        catch(IOException e)
        {
            e.printStackTrace();
    	}
    }
    
    public void blocksite(String website) //send an object
    {
        //BufferedWriter bw = null;
        
    	try
        {
            //String data = "127.0.0.1 www.facebook.com";
            File file =new File("C://Windows/System32/drivers/etc/hosts");
    		
            //if file doesnt exists, then create it
            if(!file.exists()){
    		file.createNewFile();
            }
    		
            //true = append file
    		
            FileWriter fileWritter = new FileWriter(file,true);
    	    BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
            
            
                //website=websites.getString("website");
                bufferWritter.write("127.0.0.1 "+website);
                bufferWritter.newLine();
                bufferWritter.close();
            
	    //System.out.println("Done");
	        
    	}
        catch(IOException e)
        {
            e.printStackTrace();
    	}
    }
    
    public void writeHost()
    {
        //BufferedWriter bw = null;
    	try
        {
            //String data = "127.0.0.1 www.porn.com";
    		
    		File file =new File("C://Windows/System32/drivers/etc/hosts");
    		
    		//if file doesnt exists, then create it
    		if(!file.exists()){
    			file.createNewFile();
    		}
    		
    		//true = append file
    		
                FileWriter fileWritter = new FileWriter(file,true);
    	        BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
                
    	        bufferWritter.write("# Copyright (c) 1993-2009 Microsoft Corp.");
                bufferWritter.newLine();
                bufferWritter.write("#");
                bufferWritter.newLine();
                bufferWritter.write("# This is a sample HOSTS file used by Microsoft TCP/IP for Windows.");
                bufferWritter.newLine();
                bufferWritter.write("#");
                bufferWritter.newLine();
                bufferWritter.write("# This file contains the mappings of IP addresses to host names. Each");
                bufferWritter.newLine();
                bufferWritter.write("# entry should be kept on an individual line. The IP address should");
                bufferWritter.newLine();
                bufferWritter.write("# be placed in the first column followed by the corresponding host name.");
                bufferWritter.newLine();
                bufferWritter.write("# The IP address and the host name should be separated by at least one");
                bufferWritter.newLine();
                bufferWritter.write("# space.");
                bufferWritter.newLine();
                bufferWritter.write("#");
                bufferWritter.newLine();
                bufferWritter.write("# Additionally, comments (such as these) may be inserted on individual");
                bufferWritter.newLine();
                bufferWritter.write("# lines or following the machine name denoted by a '#' symbol.");
                bufferWritter.newLine();
                bufferWritter.write("#");
                bufferWritter.newLine();
                bufferWritter.write("# For example:");
                bufferWritter.newLine();
                bufferWritter.write("#");
                bufferWritter.newLine();
                bufferWritter.write("#      102.54.94.97     rhino.acme.com          # source server");
                bufferWritter.newLine();
                bufferWritter.write("#       38.25.63.10     x.acme.com              # x client host");
                bufferWritter.newLine();
                bufferWritter.write("");
                bufferWritter.newLine();
                bufferWritter.write("# localhost name resolution is handled within DNS itself.");
                bufferWritter.newLine();
                bufferWritter.write("#	127.0.0.1       localhost");
                bufferWritter.newLine();
                bufferWritter.write("#	::1             localhost");
                bufferWritter.newLine();
    	        bufferWritter.close();
    	    
	        System.out.println("Done");
	        
    	}catch(IOException e){
    		e.printStackTrace();
    	}
    }
}
