package com.marchsoft.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;
@JsonIgnoreProperties(value = { "handler" })
public class Movie implements Serializable {
    private int id;
    private String name;
    private long date;
    private String country;
    private String motto;
    private float rating;

    public Movie(){}

    public Movie(String name, long date, String country, String motto, float rating, List<Genre> genres) {
        this.name = name;
        this.date = date;
        this.country = country;
        this.motto = motto;
        this.rating = rating;
        this.genres = genres;
    }

    //多对多的关系映射，一部电影对应多种类型
    private List<Genre> genres;

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year=" + date +
                ", country='" + country + '\'' +
                ", motto='" + motto + '\'' +
                ", rating=" + rating +
                '}';
    }
}
