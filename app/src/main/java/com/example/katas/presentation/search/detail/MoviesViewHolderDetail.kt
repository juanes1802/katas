package com.example.katas.presentation.search.detail

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.katas.ApplicationMain.Companion.prefs
import com.example.data.model.entities.MovieDetalleDto
import com.example.data.network.ApiConstants
import com.example.katas.databinding.ItemsMoviesInicioBinding
import com.example.katas.domain.model.MovieDetalle


class MoviesViewHolderDetail(view: View,private val clickListener: (MovieDetalle) -> Unit) : RecyclerView.ViewHolder(view) {
    val binding = ItemsMoviesInicioBinding.bind(view)


    fun bind(movie: MovieDetalle) {
        binding.textTitleRating.text = movie.title
        binding.textRating.text = movie.rating

        val imageURL = ApiConstants.IMAGE_URL + "w500" + movie.posterPath

        Glide.with(binding.moviePoster.context)
            .load(imageURL)
            .into(binding.moviePoster)

        itemView.setOnClickListener {
            clickListener(movie)
        }



    }
}