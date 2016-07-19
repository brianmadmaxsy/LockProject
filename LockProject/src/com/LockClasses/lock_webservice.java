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
import java.io.*;

import java.net.*;
import java.util.*;
import com.google.gson.*;
public class lock_webservice {
    public Children[] enums;
    public void getchildusers(String parentusername)
    {
        ArrayList<String> arr = new ArrayList<String>();
        try
        {
            Gson gson=new Gson();
            //Child ch =new Child();
            //User u = new User();
            
            URL url = new URL("http://lock-lockitproject.rhcloud.com/apigetchildlist");
            Map<String,Object> params = new LinkedHashMap<String,Object>();
            params.put("parentusername", parentusername);
            //params.put("password", "nfsmwchamp");

            StringBuilder postData = new StringBuilder();
            for (Map.Entry<String,Object> param : params.entrySet())  //kinda like a parameter encoding?
            {
                if (postData.length() != 0) postData.append('&');
                postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
                postData.append('=');
                postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
            }

            byte[] postDataBytes = postData.toString().getBytes("UTF-8");

            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
            conn.setDoOutput(true);
            conn.getOutputStream().write(postDataBytes);

            Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            
           
            String s = "";
            for ( int c = in.read(); c != -1; c = in.read() )
            {
                s += (char)c;
            }
            //System.out.println(s);
            
            Children[] child = gson.fromJson(s, Children[].class);
            this.enums = child;
            
        }
        catch(Exception ex)
        {
           
           System.out.println(ex);
           
        }
    }
    public ArrayList<String> getchild(String username) //get child user using username
    {
        ArrayList<String> arr = new ArrayList<String>();
        try
        {
            Gson gson=new Gson();
            //Child ch =new Child();
            //User u = new User();
            
            URL url = new URL("http://lock-lockitproject.rhcloud.com/apigetchilduser");
            Map<String,Object> params = new LinkedHashMap<String,Object>();
            params.put("username", username);
            //params.put("password", "nfsmwchamp");

            StringBuilder postData = new StringBuilder();
            for (Map.Entry<String,Object> param : params.entrySet())  //kinda like a parameter encoding?
            {
                if (postData.length() != 0) postData.append('&');
                postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
                postData.append('=');
                postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
            }

            byte[] postDataBytes = postData.toString().getBytes("UTF-8");

            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
            conn.setDoOutput(true);
            conn.getOutputStream().write(postDataBytes);

            Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            
           
            String s = "";
            for ( int c = in.read(); c != -1; c = in.read() )
            {
                s += (char)c;
            }
            //System.out.println(s);
            
            Children child = gson.fromJson(s, Children.class);
            String userid = child.getUserid();
            arr.add(userid);
            
            
        }
        catch(Exception ex)
        {
           
           System.out.println(ex);
           
        }
        return arr;
    }
    public ArrayList getchild_usingUserId(String userid) //get child user using userid
    {
        ArrayList<String> arr = new ArrayList<String>();
        try
        {
            Gson gson=new Gson();
            Child ch =new Child();
            //User u = new User();
            URL url = new URL("http://lock-lockitproject.rhcloud.com/apigetuser");
            Map<String,Object> params = new LinkedHashMap<String,Object>();
            params.put("userid", userid);
            //params.put("password", "nfsmwchamp");

            StringBuilder postData = new StringBuilder();
            for (Map.Entry<String,Object> param : params.entrySet())  //kinda like a parameter encoding?
            {
                if (postData.length() != 0) postData.append('&');
                postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
                postData.append('=');
                postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
            }

            byte[] postDataBytes = postData.toString().getBytes("UTF-8");

            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
            conn.setDoOutput(true);
            conn.getOutputStream().write(postDataBytes);

            Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String s = "";
            for ( int c = in.read(); c != -1; c = in.read() )
            {
                s += (char)c;
            }
            //System.out.println(s);
            Children child=gson.fromJson(s, Children.class);
            arr.add(child.getFirstname()); //0
            arr.add(child.getLastname()); //1
            arr.add(child.getUsername()); //2
            arr.add(child.getChildid()); //3
            arr.add(child.getComputerid()); //4
            arr.add(child.getParentusername()); //5
            arr.add(child.getStatus()); //6
            return arr;
        }
        catch(Exception ex)
        {
           System.out.println(ex);
           return arr;
        }
    }
    public ArrayList login_webservice(String username, String password) // for login of parent in setup2
    {
        ArrayList<String> arr = new ArrayList<String>();
        String json_status;
        String json_message;
        String uname;
        
        String accounttype;
        try
        {
            Gson gson=new Gson();
            URL url = new URL("http://lock-lockitproject.rhcloud.com/apilogin");
            Map<String,Object> params = new LinkedHashMap<String,Object>();
            params.put("username", username);
            params.put("password", password);
            

            StringBuilder postData = new StringBuilder();
            for (Map.Entry<String,Object> param : params.entrySet())  //kinda like a parameter encoding?
            {
                if (postData.length() != 0) postData.append('&');
                postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
                postData.append('=');
                postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
            }

            byte[] postDataBytes = postData.toString().getBytes("UTF-8");

            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
            conn.setDoOutput(true);
            conn.getOutputStream().write(postDataBytes);

            Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String s = "";
            for ( int ch = in.read(); ch != -1; ch = in.read() )
            {
                s += (char)ch;
            }
            //System.out.println(s);
            //System.out.println(gson.fromJson(s,message.class));
           // message m = new message();
            User u = new User();
            u = gson.fromJson(s,User.class);
            
            json_status=u.getStatus();
            json_message=u.getMessage();
            uname=u.getUsername();
            accounttype=u.getAccttype();
            //uid=u.getUserid();
            
            arr.add(json_status); //0
            arr.add(json_message); //1
            arr.add(uname); //2
            arr.add(accounttype); //3
            
            return arr;
        }
        catch(Exception ex)
        {
            System.out.println(ex);
            return arr;
        }
    }
}
