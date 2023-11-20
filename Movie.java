package com.example.retrofitapp.retrofitmovieapi;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Movie {

    @SerializedName("results")

    private List<Movie> results = null;

    public List<Movie> getResults() {
        return results;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public String getTittle() {
        return tittle;
    }

    public String getOverview() {
        return overview;
    }

    @SerializedName("poster_path")
    private String posterPath;

    @SerializedName("title")
    private String tittle;

    @SerializedName("overview")
    private String overview;
}
