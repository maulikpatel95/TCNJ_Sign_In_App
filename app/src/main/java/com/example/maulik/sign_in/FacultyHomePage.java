package com.example.maulik.sign_in;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Maulik on 4/17/2015.
 */
public class FacultyHomePage extends Activity {

    Button SeeList,DeleteData;

    DatabaseHandler myDB=new DatabaseHandler(this);


    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.faculty_homepage);

        SeeList=(Button)findViewById(R.id.FacultyList);
        SeeList.setTextSize(35);

        DeleteData=(Button)findViewById(R.id.DeleteDatabase);
        DeleteData.setTextSize(35);

        SeeList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(FacultyHomePage.this,VisitorList.class);
                startActivity(i);
            }
        });

        DeleteData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDB.DeleteDatabaseRecords();
            }
        });
    }





}
