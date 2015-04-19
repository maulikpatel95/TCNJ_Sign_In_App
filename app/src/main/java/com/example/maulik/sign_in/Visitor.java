package com.example.maulik.sign_in;

import java.io.Serializable;

/**
 * Created by Maulik on 4/4/2015.
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

    public Visitor(){}

    public String getVisitorName()
    {
        return VisitorName;
    }

    public String getEmail()
    {
        return Email;
    }

    public String getPhoneNumber()
    {
        return PhoneNumber;
    }

    public void setVisitorName(String name)
    {
        VisitorName=name;
    }

    public void setEmail(String newEmail)
    {
        Email=newEmail;
    }

    public void setPhoneNumber(String newNumber)
    {
        PhoneNumber=newNumber;
    }

    public String toString()
    {
        String result="";
        result="Visitor Name: "+VisitorName+"            "+" "+"Email: "+Email+"            "+" "+"Phone Number: "+PhoneNumber;

        return result;
    }

}
