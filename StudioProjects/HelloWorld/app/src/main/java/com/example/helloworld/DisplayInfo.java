package com.example.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DisplayInfo extends AppCompatActivity {
    private Button button_close_info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_info);

        button_close_info = findViewById(R.id.button_close_info);
        button_close_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comback();
            }
        });

        Intent intent = getIntent();
        if (intent != null
                && intent.hasExtra("require")
                && intent.hasExtra("name")
                && intent.hasExtra("destination")
                && intent.hasExtra("date")
                && intent.hasExtra("description")) {
            String name = intent.getStringExtra("name");
            String destination = intent.getStringExtra("destination");
            String date = intent.getStringExtra("date");
            String require = intent.getStringExtra("require");
            String description = intent.getStringExtra("description");

            TextView nameTextView = (TextView) findViewById(R.id.name);
            nameTextView.setText("Name: " + name);

            TextView destinationTextView = (TextView) findViewById(R.id.destination);
            destinationTextView.setText("Destination: " + destination);

            TextView dateTextView = (TextView) findViewById(R.id.date);
            dateTextView.setText("Date of the Trip: " + "\n" + date);

            TextView requireTextView = findViewById(R.id.require);
            requireTextView.setText("Risk Assessment: " + require);

            TextView descriptionTextView = (TextView) findViewById(R.id.description);
            descriptionTextView.setText("Description: " + description);
        }
    }

    private void comback() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}




