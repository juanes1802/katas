package com.example.katas

import android.provider.ContactsContract.Data

class MoviesProvider {
    val MoviesList = listOf<DataMovies>(
        DataMovies(
            "Dark Waters", 2023, "Jacqueline Babbin, Audrey Maas", R.drawable.dark_waters
        ),
        DataMovies(
            "Inception", 2010, "Leonardo DiCaprio, Joseph Gordon-Levitt", R.drawable.inception
        ),
        DataMovies(
            "The Matrix", 1999, "Keanu Reeves, Carrie-Anne Moss", R.drawable.the_matrix
        ),
        DataMovies(
            "Interstellar", 2014, "Matthew McConaughey, Anne Hathaway", R.drawable.interstellar
        ),
        DataMovies(
            "The Shawshank Redemption", 1994, "Tim Robbins, Morgan Freeman", R.drawable.the_shawshank_redemption
        )
    )
}