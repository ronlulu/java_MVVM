package com.ronlu.mvvm_movie.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Movie {
    @SerializedName("title")
    private String title;
    @SerializedName("description")
    private String description;
    @SerializedName("genre")
    private ArrayList<String> genre;
    @SerializedName("rating")
    private String rating;
    @SerializedName("year")
    private short year;
    @SerializedName("thumbnail")
    private String imagePath;

    public Movie() {}

    public Movie(String title, String description, ArrayList<String> genre, String rating, short year, String thumbnail) {
        this.title = title;
        this.description = description;
        this.genre = genre;
        this.rating = rating;
        this.year = year;
        this.imagePath = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public ArrayList<String> getGenre() {
        return genre;
    }

    public void setGenre(ArrayList<String> genre) {
        this.genre = genre;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public short getYear() {
        return year;
    }

    public void setYear(short year) {
        this.year = year;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", genre='" + genre + '\'' +
                ", rating='" + rating + '\'' +
                ", year=" + year +
                ", image='" + imagePath + '\'' +
                '}';
    }
}
