package com.example.tp_3_2024.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tp_3_2024.R;
import com.example.tp_3_2024.view.DetailsActivity;
import com.example.tp_3_2024.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MainActivityMoviesAdapter extends RecyclerView.Adapter<MainActivityMoviesAdapter.ViewHolder> {

    private Context context;
    private List<Movie> movies;
    private LayoutInflater inflater;

    public MainActivityMoviesAdapter(Context context, List<Movie> movies, LayoutInflater inflater) {
        this.context = context;
        this.movies = movies;
        this.inflater = inflater;
    }

    @NonNull
    @Override
    public MainActivityMoviesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = inflater.inflate(R.layout.card_view, parent, false);
        return new ViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Log.d("miApp", "onBindViewHolder: ");
        Movie movie = movies.get(position);
        holder.title.setText(movie.getTitle());
        holder.plot.setText(movie.getPlot());
        if(movie.getCover_id() > 0){
            holder.cover.setImageResource(movie.getCover_id());
        }
        //holder.cover.setImageResource(movies.get(position).getCover_id());
        holder.detailsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("miApp", "hola: ");
                Bundle bundle = new Bundle();
                bundle.putSerializable("movie", movies.get(position));
                Intent intent = new Intent(context, DetailsActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("movie", bundle);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class  ViewHolder extends RecyclerView.ViewHolder {

        ImageView cover;
        TextView title, plot;
        Button detailsBtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cover = (ImageView) itemView.findViewById(R.id.movie_cover);
            title = (TextView) itemView.findViewById(R.id.movie_title);
            plot = (TextView) itemView.findViewById(R.id.movie_summary);
            detailsBtn = (Button) itemView.findViewById(R.id.movie_details_btn);
        }
    }
}