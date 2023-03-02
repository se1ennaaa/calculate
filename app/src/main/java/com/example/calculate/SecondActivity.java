package com.example.calculate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TextView Textt = findViewById(R.id.text_view);
        String get = getIntent().getStringExtra("key");
        Textt.setText(get);
            findViewById(R.id.btn_destroy).setOnClickListener(view -> {
                onDestroy();
                finish();
            });
    }
}