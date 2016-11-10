package com.example.fabien.fridgeandrecipies;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

/**
 * Created by Fabien on 06/11/2016.
 */

public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    public static int year;
    public static int month;
    public static  int day;
    private static final String KEY_DAY="keyday";
    private static final String KEY_MONTH="keymonth";
    private static final String KEY_YEAR="keyyear";

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    public void onDateSet(DatePicker view, int y, int m, int d) {
        year = y;
        month = m+1;
        day = d;

        Add_Food.EditTexteExpirationDate.setText(d+ "/" + m + "/"+ y);   // Je modfie le text du EditText pour la date d'expiration
        // J'ai mis le "EditTexteExpirationDate" de Add_Food en public static pour pouvoir l'appeler ici dans le fragment
    }
}
