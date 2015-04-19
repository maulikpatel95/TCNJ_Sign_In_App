package com.example.maulik.sign_in;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maulik on 4/4/2015.
 */
public class VisitorList extends Activity {

    TextView List;
    DatabaseHandler myDB=new DatabaseHandler(this);

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.visitor_signin_list);
        ArrayList theList=myDB.getAllVisitors();
        String ViewScreen="";

        List=(TextView)findViewById(R.id.Sign_InList);
        List.setTextSize(25);

        for(int counter=0;counter<theList.size();counter++)
        {
            ViewScreen=ViewScreen+theList.get(counter).toString()+"\n";
        }

        List.setText(ViewScreen);

        //SQLiteDatabase.openDatabase("com.example.maulik.tcnj_signin/DatabaseHandler",null,SQLiteDatabase.OPEN_READWRITE);


    }
}
