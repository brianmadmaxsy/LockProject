/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SetupClass;

/**
 *
 * @author brianmadmaxsy
 */

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
