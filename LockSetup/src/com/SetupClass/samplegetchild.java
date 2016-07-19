/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SetupClass;

import java.util.*;

/**
 *
 * @author brianmadmaxsy
 */
public class samplegetchild {
    public static void main(String args[])
    {
        /*
        setupWebService s = new setupWebService();
        ArrayList<String> arr;
        arr=s.getchild("jeffang");
        String userid = arr.get(0);
        */
        
        Session s = new Session();
        String userid=s.seekHiddenData("C://users/brianmadmaxsy/AppData/Local/user.txt");
        System.out.println(userid);
    }
}
