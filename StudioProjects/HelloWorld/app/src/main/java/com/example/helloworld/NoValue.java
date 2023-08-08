package com.example.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;

import androidx.appcompat.app.AppCompatActivity;

public class NoValue extends AppCompatActivity {
    Button button_close;
    TableLayout tableLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.no_value);




        button_close = findViewById(R.id.button_close);
        button_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comback();
            }
        });
    }
    public void comback() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
