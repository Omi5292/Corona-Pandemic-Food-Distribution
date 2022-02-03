package com.example.coronapandemic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    EditText name,occupation,adharno,place,pin,no;
    Button submit, update;
    Spinner spinner;
    FDdatabase mDatabaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_register);

        spinner = findViewById(R.id.spinner);
        String[] time = new String[]{"Morning","Evening"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,time);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        //------------------------------------------------------------------------------------------
        name = (EditText) findViewById(R.id.editText);
        occupation = (EditText) findViewById(R.id.editText2);
        adharno = (EditText) findViewById(R.id.editText3);
        place = (EditText) findViewById(R.id.editText4);
        pin = (EditText) findViewById(R.id.editText5);
        no = (EditText) findViewById(R.id.editText6);
        submit = findViewById(R.id.btnsubmit);
        update = findViewById(R.id.btnupdate);

        mDatabaseHelper = new FDdatabase(this);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameEntry = name.getText().toString();
                String occupationEntry = occupation.getText().toString();
                String adharnoEntry = adharno.getText().toString();
                String placeEntry = place.getText().toString();
                String pinEntry = pin.getText().toString();
                String noEntry = no.getText().toString();

                if (nameEntry.length() != 0 && occupationEntry.length() != 0 && adharnoEntry.length() == 12 && placeEntry.length() != 0 && pinEntry.length() == 6 && noEntry.length() != 0){
                    AddData(nameEntry,occupationEntry,adharnoEntry,placeEntry,pinEntry,noEntry);
                    name.setText("");
                    occupation.setText("");
                    adharno.setText("");
                    place.setText("");
                    pin.setText("");
                    no.setText("");
                } else {
                    Toast.makeText(Register.this,"Plz enter valid credentials",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void AddData(String nameEntry,String occupationEntry,String adharnoEntry,String placeEntry,String pinEntry,String noEntry){
        boolean insertData = mDatabaseHelper.addData(nameEntry,occupationEntry,adharnoEntry,placeEntry,pinEntry,noEntry);
        if (insertData == true){
            Toast.makeText(Register.this,"Registration successful",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(Register.this,"Something went wrong",Toast.LENGTH_SHORT).show();
        }
    }
}