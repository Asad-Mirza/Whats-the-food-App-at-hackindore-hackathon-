package com.example.asad.whatsthefood;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class studentActivity extends AppCompatActivity {
    TextView b, l, d, tt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        b = findViewById(R.id.breakfastName);
        l = findViewById(R.id.lunchName);
        d = findViewById(R.id.dinnerName);
        tt = findViewById(R.id.textv);

        SharedPreferences pref = getSharedPreferences("menu", Context.MODE_MULTI_PROCESS);
        String breakf = pref.getString("break", "Tea and Coffe");
        String lunchJ = pref.getString("lunch", "Dal Chawal");
        String dinner = pref.getString("dinner", "Dal and Roti");

        b.setText(breakf);
        l.setText(lunchJ);
        d.setText(dinner);
        tt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(studentActivity.this, noticeActivity.class));
                finish();
            }
        });

    }
}
