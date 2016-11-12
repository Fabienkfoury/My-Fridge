package com.example.fabien.fridgeandrecipies;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.fabien.fridgeandrecipies.Food;

/**
 * Created by Fabien on 11/11/2016.
 */

public class DatabaseHandler extends SQLiteOpenHelper {



    private static final String DATABASE_NAME = "Food_Added";

    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_FOOD = "food";

    private static final String KEY_NAME = "name";
    private static final String KEY_QUANTITY = "quantity";
    private static final String KEY_PHOTO = "photo";
    private static final String KEY_DATE = "expirationDate";

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE" + TABLE_FOOD +"("+KEY_NAME +"INTEGER PRIMARY KEY,"+KEY_QUANTITY+"," +KEY_PHOTO+"," + KEY_DATE +" )" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FOOD);
        onCreate(db);
    }

    public DatabaseHandler(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void addFood(Food food) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, food.getName());
       // values.put(KEY_PHOTO, food.getPhoto());
        values.put(KEY_DATE,food.getExpiration_date());
        values.put(KEY_QUANTITY,food.getQuantity());

        long Insertion_ok=db.insert(TABLE_FOOD, null, values);

        if (Insertion_ok > 0) {
            Log.d("dbhelper", "inserted successfully");
        } else {
            Log.d("dbhelper", "failed to insert");
        }
        db.close();
    }

    public Food getFood(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_FOOD, new String[] { KEY_NAME, KEY_QUANTITY, KEY_PHOTO,KEY_DATE}, KEY_NAME + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Food food = new Food(cursor.getString(0),cursor.getString(1), cursor.getString(2) );

        return food;
    }


}
