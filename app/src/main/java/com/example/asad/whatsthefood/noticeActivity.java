package com.example.asad.whatsthefood;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;

public class noticeActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);
        final SQLiteHelper helper = new SQLiteHelper(noticeActivity.this);
        ArrayList<String> data = helper.getALLdATA();
        textView = findViewById(R.id.text);

        for (int i = 0; i < data.size(); i++) {
            String toPut;
            toPut = data.get(i) + " \n";
            textView.setText(toPut.toString());


        }

    }
}
