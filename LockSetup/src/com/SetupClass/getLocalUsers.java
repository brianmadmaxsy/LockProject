/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SetupClass;

import java.util.Enumeration;
import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.EnumVariant;
import com.jacob.com.Variant;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author brianmadmaxsy
 */
public class getLocalUsers {

    //public static void main(String[] args) 
    public int count = 0;

    public ArrayList<String> getLocalUsers() {
        String name;
        ArrayList<String> arr = new ArrayList<String>();
        ComThread.InitMTA();

        try {
            ActiveXComponent wmi = new ActiveXComponent("winmgmts:\\\\.");
            Variant instances = wmi.invoke("InstancesOf", "Win32_UserAccount");
            Enumeration<Variant> en = new EnumVariant(instances.getDispatch());

            //return en;
            while (en.hasMoreElements()) {

                ActiveXComponent bb = new ActiveXComponent(en.nextElement().getDispatch());
                //System.out.println(bb.getPropertyAsString("PartComponent"));
                name = bb.getPropertyAsString("Name");
                arr.add(name);
                this.count++;
                //System.out.println(s);
                //System.out.println(bb.getPropertyAsComponent("name"));
            }
            return arr;

        } 
        finally {
            ComThread.Release();
            
        }
        
    }

}
