/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SetupClass;

/**
 *
 * @author brianmadmaxsy
 */
public class Child {
    String userid="";
    String childid="";
    String computerid="";
    String parentusername="";
    String status="";
    String username="";
    String domainname="";
    String sid="";
    
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
    
    
}
