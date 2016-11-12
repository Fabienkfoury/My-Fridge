package com.example.fabien.fridgeandrecipies;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by kfouryf on 10/11/2016.
 */
public class ImageFoodAdapter extends BaseAdapter{

    private int[] FoodPhotos ;
    private String[] FoodNames ;
    private String[] FoodQuantity;
    private String [] ExpirationDate;
    private Context context;


    public ImageFoodAdapter(Context context,int[] foodPhotos, String[] foodNames, String[] foodQuantity, String[] expirationDate) {
        FoodPhotos = foodPhotos;
        FoodNames = foodNames;
        FoodQuantity = foodQuantity;
        ExpirationDate = expirationDate;
        this.context = context;
    }

    @Override
    public int getCount() {
        return FoodPhotos.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    public View getView(int position, View convertView, ViewGroup parent) {
//        ImageView imageView;
//
//        if (convertView == null) {
//            imageView = new ImageView(context);
//            imageView.setLayoutParams(new GridView.LayoutParams(200, 200));
//            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
//            imageView.setPadding(8, 8, 8, 8);
//        } else {
//            imageView = (ImageView) convertView;
//
//        }
//
//        imageView.setImageResource(FoodPhotos[position]);
//        //textView.setText(FoodNames[position]);
//        return imageView;

        View grid;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            grid = new View(context);
            grid = inflater.inflate(R.layout.activity_grid_view, null);

            TextView textViewName = (TextView) grid.findViewById(R.id.namefood);
            TextView textViewQuantity = (TextView) grid.findViewById(R.id.quantityfood);
            TextView textViewDate = (TextView) grid.findViewById(R.id.Expirationfood);
            ImageView imageView = (ImageView)grid.findViewById(R.id.Foodicon);

            textViewName.setText(FoodNames[position]);
            textViewName.setTypeface(null, Typeface.BOLD);
            textViewQuantity.setText("Quantity : " +FoodQuantity[position]);
            textViewDate.setText(ExpirationDate[position]);
            textViewDate.setTypeface(null, Typeface.BOLD);
            imageView.setImageResource(FoodPhotos[position]);
        } else {
            grid = (View) convertView;
        }

        return grid;
    }
}
