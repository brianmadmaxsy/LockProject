/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LockClasses;

/**
 *
 * @author brianmadmaxsy
 */
public class NTSystem {
    public String domain,domainsid,name,primary_groupid,usersid;
    public String[] group_id;
    public long impersonation_token;
    public String OS;
    public void auth_credentials() //Sets values to the variables
    {
        String os = 
          "" + System.getProperty ("os.name");
        os += ", version: " + System.getProperty ("os.version");
        os += ", arch: " + System.getProperty ("os.arch");
        
        this.OS=os;
        
        //Calls the NTSystem
        com.sun.security.auth.module.NTSystem NTSystem = new com.sun.security.auth.module.NTSystem();
        
        this.domain=NTSystem.getDomain(); //Domain/Computer Name
        this.domainsid=NTSystem.getDomainSID(); //Security ID of the System Unit
        this.group_id=NTSystem.getGroupIDs();
        this.impersonation_token=NTSystem.getImpersonationToken();
        this.name=NTSystem.getName(); //User name
        this.primary_groupid=NTSystem.getPrimaryGroupID();
        this.usersid=NTSystem.getUserSID(); //Security ID of the User(of the System Unit)
    }
}
