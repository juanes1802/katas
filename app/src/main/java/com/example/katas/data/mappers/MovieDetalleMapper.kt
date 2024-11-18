package com.example.katas.data.mappers

import com.example.katas.domain.model.MovieDetalle as DomainMovieDetalle
import com.example.katas.data.model.entities.MovieDetalleDto as DataMovieDetalle
// Mapper para convertir DataMovieDetalle a DomainMovieDetalle
fun DataMovieDetalle.toDomainModel():DomainMovieDetalle{
    return  DomainMovieDetalle(
        id = this.id ?:0,
        rating = this.rating,
        posterPath = this.posterPath,
        backdropPath = this.backdropPath,
        originalTitle = this.originalTitle,
        title = this.title,
        overview = this.overview,
        genres = this.genres.map { it.toDomainModel()}
    )

}
// Mapper para convertir una lista de DataMovieDetalle a una lista de DomainMovieDetalle
fun List<DataMovieDetalle>.toDomainModelList(): List<DomainMovieDetalle>{
    return  this.map { it.toDomainModel() }
}