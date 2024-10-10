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
        binding.tvTitle.text = MoviesModel.id.toString()
        binding.tvYear.text = MoviesModel.original_title
        binding.tvActors.text = MoviesModel.overview
        val imageURL = IMAGE_URL+ "w500" + MoviesModel.poster_path

        Glide.with(binding.imageView.context)
            .load(imageURL)
            .into(binding.imageView)





    }
}