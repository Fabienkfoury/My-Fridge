package com.example.fabien.fridgeandrecipies;

/**
 * Created by kfouryf on 10/11/2016.
 */
public class Food {             // un aliments est caracterise par ces attributs

    private String name;
    private int Quantity;
    private int photo;
    private int expiration_date;

    public Food(int expiration_date, String name, int quantity, int photo) {
        this.expiration_date = expiration_date;
        this.name = name;
        Quantity = quantity;
        this.photo = photo;
    }

    public int getExpiration_date() {
        return expiration_date;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return Quantity;
    }

    public int getPhoto() {
        return photo;
    }


}
