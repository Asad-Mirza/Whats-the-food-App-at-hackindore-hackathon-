package com.example.asad.whatsthefood;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AdminActivity extends AppCompatActivity {
    TextView textView, sendNotif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        textView = findViewById(R.id.todaymenu);
        sendNotif = findViewById(R.id.sendNotice);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AdminActivity.this, addMenuActivity.class));
            }
        });
        sendNotif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater li = LayoutInflater.from(AdminActivity.this);
                View promptsView = li.inflate(R.layout.passwordpop2, null);

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        AdminActivity.this);

                // set prompts.xml to alertdialog builder
                alertDialogBuilder.setView(promptsView);

                final EditText userInput = (EditText) promptsView
                        .findViewById(R.id.editTextDialogUserInput);

                // set dialog message
                alertDialogBuilder
                        .setCancelable(false)
                        .setPositiveButton("OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        // get user input and set it to result
                                        // edit text
                                        String pass = userInput.getText().toString();
                                        ProgressDialog progressDialog = new ProgressDialog(AdminActivity.this);
                                        progressDialog.setMessage("Sending Notice...");
                                        progressDialog.show();
                                        SQLiteHelper sqLiteHelper = new SQLiteHelper(getApplication());

                                        boolean flag = sqLiteHelper.insertContact(userInput.toString());
                                        if (flag)
                                            Toast.makeText(AdminActivity.this, "Notice Sent", Toast.LENGTH_SHORT).show();
                                        else
                                            Toast.makeText(AdminActivity.this, "Error", Toast.LENGTH_SHORT).show();
                                        progressDialog.dismiss();

                                    }
                                })
                        .setNegativeButton("Cancel",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });

                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();

            }
        });

    }
}
