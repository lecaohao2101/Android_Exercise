package com.example.helloworld;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private EditText input_name, input_destination, input_description, input_date;
    private RadioGroup input_require;
    private RadioButton input_yes, input_no;
    private Button button_add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input_name = findViewById(R.id.input_name);
        input_destination = findViewById(R.id.input_destination);
        input_date = findViewById(R.id.input_date);
        input_require = findViewById(R.id.input_require);
        input_yes = findViewById(R.id.input_yes);
        input_no = findViewById(R.id.input_no);
        input_description = findViewById(R.id.input_description);
        button_add = findViewById(R.id.button_add);



        input_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                input_date.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                            }
                        }, year, month, day);
                datePickerDialog.show();
            }
        });

        //button
        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inFoUser();
            }
        });
    }

    public void inFoUser() {
        //get data
        String nameText = input_name.getText().toString();
        String destinationText = input_destination.getText().toString();
        String dateText = input_date.getText().toString();
        int selectedId = input_require.getCheckedRadioButtonId();
        String descriptionText = input_description.getText().toString();

        if (selectedId == -1 || nameText.isEmpty() || destinationText.isEmpty() || descriptionText.isEmpty() || dateText.isEmpty()) {
            Intent intent = new Intent(MainActivity.this, NoValue.class);
            startActivity(intent);
        } else {
            RadioButton selectedRadioButton = findViewById(selectedId);
            String selectedText = selectedRadioButton.getText().toString();
            Intent intent = new Intent(MainActivity.this, DisplayInfo.class);
            intent.putExtra("require", selectedText);
            intent.putExtra("name", nameText);
            intent.putExtra("destination", destinationText);
            intent.putExtra("date", dateText);
            intent.putExtra("description", descriptionText);
            startActivity(intent);
        }
    }
}



