/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SetupClass;

/**
 *
 * @author brianmadmaxsy
 */
public class User {

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAccttype() {
        return accttype;
    }

    public void setAccttype(String accttype) {
        this.accttype = accttype;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public User() {
    }
    private String status="";
    private String message="";
    private String userid="";
    private String firstname="";
    private String lastname="";
    private String username="";
    private String password="";
    private String email="";
    private String contact="";
    private String accttype="";
    private String picture="";
    private String occupation="";
    private String gender="";
    private String birthday="";
    private String city="";
    private String home="";

    @Override
    public String toString() {
        return "User{" + "status=" + status + ", message=" + message + ", userid=" + userid + ", firstname=" + firstname + ", lastname=" + lastname + ", username=" + username + ", password=" + password + ", email=" + email + ", contact=" + contact + ", accttype=" + accttype + ", picture=" + picture + ", occupation=" + occupation + ", gender=" + gender + ", birthday=" + birthday + ", city=" + city + ", home=" + home + '}';
    }
    
    
}
