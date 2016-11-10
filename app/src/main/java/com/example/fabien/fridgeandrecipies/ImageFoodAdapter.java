package com.example.fabien.fridgeandrecipies;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by kfouryf on 10/11/2016.
 */
public class ImageFoodAdapter extends BaseAdapter{

    private int[] FoodPhotos =   MainActivity.FoodPhotos;
    private Context context;

    public ImageFoodAdapter(Context context) {
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
        ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(200, 200));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(FoodPhotos[position]);
        return imageView;
    }
}
