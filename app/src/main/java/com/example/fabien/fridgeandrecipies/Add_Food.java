package com.example.fabien.fridgeandrecipies;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class Add_Food extends AppCompatActivity {             // For the DatePicker

    public static final String KEY_NAME = "keyname";
    public static final String KEY_QUANTITY = "keyquantity";                      // Key are here for the putExtra
    public static final String KEY_DATE = "keyexpirationdate";


    private Spinner spinnerQuantity;
    private EditText EditTextName;
    public static EditText EditTexteExpirationDate;

    String selectionAutoComplete;
    private String[] NumberQuantity;
    private String Quantity;

    private Button btnAdd;

    static final int DATE_DIALOG_ID = 999;

    private String[] Ingredients = new String[]
{   "Apple","Apple juice","Apple sauce","Avocado","Aubergine","Artichoke","Bacon","Basil",
        "Beans","Beef","Berry","Blueberry","Broccoli","Butter","Buttermilk","Milk",
        "Sausage","Egg","Mustard","Ham","Hummus","Cucomber","Salat","Honey","Harricot",
        "Carrotes","Feta","Goat cheese","Salami","Sardine","Salmon","Smoked Salmon",
        "Tomato","Olive","Corn",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__food);

        spinnerQuantity = (Spinner) findViewById(R.id.spinnerQuantity);
        EditTextName = (EditText) findViewById(R.id.autoCompleteTextView1);
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


        ArrayAdapter<String> ingredientAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,Ingredients);      // AutoComplete
        AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
        textView.setAdapter(ingredientAdapter);

        textView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long rowId) {
                Log.i("SELECTED TEXT WAS--->", (String)parent.getItemAtPosition(position));
                 selectionAutoComplete = (String)parent.getItemAtPosition(position);        // Récupère la valeur du autocomplete
                //TODO Do something with the selected text
            }
        });

    }

    public void onAddClick(View v) {
        if( EditTextName.getText().toString()!=null && DatePickerFragment.day !=0) {
            DatabaseHandler db= new DatabaseHandler(this);
            Intent intent = new Intent(Add_Food.this, MainActivity.class);

            //intent.setAction("com.example.fabien.fridgeandrecipies.Add_Food");
//            intent.putExtra(KEY_DAY, DatePickerFragment.day);
//            intent.putExtra(KEY_MONTH, DatePickerFragment.month);
//            intent.putExtra(KEY_YEAR, DatePickerFragment.year);

            String Date=DatePickerFragment.day +"/" +DatePickerFragment.month +"/"+ DatePickerFragment.year;
            intent.putExtra(KEY_QUANTITY, Quantity);
            intent.putExtra(KEY_DATE, Date);
            intent.putExtra(KEY_NAME, selectionAutoComplete);

            db.addFood(new Food(Date,selectionAutoComplete,Quantity));


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
