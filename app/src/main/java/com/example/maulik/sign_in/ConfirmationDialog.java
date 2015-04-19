package com.example.maulik.sign_in;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;

/**
 * Created by Maulik Patel on 4/12/2015.
 *
 * This class constructs a Dialog box that will be shown to the user once he/she successfully signs in
 * If the user clicks the Submit button on the Sign in page and all fields are validated, this dialog box
 * will show onto the screen confirming successful sign-in
 */
public class ConfirmationDialog extends DialogFragment{

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        return new AlertDialog.Builder(getActivity())
                .setTitle(R.string.Confirmation) //Sets the dialog title
                .setPositiveButton(android.R.string.ok,null) //Instantiates dialog's OK button
                .create();
    }


}
