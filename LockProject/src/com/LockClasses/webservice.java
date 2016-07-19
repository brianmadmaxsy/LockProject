/*
 * To change this template, choose Tools | Templates
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
public class webservice 
{
    public ArrayList addchild(String fname, String lname, String uname, String pword, String e, String con, String at,String parentusername)
    {
        ArrayList<String> arr = new ArrayList<String>();
        String json_status="";
        String json_message="";
        try
        {
            Gson gson=new Gson();
            URL url = new URL("http://lock-lockitproject.rhcloud.com/apisignup");
            Map<String,Object> params = new LinkedHashMap<String,Object>();
            params.put("firstname", fname);
            params.put("lastname", lname);
            params.put("username",uname);
            params.put("email",e);
            params.put("password",pword);
            params.put("confirmpassword",pword);
            params.put("accounttype",at);
            params.put("parentusername",parentusername);
            params.put("contact",con);

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
            message m = new message();
            
            m = gson.fromJson(s,message.class);
            json_status=m.getStatus();
            json_message=m.getMessage();
            arr.add(json_status);
            arr.add(json_message);
            return arr;
        }
        catch(Exception ex)
        {
            System.out.println(ex);
            return arr;
        }
    }
    
    public ArrayList getuser(String userid)
    {
        ArrayList<String> arr = new ArrayList<String>();
        try
        {
            Gson gson=new Gson();
            Child ch =new Child();
            User u = new User();
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
            u=gson.fromJson(s, User.class);
            arr.add(u.getFirstname()); //0
            arr.add(u.getLastname()); //1
            arr.add(u.getUsername()); //2
            
            return arr;
        }
        catch(Exception ex)
        {
           System.out.println(ex);
           return arr;
        }
    }
    public ArrayList getchild_user(String username, String password) // for login of child
    {
        ArrayList<String> arr = new ArrayList<String>();
        String json_status="";
        String json_message="";
        String userid="";
        String accounttype="";
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
            userid=u.getUserid();
            accounttype=u.getAccttype();
            arr.add(json_status);
            arr.add(json_message);
            arr.add(userid);
            arr.add(accounttype);
            
            return arr;
        }
        catch(Exception ex)
        {
            System.out.println(ex);
            return arr;
        }
    }
    public ArrayList getchildinfo(String userid)
    {
        ArrayList<String> arr = new ArrayList<String>();
        try
        {
            Gson gson=new Gson();
            Child ch =new Child();
            URL url = new URL("http://lock-lockitproject.rhcloud.com/apigetchild");
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
            ch=gson.fromJson(s, Child.class);
            arr.add(ch.getComputerid()); //0
            arr.add(ch.getSid());       //1
            arr.add(ch.getChildid());   //2
            arr.add(ch.getUsername());  //3
            arr.add(ch.getDomainname());//4
            arr.add(ch.getParentusername()); //5
            arr.add(ch.getStatus()); //6
            return arr;
        }
        catch(Exception ex)
        {
           System.out.println(ex);
           return arr;
        }
        
    }
    public int update_computer(String username, String domain, String sid, String computerid)
    {
        //ArrayList<String> arr = new ArrayList<String>();
        
        try
        {
            Gson gson=new Gson();
            //Child ch =new Child();
            message m = new message();
            URL url = new URL("http://lock-lockitproject.rhcloud.com/apiupdatecomputer");
            Map<String,Object> params = new LinkedHashMap<String,Object>();
            params.put("username", username);
            params.put("domainname", domain);
            params.put("sid",sid);
            params.put("computerid", computerid); 
            

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
            m=gson.fromJson(s, message.class);
            
            if("success".equals(m.getStatus()))
            {
                return 1;
            }
            else
            {
                return 0;
            }
            
        }
        
        catch (Exception e) 
        {
          e.printStackTrace();
          System.exit(1);
          return 0;
        }
    }
}

class message{
    String status="";
    String message="";
    
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public message() {
    }

    @Override
    public String toString() {
        return "message{" + "status=" + status + ", message=" + message + '}';
    }
}

class Child
{

    public Child() {
    }

    public String getChildid() {
        return childid;
    }

    public void setChildid(String childid) {
        this.childid = childid;
    }

    public String getComputerid() {
        return computerid;
    }

    public void setComputerid(String computerid) {
        this.computerid = computerid;
    }

    public String getDomainname() {
        return domainname;
    }

    public void setDomainname(String domainname) {
        this.domainname = domainname;
    }

    public String getParentusername() {
        return parentusername;
    }

    public void setParentusername(String parentusername) {
        this.parentusername = parentusername;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Child{" + "userid=" + userid + ", childid=" + childid + ", computerid=" + computerid + ", parentusername=" + parentusername + ", status=" + status + ", username=" + username + ", domainname=" + domainname + ", sid=" + sid + '}';
    }
    String userid="";
    String childid="";
    String computerid="";
    String parentusername="";
    String status="";
    String username="";
    String domainname="";
    String sid="";
    
}
