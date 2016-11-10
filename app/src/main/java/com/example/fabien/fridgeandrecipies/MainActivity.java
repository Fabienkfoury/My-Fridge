package com.example.fabien.fridgeandrecipies;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.shamanland.fab.FloatingActionButton;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    public FloatingActionButton fab;

    private static final int REQUEST_EDIT = 1234;

    private int year;
    private int month;
    private int day;

    private TextView textView;

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        myToolbar.setTitle("My Fridge");
        setSupportActionBar(myToolbar);

        textView=(TextView)findViewById(R.id.textviewPut);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        //fab.setSize(FloatingActionButton.SIZE_NORMAL);
        //fab.setColor(Color.RED);
        // NOTE invoke this method after setting new values!
        fab.initBackground();
        // NOTE standard method of ImageView
        //fab.setImageResource(R.drawable.ic_add_black_24dp);

       StringBuilder messageFromAddFood = new StringBuilder();
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        messageFromAddFood.append("Quantity: " + intent.getStringExtra(Add_Food.KEY_QUANTITY) + System.getProperty("line.separator")); // String Extrat important
        //Car c'est un spinner et donc un string
        messageFromAddFood.append("Name: " + intent.getStringExtra(Add_Food.KEY_NAME) + System.getProperty("line.separator"));
        messageFromAddFood.append("Year:" + intent.getIntExtra(Add_Food.KEY_YEAR,0)+System.getProperty("line.separator"));
        messageFromAddFood.append("Month:" + intent.getIntExtra(Add_Food.KEY_MONTH,0)+System.getProperty("line.separator"));
        messageFromAddFood.append("Day:" + intent.getIntExtra(Add_Food.KEY_DAY,0)+System.getProperty("line.separator"));

        textView.setText(messageFromAddFood);
    }

    public void OnButtonClick(View v)
    {
        switch(v.getId()) {
            case R.id.fab :
            startActivity(new Intent(this, Add_Food.class));
                break;
            case R.id.GoToRecipes:
                startActivity(new Intent(this,Recipes.class));
                break;
        }
    }

}
