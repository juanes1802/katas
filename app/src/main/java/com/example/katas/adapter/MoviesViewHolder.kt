package com.example.katas.adapter

import android.view.View
import android.view.View.OnClickListener
import androidx.recyclerview.widget.RecyclerView
import com.example.katas.DataMovies
import com.example.katas.databinding.ViewMoviesBinding

class MoviesViewHolder(view: View):RecyclerView.ViewHolder(view){
    val binding = ViewMoviesBinding.bind(view)

    fun render(MoviesModel: DataMovies,onClickListener: (DataMovies)-> Unit) {
        binding.tvTitle.text = MoviesModel.titulo
        binding.tvYear.text = MoviesModel.ano.toString()
        binding.tvActors.text = MoviesModel.actors

    binding.imageView.setImageResource(MoviesModel.image)

    itemView.setOnClickListener { onClickListener(MoviesModel) }



    }
}