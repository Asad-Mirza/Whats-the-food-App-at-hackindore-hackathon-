package com.example.asad.whatsthefood;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class addMenuActivity extends AppCompatActivity {
    EditText breakfastEditText, lunchEditText, dinnerEditText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_menu);
        breakfastEditText = findViewById(R.id.breakfast);
        lunchEditText = findViewById(R.id.lunch);
        dinnerEditText = findViewById(R.id.dinner);
        button = findViewById(R.id.submit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String breakf = breakfastEditText.getText().toString();
                String lunch = lunchEditText.getText().toString();
                String dinner = dinnerEditText.getText().toString();
                SharedPreferences pref = getSharedPreferences("menu", Context.MODE_MULTI_PROCESS);
                SharedPreferences.Editor preferencesEditor = pref.edit();
                preferencesEditor.putString("break", breakf);
                preferencesEditor.putString("lunch", lunch);
                preferencesEditor.putString("dinner", dinner);
                preferencesEditor.commit();
                Toast.makeText(addMenuActivity.this, "Menu Saved", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(addMenuActivity.this, AdminActivity.class));
                finish();
            }
        });
    }
}
