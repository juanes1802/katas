package com.example.katas.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.katas.Movie

import com.example.katas.R

class MoviesAdapter(private val MoviesList: List<Movie>) :
    RecyclerView.Adapter<MoviesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MoviesViewHolder(layoutInflater.inflate(R.layout.view_movies, parent, false))
    }

    override fun getItemCount(): Int = MoviesList.size


    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.render(MoviesList[position])

    }

}
