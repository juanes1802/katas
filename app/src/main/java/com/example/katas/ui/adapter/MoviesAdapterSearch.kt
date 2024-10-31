package com.example.katas.adapter

import android.view.LayoutInflater
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


import com.example.katas.R
import com.example.katas.data.model.MovieSearch

class MoviesAdapterSearch(private var moviesList: List<MovieSearch>,private val clickListener: (MovieSearch)->Unit) :
    RecyclerView.Adapter<MoviesViewHolderSearch>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolderSearch {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MoviesViewHolderSearch(layoutInflater.inflate(R.layout.view_movies, parent, false),clickListener)
    }

    override fun getItemCount(): Int = moviesList.size


    override fun onBindViewHolder(holder: MoviesViewHolderSearch, position: Int) {
        holder.render(moviesList[position])

    }

    fun updateList(newMovieLList: List<MovieSearch>){
        moviesList = newMovieLList
        notifyDataSetChanged()
    }

}






