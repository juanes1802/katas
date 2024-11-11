package com.example.katas.presentation.home

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.katas.data.model.MovieTopRatedAndPopular
import com.example.katas.databinding.ItemsMoviesInicioBinding
import com.example.katas.service.ApiService.Companion.IMAGE_URL

class MoviesViewHolderTopRatedAndPopular(view: View): RecyclerView.ViewHolder(view){
    private val binding = ItemsMoviesInicioBinding.bind(view)

    fun render(MoviesModel2: MovieTopRatedAndPopular) {
        binding.textTitleRating.text = MoviesModel2.title
        binding.textRating.text = MoviesModel2.rating

        val imageURL = IMAGE_URL + "w500" + MoviesModel2.posterPath

        Glide.with(binding.moviePoster.context)
            .load(imageURL)
            .into(binding.moviePoster)





    }
}