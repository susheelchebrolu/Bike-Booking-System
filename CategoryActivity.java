package com.example.hp.rideabike;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class CategoryActivity extends FragmentActivity {
    static EditText DateEdit,TimeEdit;
    RadioGroup groupradio,choosecategory,wfavailiblepack,wofavailiblepack;
    TextView availiblepackhead,availiblepackheadtwo,amount;
    EditText e1;
    RadioButton availiblepackone,availiblepacktwo,availiblepackthree,availiblepackfour,wofavailiblepackone,wofavailiblepacktwo,wofavailiblepackthree,vaddeswaram,other;
    int a,h=30,i,j;
    Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        next=findViewById(R.id.next);
        DateEdit = (EditText) findViewById(R.id.fromdate);
        TimeEdit = (EditText) findViewById(R.id.todate);
        RadioGroup groupradio=(RadioGroup)findViewById(R.id.choosepickup);
        RadioGroup choosecategory=(RadioGroup)findViewById(R.id.choosecategory);
        final RadioGroup wfavailiblepack=(RadioGroup)findViewById(R.id.wfavailiblepack);
        final RadioGroup wofavailiblepack=(RadioGroup)findViewById(R.id.wofavailiblepack);
        final EditText e1=(EditText)findViewById(R.id.pickupaddress);
        final TextView availiblepackhead=findViewById(R.id.availiblepackhead);
        final TextView availiblepackheadtwo=findViewById(R.id.availiblepackheadtwo);
        final TextView amoun=findViewById(R.id.amount);
        final RadioButton oneavailiblepack=findViewById(R.id.availiblepackone);
        final RadioButton twoavailiblepack=findViewById(R.id.availiblepacktwo);
        final RadioButton threeavailiblepack=findViewById(R.id.availiblepackthree);
        final RadioButton fouravailiblepack=findViewById(R.id.availiblepackfour);
        final RadioButton onewofavailiblepack=findViewById(R.id.wofavailiblepackone);
        final RadioButton twowofavailiblepack=findViewById(R.id.wofavailiblepacktwo);
        final RadioButton threewofavailiblepack=findViewById(R.id.wofavailiblepackthree);
        final RadioButton vaddeswaram=findViewById(R.id.vaddeswaram);
        final RadioButton other=findViewById(R.id.other);
        DateEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTruitonTimePickerDialog(v);
                showTruitonDatePickerDialog(v);
            }
        });
        TimeEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePickerDialog(v);
                showDatePickerDialog(v);
            }
        });
        e1.setVisibility(View.GONE);
        wfavailiblepack.setVisibility(View.GONE);
        wofavailiblepack.setVisibility(View.GONE);
        availiblepackhead.setVisibility(View.GONE);
        availiblepackheadtwo.setVisibility(View.GONE);
        groupradio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId==R.id.vaddeswaram){
                    e1.setVisibility(View.GONE);
                }
                else if (checkedId==R.id.other){
                    e1.setVisibility(View.VISIBLE);
                }
            }
        });
        choosecategory.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId==R.id.withfuel){
                    availiblepackhead.setVisibility(View.VISIBLE);
                    wfavailiblepack.setVisibility(View.VISIBLE);
                    availiblepackheadtwo.setVisibility(View.GONE);
                    wofavailiblepack.setVisibility(View.GONE);
                }
                else if (checkedId==R.id.withoutfuel){
                    availiblepackheadtwo.setVisibility(View.VISIBLE);
                    wofavailiblepack.setVisibility(View.VISIBLE);
                    availiblepackhead.setVisibility(View.GONE);
                    wfavailiblepack.setVisibility(View.GONE);

                }
            }
        });
        View.OnClickListener button1Listener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                amoun.setText("69rs");
            }
        };
        View.OnClickListener button2Listener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                amoun.setText("139rs");
            }
        };
        View.OnClickListener button3Listener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                amoun.setText("209rs");
            }
        };
        View.OnClickListener button4Listener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                amoun.setText("279rs");
            }
        };
        View.OnClickListener button5Listener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                amoun.setText("240rs");
            }
        };
        View.OnClickListener button6Listener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                amoun.setText("360rs");
            }
        };
        View.OnClickListener button7Listener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                amoun.setText("499rs");
            }
        };
        oneavailiblepack.setOnClickListener(button1Listener);
        twoavailiblepack.setOnClickListener(button2Listener);
        threeavailiblepack.setOnClickListener(button3Listener);
        fouravailiblepack.setOnClickListener(button4Listener);
        onewofavailiblepack.setOnClickListener(button5Listener);
        twowofavailiblepack.setOnClickListener(button6Listener);
        threewofavailiblepack.setOnClickListener(button7Listener);
    }
    public void showTruitonDatePickerDialog(View v) {
        DialogFragment newFragment = new CategoryActivity.DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public static class DatePickerFragment extends DialogFragment implements
            DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            // Do something with the date chosen by the user
            DateEdit.setText(day + "/" + (month + 1) + "/" + year);
        }
    }

    public void showTruitonTimePickerDialog(View v) {
        DialogFragment newFragment = new CategoryActivity.TimePickerFragment();
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }

    public static class TimePickerFragment extends DialogFragment implements
            TimePickerDialog.OnTimeSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current time as the default values for the picker
            final Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);

            // Create a new instance of TimePickerDialog and return it
            return new TimePickerDialog(getActivity(), this, hour, minute,
                    DateFormat.is24HourFormat(getActivity()));
        }

        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            // Do something with the time chosen by the user
            DateEdit.setText(DateEdit.getText() + " -" + hourOfDay + ":" + minute);
        }
    }
    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new CategoryActivity.DatePickerFragmen();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public static class DatePickerFragmen extends DialogFragment implements
            DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            // Do something with the date chosen by the user
            TimeEdit.setText(day + "/" + (month + 1) + "/" + year);
        }
    }

    public void showTimePickerDialog(View v) {
        DialogFragment newFragment = new CategoryActivity.TimePickerFragmen();
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }

    public static class TimePickerFragmen extends DialogFragment implements
            TimePickerDialog.OnTimeSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current time as the default values for the picker
            final Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);

            // Create a new instance of TimePickerDialog and return it
            return new TimePickerDialog(getActivity(), this, hour, minute,
                    DateFormat.is24HourFormat(getActivity()));
        }

        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            // Do something with the time chosen by the user
            TimeEdit.setText(TimeEdit.getText() + " -" + hourOfDay + ":" + minute);
        }
    }
    public void next(View view){
        Toast.makeText(this, "Booking Done Successfully", Toast.LENGTH_SHORT).show();
        Intent i=new Intent(this,BookConfirm.class);
        startActivity(i);
    }
}
