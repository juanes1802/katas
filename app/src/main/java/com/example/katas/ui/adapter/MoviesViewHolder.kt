package com.example.katas.adapter

import android.view.View
import android.view.View.OnClickListener
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

import com.example.katas.Movie
import com.example.katas.databinding.ViewMoviesBinding
import com.example.katas.service.ApiService.Companion.IMAGE_URL

class MoviesViewHolder(view: View):RecyclerView.ViewHolder(view){
    private val binding = ViewMoviesBinding.bind(view)

    fun render(MoviesModel: Movie) {
        binding.tvTitle.text = MoviesModel.title
        binding.tvYear.text = MoviesModel.releaseDate
        binding.tvOverview.text = MoviesModel.overview
        val imageURL = IMAGE_URL+ "w500" + MoviesModel.posterPath

        Glide.with(binding.imageView.context)
            .load(imageURL)
            .into(binding.imageView)





    }
}