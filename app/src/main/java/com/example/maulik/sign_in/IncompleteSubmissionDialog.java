package com.example.maulik.sign_in;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;

/**
 * Created by Maulik on 4/12/2015.
 *
 * This class instantiates a Dialog box that will appear when the user
 * attempts to submit an incomplete submission.  If one or more fields in
 * the Sign-in page are left blank, this Dialog Box will appear on the screen
 * informing the user to fill in all fields
 */
public class IncompleteSubmissionDialog extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        return new AlertDialog.Builder(getActivity())
                .setTitle(R.string.AllFieldsNotFilled)
                .setPositiveButton(android.R.string.ok,null)
                .create();

    }

}
