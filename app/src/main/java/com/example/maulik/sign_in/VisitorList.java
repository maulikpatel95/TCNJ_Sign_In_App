package com.example.maulik.sign_in;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maulik on 4/4/2015.
 *
 * This class will allow the CS faculty to observe the information
 * stored in the database.  When the List button is clicked, a ArrayList will
 * be instantiated containing the information from the database and will be shown
 * onto the screen
 */
public class VisitorList extends Activity {

    TextView List;
    DatabaseHandler myDB=new DatabaseHandler(this); // Provides access to the application Database

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.visitor_signin_list);
        ArrayList theList=myDB.getAllVisitors();
        String ViewScreen="";

        List=(TextView)findViewById(R.id.Sign_InList); //Creates a TextView Object to show information
        List.setTextSize(25);

        /**
         *  Appends each row into a string. For loop will traverse through each entry
         *  in the ArrayList.  The TextView will use the setText() method to set the TextView
         *  to show the String representation
         */
        for(int counter=0;counter<theList.size();counter++)
        {
            ViewScreen=ViewScreen+theList.get(counter).toString()+"\n";
        }

        List.setText(ViewScreen);



    }
}
