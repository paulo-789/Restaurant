package com.example.myapplication;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
     String Name;
     String Phone;
     String Website;
     double Rating;
     String ImageUrl;
     List<String> Address = new ArrayList<>();
     double Latitude;
     double Longitude;
    List<String> Categories = new ArrayList<>();

    public Restaurant(){}

    public Restaurant(String name,String phone,String website,double rating,String imageUrl, ArrayList<String> address,double latitude,double longitude,ArrayList<String> categories){
        this.Name = name;
        this.Phone = phone;
        this.Website = website;
        this.Rating = rating;
        this.ImageUrl = imageUrl;
        this.Address = address;
        this.Latitude = latitude;
        this.Longitude = longitude;
        this.Categories = categories;
    }
    public String getName(){
        return Name;
    }
    public  String getPhone(){
        return Phone;
    }
    public String getWebsite() {
        return  Website;
    }

    public double getRating() {
        return Rating;
    }

    public String getImageUrl(){
        return ImageUrl;
    }

    public List<String> getAddress() {
        return Address;
    }

    public double getLatitude() {
        return Latitude;
    }

    public double getLongitude() {
        return Longitude;
    }

    public List<String> getCategories() {
        return Categories;
    }
    public String getLargeImageUrl(String imageUrl) {
        String largeImageUrl = imageUrl.substring(0, imageUrl.length() - 6).concat("o.jpg");
        return largeImageUrl;
    }

}
