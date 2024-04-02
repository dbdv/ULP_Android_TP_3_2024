package com.example.tp_3_2024.provider;

import com.example.tp_3_2024.R;
import com.example.tp_3_2024.model.Movie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import kotlin.ranges.ClosedRange;

public class MovieProvider {

    public static List<Movie> fetchMovies(){

        String lorem = "    Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
        List<Movie> movies = new ArrayList<>(
            Arrays.asList(
                new Movie("Piratas del Caribe", "Piratas en busca de tesoros"+ lorem, "Espen Sandberg", "Johnny Depp", R.drawable.piratas_del_caribe),
                new Movie("Buscando a Nemo", "Un pez en busca de su hijo"+lorem, "Andrew Staton", "Albert Brooks", R.drawable.buscando_a_nemo),
                new Movie("John Wick", "Un mercenario retirado que vuelve a la acción"+lorem, "Chad Stahelski", "Keanu Reaves", R.drawable.john_wick)
            )
        );
        return movies;
    }
}
