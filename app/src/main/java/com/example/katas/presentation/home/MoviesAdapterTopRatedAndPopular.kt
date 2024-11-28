package com.example.katas.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.katas.R

import com.example.katas.domain.model.MovieHome

class MoviesAdapterTopRatedAndPopular(private val moviesListRatedAndPopular: List<MovieHome>) :
    RecyclerView.Adapter<MoviesViewHolderTopRatedAndPopular>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolderTopRatedAndPopular {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MoviesViewHolderTopRatedAndPopular(
            layoutInflater.inflate(
                R.layout.items_movies_inicio,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = moviesListRatedAndPopular.size


    override fun onBindViewHolder(holder: MoviesViewHolderTopRatedAndPopular, position: Int) {
        holder.render(moviesListRatedAndPopular[position])

    }

}