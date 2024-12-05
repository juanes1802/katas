package com.example.katas.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.katas.R

import com.example.katas.domain.model.MovieHome

class MoviesAdapterTopRatedAndPopular(private val clickListener: (MovieHome) -> Unit) :
    RecyclerView.Adapter<MoviesViewHolderTopRatedAndPopular>() {
    private var moviesListRatedAndPopular: List<MovieHome> = emptyList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolderTopRatedAndPopular {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MoviesViewHolderTopRatedAndPopular(
            layoutInflater.inflate(
                R.layout.items_movies_inicio,
                parent,
                false
            ),clickListener
        )
    }

    override fun getItemCount(): Int = moviesListRatedAndPopular.size


    override fun onBindViewHolder(holder: MoviesViewHolderTopRatedAndPopular, position: Int) {
        holder.render(moviesListRatedAndPopular[position])

    }
    fun updateMovies(newMovies: List<MovieHome>) {
      moviesListRatedAndPopular = newMovies
        notifyDataSetChanged()

    }

}