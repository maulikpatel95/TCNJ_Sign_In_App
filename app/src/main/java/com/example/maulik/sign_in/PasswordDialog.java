package com.example.maulik.sign_in;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Maulik on 4/17/2015.
 */
public class PasswordDialog extends DialogFragment {

    public static final String PASSWORD="Password";

    private String TCNJPassword;

    public static PasswordDialog newInstance(String password)
    {
        Bundle args=new Bundle();
        args.putString(PASSWORD,password);
        PasswordDialog fragment=new PasswordDialog();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {


        return new AlertDialog.Builder(getActivity())
                .setTitle("Incorrect Password")
                .setPositiveButton(android.R.string.ok,null)
                .create();

    }

}
