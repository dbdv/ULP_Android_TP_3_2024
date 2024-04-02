package com.example.tp_3_2024.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.example.tp_3_2024.R;
import com.example.tp_3_2024.adapter.MainActivityMoviesAdapter;
import com.example.tp_3_2024.databinding.ActivityMainBinding;
import com.example.tp_3_2024.model.Movie;
import com.example.tp_3_2024.viewModel.MainActivityVM;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private MainActivityVM viewModel;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        context = getApplicationContext();
        RecyclerView recyclerView = findViewById(R.id.main_recycler_view);//(RecyclerView) binding.mainRecyclerView;

        viewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityVM.class);

        GridLayoutManager grid = new GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(grid);

        MainActivityMoviesAdapter baseAdapter = new MainActivityMoviesAdapter(this, new ArrayList<>(), getLayoutInflater());
        if(baseAdapter == null){
            Log.d("miApp", "no crea el adapter ");
        }else{
            Log.d("miApp", "crea el adapter ");
        }
        recyclerView.setAdapter(baseAdapter);
        viewModel.getMovies().observe(this, movies -> {
            Log.d("miApp", "llega al observe ");
            Log.d("miApp", "size " + movies.size());
            if (movies.size() < 1){
                viewModel.fetchMovies();
            }else{
                //List<Movie> movies = viewModel.getMovies().getValue();
                MainActivityMoviesAdapter adapter = new MainActivityMoviesAdapter(this, movies, getLayoutInflater());
                Log.d("miApp", "llega al seteo del adapter ");
                recyclerView.setAdapter(adapter);
            }
        });

        viewModel.fetchMovies();
    }
}