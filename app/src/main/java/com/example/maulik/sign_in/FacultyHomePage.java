package com.example.maulik.sign_in;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Maulik on 4/17/2015.
 *
 * This class will create a home page where faculty members of the CS department
 * can perform several operations on the list in the database.  Current operations include
 * viewing the Visitor List and deleting all information in the database.  Future operations
 * include exporting all emails to a central web server and potentially integrating Google maps
 * to view which regions potential students are coming from.
 */
public class FacultyHomePage extends Activity {

    Button SeeList,DeleteData,ExportEmail;
    String message="Database Records Deleted";
    DatabaseHandler myDB=new DatabaseHandler(this); //Instantiates variable to access SQLite Database


    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.faculty_homepage);

        SeeList=(Button)findViewById(R.id.FacultyList);
        SeeList.setTextSize(35);

        ExportEmail=(Button)findViewById(R.id.EmailExport);
        ExportEmail.setTextSize(35);
        ExportEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(FacultyHomePage.this,ExportEmail.class);
                startActivity(i);

            }
        });

        DeleteData=(Button)findViewById(R.id.DeleteDatabase);
        DeleteData.setTextSize(35);

        /**
         * Implementation of button click when Visitor List button is clicked
         */
        SeeList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(FacultyHomePage.this,VisitorList.class); // Intent to view the Visitor List
                startActivity(i);
            }
        });

        DeleteData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDB.DeleteDatabaseRecords();
                Toast.makeText(getBaseContext(),message,Toast.LENGTH_LONG).show();
            }
        });
    }





}
