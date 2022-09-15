package com.chetu.demotp8;

import java.io.Serializable;

//TODO: Serializable-->We can make it Serializable also for sending multiple data: -
//public class User implements Serializable {
public class User {
    private String firstName;
    private String lastName;
    private String mobileNo;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }
}
