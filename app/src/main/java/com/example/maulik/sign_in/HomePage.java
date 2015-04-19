package com.example.maulik.sign_in;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.TooManyListenersException;

/**
 * Created by Maulik on 4/17/2015.
 */
public class HomePage extends Activity {

    Button VisitorButton,FacultyButton;
    Context context=this;
    FragmentManager DialogManager=getFragmentManager();
    String MyPassword="";
    String Errormessage="Incorrect Password";

   @Override
    protected void onCreate(Bundle savedInstanceState)
   {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.home_page);

       VisitorButton=(Button)findViewById(R.id.NewVisitor);
       VisitorButton.setTextSize(60);
       VisitorButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               Intent i = new Intent(HomePage.this, Sign_In.class);
               startActivity(i);
           }
       });

       FacultyButton=(Button)findViewById(R.id.FacultyUse);
       FacultyButton.setTextSize(60);
       FacultyButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

                   final AlertDialog.Builder alert = new AlertDialog.Builder(context);
                   alert.setTitle("Please Enter Password"); //Set Alert dialog title here

                   // Set an EditText view to get user input
                   final EditText input = new EditText(context);
                   input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD );

                   alert.setView(input);

                   alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                       public void onClick(DialogInterface dialog, int whichButton) {
                           //You will get as string input data in this variable.
                           // here we convert the input to a string and show in a toast.

                           MyPassword = input.getEditableText().toString();

                           if(MyPassword.equals("tcnjcs")==false)
                           {
                               input.setText("");
                               Toast.makeText(getBaseContext(),Errormessage,Toast.LENGTH_LONG).show();
                           }
                           else
                           {
                               Intent i = new Intent(HomePage.this, FacultyHomePage.class);
                               startActivity(i);
                           }

                       }
                   });
                   alert.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                       public void onClick(DialogInterface dialog, int whichButton) {
                           // Canceled.
                           dialog.cancel();
                       }
                   }); //End of alert.setNegativeButton
                   AlertDialog alertDialog = alert.create();
                   alertDialog.show();
               //Faculty page has not been created yet
               //Will contain different options for faculty
           }
       });
   }
}
