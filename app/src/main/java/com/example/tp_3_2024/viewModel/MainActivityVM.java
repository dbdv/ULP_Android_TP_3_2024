package com.example.tp_3_2024.viewModel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tp_3_2024.model.Movie;
import com.example.tp_3_2024.provider.MovieProvider;

import java.util.List;

public class MainActivityVM extends ViewModel {
    MutableLiveData<List<Movie>> movies = new MutableLiveData<>();

    public MutableLiveData<List<Movie>> getMovies() {
        return movies;
    }

    public void setMovies(MutableLiveData<List<Movie>> movies) {
        this.movies = movies;
    }

    public void fetchMovies(){
        Log.d("miApp", "fetching movies ");
        List<Movie> movies = MovieProvider.fetchMovies();
        this.movies.setValue(movies);
    }

}
