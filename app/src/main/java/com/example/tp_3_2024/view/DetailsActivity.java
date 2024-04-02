package com.example.tp_3_2024.view;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tp_3_2024.R;
import com.example.tp_3_2024.databinding.ActivityDetailsBinding;
import com.example.tp_3_2024.databinding.ActivityMainBinding;
import com.example.tp_3_2024.model.Movie;


public class DetailsActivity extends AppCompatActivity {
    ActivityDetailsBinding binding;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        context = getApplicationContext();
        binding.backBtn.setOnClickListener(view -> {
            finish();
        });
        initView();
    }

    private void initView() {
        Bundle bundle = getIntent().getBundleExtra("movie");
        Movie movie = (Movie) bundle.getSerializable("movie");
        if(movie.getCover_id() > 0){

            ((ImageView) binding.cover).setImageResource(movie.getCover_id());

        }
        ((TextView) binding.cast).setText("Cast: "+movie.getCast());
        ((TextView) binding.director).setText("Director: "+movie.getDirector());
        ((TextView) binding.plot).setText(movie.getPlot());
        ((TextView) binding.title).setText(movie.getTitle());
        Log.d("miApp", "title: "+movie.getTitle());
    }
}