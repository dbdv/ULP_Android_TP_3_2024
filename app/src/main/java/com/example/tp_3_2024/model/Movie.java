package com.example.tp_3_2024.model;

import java.io.Serializable;

public class Movie implements Serializable {
    private String title;
    private String plot;
    private String director;
    private String cast;

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    private String coverUrl;
    private int cover_id;

    public Movie(String title, String plot, String director, String cast) {
        this.title = title;
        this.plot = plot;
        this.director = director;
        this.cast = cast;
    }

    public Movie(String title, String plot, String director, String cast, int cover_id) {
        this.title = title;
        this.plot = plot;
        this.director = director;
        this.cast = cast;
        this.cover_id = cover_id;
    }

    public Movie(String title, String plot, String director, String cast, String coverUrl) {
        this.title = title;
        this.plot = plot;
        this.director = director;
        this.cast = cast;
        this.coverUrl = coverUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public int getCover_id() {
        return cover_id;
    }

    public void setCover_id(int cover_id) {
        this.cover_id = cover_id;
    }
}