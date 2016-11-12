package com.example.fabien.fridgeandrecipies;

/**
 * Created by kfouryf on 10/11/2016.
 */
public class Food {             // un aliments est caracterise par ces attributs

    private String name;
    private String Quantity;
    //private int photo;
    private String expiration_date;

    public Food(String expiration_date, String name, String quantity) {
        this.expiration_date = expiration_date;
        this.name = name;
        Quantity = quantity;
       // this.photo = photo;
    }

    public String getExpiration_date() {
        return expiration_date;
    }

    public String getName() {
        return name;
    }

    public String getQuantity() {
        return Quantity;
    }

//    public int getPhoto() {
//        return photo;
//    }

    public void setExpiration_date(String expiration_date) {
        this.expiration_date = expiration_date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

//    public void setPhoto(int photo) {
//        this.photo = photo;
//    }
}
