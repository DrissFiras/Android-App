package com.example.yasmine.myapp1;

import android.annotation.TargetApi;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.content.Intent;

import android.icu.util.GregorianCalendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.ArrayList;
import android.app.Activity;
import android.os.Bundle;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.TextView;

import junit.framework.Test;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.List;

public class NewPublication extends Home implements OnItemSelectedListener  {
    private Button sub ;
    private String type;
    private String titl ;
    private String description ;
    private Button mark ;

   final long lat=0 , lon=0 ;
    DateFormat fmtDateAndTime=DateFormat.getDateTimeInstance();
    TextView dateAndTimeLabel;
    Calendar dateAndTime=Calendar.getInstance();
    DatePickerDialog.OnDateSetListener d=new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            dateAndTime.set(Calendar.YEAR, year);
            dateAndTime.set(Calendar.MONTH, monthOfYear);
            dateAndTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabel();
        }
    };
    TimePickerDialog.OnTimeSetListener t=new TimePickerDialog.OnTimeSetListener() {
        public void onTimeSet(TimePicker view, int hourOfDay,
                              int minute) {
            dateAndTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
            dateAndTime.set(Calendar.MINUTE, minute);
            updateLabel();
        }
    };
    private void updateLabel() {
        dateAndTimeLabel.setText(fmtDateAndTime.format(dateAndTime.getTime()));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_publication);
        //-------

        Button btn=(Button)findViewById(R.id.dateBtn);

        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                new DatePickerDialog(NewPublication.this,
                        d,
                        dateAndTime.get(Calendar.YEAR),
                        dateAndTime.get(Calendar.MONTH),
                        dateAndTime.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        btn=(Button)findViewById(R.id.timeBtn);

        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                new TimePickerDialog(NewPublication.this,
                        t,
                        dateAndTime.get(Calendar.HOUR_OF_DAY),
                        dateAndTime.get(Calendar.MINUTE),
                        true).show();
            }
        });

        dateAndTimeLabel=(TextView)findViewById(R.id.dateAndTime);

        updateLabel();
        //----
        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        Intent intent = getIntent();
         intent.getLongExtra("lon",lon);
         intent.getLongExtra("lat",lat);



        // Spinner click listener
        spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Sport");
        categories.add("Culture");
        categories.add("Community");
        categories.add("Cinema");
        categories.add("Entertainment");
        categories.add("Other");


        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

        EditText title=(EditText) findViewById(R.id.title);
         titl = title.getText().toString();

        //EditText typ =(EditText) findViewById(R.id.type);
        // type = typ.getText().toString();

        EditText desc=(EditText) findViewById(R.id.description);
         description = desc.getText().toString();

        mark=(Button) findViewById(R.id.setlocation);
        mark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),NewMarker.class);
                startActivity(i);
            }
        });

        sub=(Button) findViewById(R.id.submit );
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MyList.add(new Publication("Firas",titl,"Sport",description, dateAndTime.toString(),lat,lon));
                Intent s = new Intent(getApplicationContext(), Home.class);
                startActivity(s);

            }});





    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }







}
