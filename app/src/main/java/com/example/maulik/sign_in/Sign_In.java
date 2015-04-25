package com.example.maulik.sign_in;

import android.app.AlertDialog;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the main class where new visitors will sign in by inputting
 * information into several fields:  User name, user email, and user phone number.
 * If the user leaves some fields empty they will be instructed to fill all fields.
 * Once the user clicks the submit button, the information will be encapsulated into an
 * instantiated Visitor Object which will be stored into the Database where it can be
 * accessed.
 */

public class Sign_In extends ActionBarActivity {

    Button SubmitButton;
    EditText FullName,EmailAddress,PhoneNumber;
    ArrayList<Visitor> VisitorList=new ArrayList<Visitor>();
    int duration=Toast.LENGTH_SHORT;
    CharSequence message="Please fill all relevant fields";
    private static final String CONFIRMED_STATUS="Signed-In";
    private static final String NOT_SIGNED_IN="Not Signed-In";
    DatabaseHandler myDB=new DatabaseHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign__in);

        FullName=(EditText)findViewById(R.id.VisitorName);
        EmailAddress=(EditText)findViewById(R.id.EmailAddress);
        PhoneNumber=(EditText)findViewById(R.id.PhoneNumber);

        SubmitButton=(Button)findViewById(R.id.ButtonSubmit);
        SubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Context context=getApplicationContext();
                FragmentManager Manager=getFragmentManager();
                ConfirmationDialog Submitted=new ConfirmationDialog();
                IncompleteSubmissionDialog IncompleteSubmit=new IncompleteSubmissionDialog();
                if(FullName.getText().toString().equals("") || EmailAddress.getText().toString().equals("") || PhoneNumber.getText().toString().equals(""))
                {

                  IncompleteSubmit.show(Manager,NOT_SIGNED_IN);
                }
                else {

                    /**
                     * Create a temp Visitor object to store into the database.
                     * The text fields are then cleared to sign in next user
                     */
                    Visitor temp = new Visitor(FullName.getText().toString(), EmailAddress.getText().toString(), PhoneNumber.getText().toString());
                    myDB.addVisitor(temp); //Add Visitor to the Database
                    Submitted.show(Manager,CONFIRMED_STATUS);
                    FullName.setText("");
                    EmailAddress.setText("");
                    PhoneNumber.setText("");

                }
              //Store data once Submit button is clicked
            }
        });

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.sign__in, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private boolean Validate() {
        boolean validate = true;

        if (EmailAddress.getText().toString().contains("@") && (EmailAddress.getText().toString().contains(".edu") || EmailAddress.getText().toString().contains(".com"))) {
            validate = true;
        } else {
            validate = false;
        }

        if (PhoneNumber.getText().toString().length() != 10) {
            validate = false;
        }

        return validate;

    }


}
