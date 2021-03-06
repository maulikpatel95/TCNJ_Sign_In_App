package com.example.maulik.sign_in;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Maulik on 4/25/2015.
 *
 * This class will extract all visitors from the Database and store them in an ArrayList.
 * Functionality added will include sending email list to an intended email recipient. The
 * recipient will be able to create an email group and maintain user emails.
 */
public class ExportEmail extends Activity {

    TextView ViewEmail;
    DatabaseHandler myDB=new DatabaseHandler(this);
    String view="";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.export_email);

        ViewEmail=(TextView)findViewById(R.id.EmailList);
        ViewEmail.setTextSize(30);

        ArrayList<Visitor> visitors=myDB.getAllVisitors();
        ArrayList<String> emailList=new ArrayList<String>();

        for(int counter=0;counter<visitors.size();counter++)
        {
            emailList.add(visitors.get(counter).getEmail());
            view=view+emailList.get(counter)+"\n";
        }

        ViewEmail.setText(view);


    }

}
