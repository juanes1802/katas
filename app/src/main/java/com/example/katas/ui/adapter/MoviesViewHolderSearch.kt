package com.example.katas.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


import com.example.katas.data.model.MovieSearch
import com.example.katas.databinding.ViewMoviesBinding
import com.example.katas.service.ApiService.Companion.IMAGE_URL

class MoviesViewHolderSearch(view: View):RecyclerView.ViewHolder(view){
    private val binding = ViewMoviesBinding.bind(view)

    fun render(moviesModel: MovieSearch) {
        binding.tvTitle.text = moviesModel.title
        binding.tvYear.text = moviesModel.releaseDate
        binding.tvOverview.text = moviesModel.overview
        val imageURL = IMAGE_URL+ "w500" + moviesModel.posterPath

        Glide.with(binding.imageView.context)
            .load(imageURL)
            .into(binding.imageView)





    }
}

