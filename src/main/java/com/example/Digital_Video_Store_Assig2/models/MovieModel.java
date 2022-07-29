package com.example.Digital_Video_Store_Assig2.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("movies")
public class MovieModel {
    @Id
    private String id;
    private String Title;
    private int Year;
    private String Type;
    private String Featured;
    private String Poster;
    private String  Description;
    private String  Big;
    private int Rent;
    private int Buy;

    public MovieModel(){

    }
    public MovieModel(String id, String title, int year, String type, String featured, String poster, String description, String big, int rent, int buy) {
        this.id = id;
        Title = title;
        Year = year;
        Type = type;
        Featured = featured;
        Poster = poster;
        Description = description;
        Big = big;
        Rent = rent;
        Buy = buy;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        Year = year;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getFeatured() {
        return Featured;
    }

    public void setFeatured(String featured) {
        Featured = featured;
    }

    public String getPoster() {
        return Poster;
    }

    public void setPoster(String poster) {
        Poster = poster;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getBig() {
        return Big;
    }

    public void setBig(String big) {
        Big = big;
    }

    public int getRent() {
        return Rent;
    }

    public void setRent(int rent) {
        Rent = rent;
    }

    public int getBuy() {
        return Buy;
    }

    public void setBuy(int buy) {
        Buy = buy;
    }

    @Override
    public String toString() {
        return "MovieModel{" +
                "id='" + id + '\'' +
                ", Title='" + Title + '\'' +
                ", Year=" + Year +
                ", Type='" + Type + '\'' +
                ", Featured='" + Featured + '\'' +
                ", Poster='" + Poster + '\'' +
                ", Description='" + Description + '\'' +
                ", Big='" + Big + '\'' +
                ", Rent=" + Rent +
                ", Buy=" + Buy +
                '}';
    }
}
