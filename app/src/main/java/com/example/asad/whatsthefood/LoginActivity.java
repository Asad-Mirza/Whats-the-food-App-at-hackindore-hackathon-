package com.example.asad.whatsthefood;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText nameEditText, emailEditText;
    Button submitButton, adminButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        nameEditText = findViewById(R.id.name);
        emailEditText = findViewById(R.id.email);
        submitButton = findViewById(R.id.submit);
        adminButton = findViewById(R.id.admin);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name, email;
                name = nameEditText.getText().toString();
                email = emailEditText.getText().toString();
                if (TextUtils.isEmpty(name) || TextUtils.isEmpty(email)) {

                    Toast.makeText(LoginActivity.this, "Enter name and email", Toast.LENGTH_SHORT).show();
                } else {
                    SharedPreferences pref = getSharedPreferences("v", Context.MODE_MULTI_PROCESS);
                    SharedPreferences.Editor preferencesEditor = pref.edit();
                    preferencesEditor.putBoolean("f", true);
                    preferencesEditor.putBoolean("is", true);
                    preferencesEditor.commit();
                    startActivity(new Intent(LoginActivity.this, studentActivity.class));
                    finish();
                }


            }
        });

        adminButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater li = LayoutInflater.from(LoginActivity.this);
                View promptsView = li.inflate(R.layout.passwordpop, null);

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        LoginActivity.this);

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
                                        if (pass.equals("1234")) {
                                            SharedPreferences pref = getSharedPreferences("v", Context.MODE_MULTI_PROCESS);
                                            SharedPreferences.Editor preferencesEditor = pref.edit();
                                            preferencesEditor.putBoolean("is", true);
                                            preferencesEditor.commit();
                                            startActivity(new Intent(LoginActivity.this, AdminActivity.class));
                                            finish();
                                        } else {
                                            Toast.makeText(LoginActivity.this, "Incorrect Password", Toast.LENGTH_SHORT).show();
                                        }
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

