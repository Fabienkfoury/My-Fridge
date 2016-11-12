package com.example.fabien.fridgeandrecipies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;

import com.shamanland.fab.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public FloatingActionButton fab;

    private static final int REQUEST_EDIT = 1234;

    private TextView textView;

    private EditText editText;
     GridView gridview;

    public static String[] FoodNames;
   public static String[] FoodQuantity;
    public static String [] ExpirationDate;
    public static int[] FoodPhotos = {
            R.drawable.cucumber,
            R.drawable.tomato
                     // Tableau d'aliments
    };
    private ArrayList<Food> Foods = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        myToolbar.setTitle("My Fridge");
        setSupportActionBar(myToolbar);

        //textView =(TextView)findViewById(R.id.textviewPut);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        //fab.setSize(FloatingActionButton.SIZE_NORMAL);
        //fab.setColor(Color.RED);
        // NOTE invoke this method after setting new values!
        fab.initBackground();
        // NOTE standard method of ImageView
        //fab.setImageResource(R.drawable.ic_add_black_24dp);
        FoodNames = getResources().getStringArray(R.array.FoodNames);
        FoodQuantity = getResources().getStringArray(R.array.FoodQuantity);
        ExpirationDate = getResources().getStringArray(R.array.ExpirationDate);

        gridview = (GridView)findViewById(R.id.gridViewLayout);
        gridview.setAdapter(new ImageFoodAdapter(this,FoodPhotos,FoodNames,FoodQuantity,ExpirationDate));

        //generateFoods();

        StringBuilder messageFromAddFood = new StringBuilder();
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        messageFromAddFood.append("Quantity: " + intent.getStringExtra(Add_Food.KEY_QUANTITY) + System.getProperty("line.separator")); // String Extrat important
        //Car c'est un spinner et donc un string
        messageFromAddFood.append("Name: " + intent.getStringExtra(Add_Food.KEY_NAME) + System.getProperty("line.separator"));
        messageFromAddFood.append("Expiration Date :" + intent.getStringExtra(Add_Food.KEY_DATE)+System.getProperty("line.separator"));

        //textView.setText(messageFromAddFood);
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

//    private void generateFoods()
//    {
//        for (int i = 0; i < FoodPhotos.length; i++) {
//            Foods.add(new Food(ExpirationDate[i],FoodNames[i], FoodQuantity[i],FoodPhotos[i] ) );
//        }
//    }
    public void AddFood()
    {
        // Add/insert item to ArrayAdapter
        // Insert at the end of ArrayAdapter
        // ArrayAdapter is zero based index
        Intent intent = getIntent();
        String ExpirationDateData = intent.getStringExtra(Add_Food.KEY_DATE) ;
        String FoodNamesData = intent.getStringExtra(Add_Food.KEY_NAME);
        String FoodQuantityDate =intent.getStringExtra(Add_Food.KEY_QUANTITY);

//        final List<String> NameList = new ArrayList<String>(Arrays.asList(plants));
//        Foods.add(new Food (ExpirationDate,intent.getStringExtra(Add_Food.KEY_NAME),intent.getStringExtra(Add_Food.KEY_QUANTITY),));
//
//        // Update the GridView
//        gridViewArrayAdapter.notifyDataSetChanged();
//
//        // Get the newly added item from ArrayAdapter
//        String addedItemText = plantsList.get(plantsList.size()-1);
//
//        // Confirm the addition
//        Toast.makeText(getApplicationContext(),
//                "Item added : " + addedItemText, Toast.LENGTH_SHORT).show();

    }


}
