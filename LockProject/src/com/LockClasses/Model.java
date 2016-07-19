/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LockClasses;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author brianmadmaxsy
 */
public class Model {
    private Connection conn;
    private Statement st;
    private ResultSet rs;
    
    public String query;
    
    public Model(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            
            conn=DriverManager.getConnection("jdbc:mysql://localhost/lock","root","");
            
            st=conn.createStatement();
            
        }catch(Exception ex){
            System.out.println("Error: "+ex);
        }
    }
    
    //Create data
    
    public void addchild(String uid, String fname, String lname, String uname, String pword, String e, String con, String at,String pic,String occ,String gen,String bday,String c,String h,String childid,String computerid,String parentusername, String status)
    {
        int inserted=0;
        try
        {
            //st = conn.createStatement();
            PreparedStatement pStat=conn.prepareStatement("INSERT INTO user(userid,firstname,lastname,username,password,email,contact,accttype,picture,occupation,gender,birthday,city,home) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)"); 
            pStat.setString(1, uid);
            pStat.setString(2, fname);
            pStat.setString(3, lname);
            pStat.setString(4, uname);
            pStat.setString(5, pword);
            pStat.setString(6, e);
            pStat.setString(7, con);
            pStat.setString(8, at);
            pStat.setString(9, pic);
            pStat.setString(10, occ);
            pStat.setString(11, gen);
            pStat.setString(12, bday);
            pStat.setString(13, c);
            pStat.setString(14, h);
            
            inserted=pStat.executeUpdate();
            
            
            PreparedStatement pStat2=conn.prepareStatement("INSERT INTO child(userid,childid,computerid,parentusername,status) VALUES(?,?,?,?,?)"); 
            pStat2.setString(1, uid);
            pStat2.setString(2, childid);
            pStat2.setString(3, computerid);
            pStat2.setString(4, parentusername);
            pStat2.setString(5, status);
            
            inserted=pStat2.executeUpdate();
        }
        catch(Exception ex)
        {
            System.out.println("Error: "+ex);
        }
    }
    
    public void addComputer(String computerid, String os_username, String computername, String computersid)
    {
        int inserted=0;
        try
        {
            //st = conn.createStatement();
            PreparedStatement pStat=conn.prepareStatement("INSERT INTO computer(computerid,username,domainname,sid) VALUES(?,?,?,?)"); 
            pStat.setString(1, computerid);
            pStat.setString(2, os_username);
            pStat.setString(3, computername);
            pStat.setString(4, computersid);
           
            inserted=pStat.executeUpdate();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
         
    }
    public int update_computer(String username, String domain, String sid, String computerid)
    {
        try 
        {
          //conn = getConnection();
          String q = "update computer set username=?, domainname=?, sid = ? where computerid = ? ";
          PreparedStatement pstmt = conn.prepareStatement(q); // create a statement
          pstmt.setString(1, username); // set input parameter 1
          pstmt.setString(2, domain); // set input parameter 2
          pstmt.setString(3, sid); // set input parameter 3
          pstmt.setString(4, computerid); // set input parameter 4
          pstmt.executeUpdate(); // execute update statement
          
          return 1;
        } 
        catch (Exception e) 
        {
          e.printStackTrace();
          System.exit(1);
          return 0;
        }
    }
    //End of Create data
    
    //Check data
    public boolean bool=false;
    public void checkparent(String parentusername) //Checks if parent username is valid and in database
    {
        try
        {
            query="select username,accttype from user where username='"+parentusername+"'";
            rs=st.executeQuery(query);
            
            while(rs.next())
            {
                if("Parent".equals(rs.getString("accttype")))
                {
                    this.bool=true;
                }
                else
                {
                    this.bool=false;
                }   
            }
        }
        catch(Exception e)
        {
            System.out.print(e);
        }
        
    }
    public void checkaccount(String username,String password) //Checks if parent username is valid and in database
    {
        String uname="";
        try
        {
            query="select username from user where username='"+username+"' and password='"+password+"'";
            rs=st.executeQuery(query);
            
            while(rs.next())
            {
                uname=rs.getString("username");
                if(uname.equals(username))
                {
                    this.bool=true;
                }
                else
                {
                    this.bool=false;
                }   
            }
        }
        catch(Exception e)
        {
            System.out.print(e);
        }
        
    }
    
    //End of Check data
    
    //Retrieve data
    public ArrayList getchild_user(String username, String password)
    {
        ArrayList<String> arr = new ArrayList<String>();
        String userid="",accttype="",computerid="";
        
        try{
            query="select * from user where username='"+username+"' and password='"+password+"'";
            rs=st.executeQuery(query);
            //System.out.println("Records for Model");
            
            while(rs.next()){
                userid=rs.getString("userid");
                accttype=rs.getString("accttype");
            }
            arr.add(userid);
            arr.add(accttype);
            arr.add(computerid);
            return arr;
        }
        catch(Exception e)
        {
            System.out.print(e);
            return arr;
        }
    }
    
    public ArrayList getuser(String uid)
    {
        ArrayList<String> arr = new ArrayList<String>();
        String username="",accttype="",firstname="",lastname="";
        
        try{
            query="select * from user where userid='"+uid+"'";
            rs=st.executeQuery(query);
            //System.out.println("Records for Model");
            
            while(rs.next()){
                firstname=rs.getString("firstname");
                lastname=rs.getString("lastname");
                username=rs.getString("username");
                accttype=rs.getString("accttype");
            }
            arr.add(firstname);
            arr.add(lastname);
            arr.add(username);
            arr.add(accttype);
            
            return arr;
        }
        catch(Exception e)
        {
            System.out.print(e);
            return arr;
        }
    }
    public ArrayList getchildinfo(String userid)
    {
        ArrayList<String> arr = new ArrayList<String>();
        String childid="",computerid="",parent_username="",status="";
        
        try{
            query="select * from child where userid='"+userid+"'";
            rs=st.executeQuery(query);
            //System.out.println("Records for Model");
            
            while(rs.next()){
                childid=rs.getString("childid");
                computerid=rs.getString("computerid");
                parent_username=rs.getString("parentusername");
                status=rs.getString("status");
            }
            arr.add(childid);
            arr.add(computerid);
            arr.add(parent_username);
            arr.add(status);
            
            return arr;
        }
        catch(Exception e)
        {
            System.out.print(e);
            return arr;
        }
    }
    
    public ArrayList get_computer(String computerid)
    {
        ArrayList<String> arr = new ArrayList<String>();
        //String childid="",computerid="",parent_username="",status="";
        String username="",domainname="",sid="";
        try
        {
            query="select * from computer where computerid='"+computerid+"'";
            rs=st.executeQuery(query);
            //System.out.println("Records for Model");
            
            while(rs.next()){
                username=rs.getString("username");
                domainname=rs.getString("domainname");
                sid=rs.getString("sid");
                
            }
            arr.add(username);
            arr.add(domainname);
            arr.add(sid);
            
            return arr;
        }
        catch(Exception e)
        {
            System.out.print(e);
            return arr;
        }
    }
    //End of retrieve data
   
    public ResultSet getBlocklist(String childid)
    {
        String uname="";
        try
        {
            query="select website from blacklist where childid='"+childid+"'";
            rs=st.executeQuery(query);
            return rs;
            /*
            while(rs.next())
            {
                uname=rs.getString("username");
                   
            }
             
             */
        }
        catch(Exception e)
        {
            System.out.print(e);
            return rs;
        }
    }
    
    
}
