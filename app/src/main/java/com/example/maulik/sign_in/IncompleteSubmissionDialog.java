package com.example.maulik.sign_in;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;

/**
 * Created by Maulik on 4/12/2015.
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
