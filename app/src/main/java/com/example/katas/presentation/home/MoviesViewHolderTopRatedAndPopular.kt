package com.example.katas.presentation.home

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.data.network.ApiConstants
import com.example.katas.databinding.ItemsMoviesInicioBinding
import com.example.katas.domain.model.MovieHome

class MoviesViewHolderTopRatedAndPopular(view: View,private  val clickListener: (MovieHome) -> Unit): RecyclerView.ViewHolder(view){
    private val binding = ItemsMoviesInicioBinding.bind(view)

    fun render(moviesModelRatedAndPopular: MovieHome) {
        binding.textTitleRating.text = moviesModelRatedAndPopular.title
        binding.textRating.text = moviesModelRatedAndPopular.rating

        val imageURL =   ApiConstants.IMAGE_URL   + "w500" +  moviesModelRatedAndPopular.posterPath

        Glide.with(binding.moviePoster.context)
            .load(imageURL)
            .into(binding.moviePoster)


        itemView.setOnClickListener {
            clickListener.invoke(moviesModelRatedAndPopular)
        }






    }
}