package com.example.maulik.sign_in;

import java.io.Serializable;

/**
 * Created by Maulik on 4/4/2015.
 *
 * This class contains code for the Visitor object that will be important for
 * the application.  The Visitor object will contain information entered from
 * the Sign_in.java class.  The object will also be stored into the database
 */
public class Visitor implements Serializable{

    private String VisitorName,Email,PhoneNumber;

    public Visitor(String Name,String email, String Number)
    {
        VisitorName=Name;
        Email=email;
        PhoneNumber=Number;

    }

    public Visitor(Visitor person)
    {
        VisitorName=person.getVisitorName();
        Email=person.getEmail();
        PhoneNumber=person.getPhoneNumber();
    }

    public Visitor(){} // Default Constructor

    /**
     * Returns Visitor Name
     * @return
     */
    public String getVisitorName()
    {
        return VisitorName;
    }

    /**
     * returns Visitor Email
     * @return
     */
    public String getEmail()
    {
        return Email;
    }

    /**
     * returns Visitor Phone Number
     * @return
     */
    public String getPhoneNumber()
    {
        return PhoneNumber;
    }

    /*@param name
    * Sets VisitorName to String name
     */
    public void setVisitorName(String name)
    {
        VisitorName=name;
    }

    /**
     * sets Email to param newEmail
     * @param newEmail
     */
    public void setEmail(String newEmail)
    {
        Email=newEmail;
    }

    /**
     * sets PhoneNumber to param setter newNumber
     * @param newNumber
     */
    public void setPhoneNumber(String newNumber)
    {
        PhoneNumber=newNumber;
    }

    /**
     * returns a String representation of the Visitor Object
     * @return
     */
    public String toString()
    {
        String result="";
        result="Visitor Name: "+VisitorName+"            "+" "+"Email: "+Email+"            "+" "+"Phone Number: "+PhoneNumber;

        return result;
    }

}
