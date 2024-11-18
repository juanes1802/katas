package com.example.katas.presentation.search.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.katas.R
import com.example.katas.data.model.entities.MovieDetalleDto

class MoviesAdapterDetail(
    private var recommendations: List<MovieDetalleDto>
) : RecyclerView.Adapter<MoviesViewHolderDetail>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolderDetail {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MoviesViewHolderDetail(layoutInflater.inflate(R.layout.items_movies_inicio, parent, false))
    }

    override fun onBindViewHolder(holder: MoviesViewHolderDetail, position: Int) {
        val movie = recommendations[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = recommendations.size

    fun updateList(newRecommendation: List<MovieDetalleDto>) {
        recommendations = newRecommendation
        notifyDataSetChanged()
    }
}