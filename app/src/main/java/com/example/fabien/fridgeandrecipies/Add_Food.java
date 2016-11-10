package com.example.fabien.fridgeandrecipies;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class Add_Food extends AppCompatActivity {             // For the DatePicker

    public static final String KEY_NAME = "keyname";
    public static final String KEY_QUANTITY = "keyquantity";                      // Key are here for the putExtra
    public static final String KEY_EXPIRATION_DATE = "keyexpirationdate";
    public static final String KEY_DAY="keyday";
    public static final String KEY_MONTH="keymonth";
    public static final String KEY_YEAR="keyyear";


    private Spinner spinnerQuantity;
    private EditText EditTextName;
    public static EditText EditTexteExpirationDate;

    private String[] NumberQuantity;
    private String Quantity;

    static final int DATE_DIALOG_ID = 999;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__food);

        spinnerQuantity = (Spinner) findViewById(R.id.spinnerQuantity);
        EditTextName = (EditText) findViewById(R.id.inputName);
        //EditTexteExpirationDate = (EditText) findViewById(R.id.inputExpirationDate);

        NumberQuantity = getResources().getStringArray(R.array.NumberQuantity);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, NumberQuantity);  // J'essaye avec un arrayadapter de Int( ça marche pas, je met String)
        spinnerQuantity.setAdapter(arrayAdapter);
        spinnerQuantity.setOnItemSelectedListener(

                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        Quantity = NumberQuantity[position];
                        Toast.makeText(getBaseContext(), NumberQuantity[position] + " quantity selected", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        Quantity = "0";
                    }
                }
        );

        final Calendar c = Calendar.getInstance();
        EditTexteExpirationDate= (EditText)findViewById(R.id.expirationDATE);
        EditTexteExpirationDate.setHint( c.get(Calendar.DAY_OF_MONTH)+ "/" + c.get(Calendar.MONTH) + "/"+c.get(Calendar.YEAR) );

        EditTexteExpirationDate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {                         // Pour que dés qu'on click 1 fois ça ouvre le datepicker ( ça marche pas encore )
                // TODO Auto-generated method stub
                showDatePickerDialog(v);
            }
        });
    }

    public void onAddClick(View v) {
        if( EditTextName.getText().toString()!=null && DatePickerFragment.day !=0) {
            Intent intent = new Intent(Add_Food.this, MainActivity.class);
            //intent.setAction("com.example.fabien.fridgeandrecipies.Add_Food");
            intent.putExtra(KEY_DAY, DatePickerFragment.day);
            intent.putExtra(KEY_MONTH, DatePickerFragment.month);            // Je cherche à envoyer les données dans le main
            intent.putExtra(KEY_YEAR, DatePickerFragment.year);
            intent.putExtra(KEY_QUANTITY, Quantity);
            //Uri uri = Uri.parse(EditTextName.getText().toString());
            // intent.setData(uri);
            // Toast.makeText(getBaseContext(), Quantity + " " + EditTextName.getText().toString().toUpperCase() + " add to your fridge", Toast.LENGTH_SHORT).show();
            // } // .getText().toString permet de lire depuis l'id , l'edit text
            // Bundle bundle = new Bundle();
            intent.putExtra(KEY_NAME, EditTextName.getText().toString());
            startActivity(intent);
        }
        else
        Toast.makeText(getBaseContext(), "Missing Value", Toast.LENGTH_SHORT).show();

    }
    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }


}
