package com.example.katas.data.mappers


import com.example.domain.model.MovieEntityDomain
import com.example.katas.data.model.entities.MovieTopRatedAndPopularDto
import com.example.katas.data.model.local.entity.MovieEntity
import com.example.katas.data.model.remote.responses.MoviesResponseTopRatedAndPopular
import com.example.katas.domain.model.MovieHome

// Mapper para convertir MovieTopRatedAndPopularDto a el dominio MovieHome
fun MovieTopRatedAndPopularDto.toDomainModel(): MovieHome {
    return MovieHome(
        id = this.id,
        title = this.title,
        rating = this.rating,
        posterPath = this.posterPath
    )

}

// Mapper para convertir una lista de MovieTopRatedAndPopularDto a una lista de MovieHome
fun List<MovieTopRatedAndPopularDto>.toDomainModelList(): List<MovieHome> {
    return this.map { it.toDomainModel() }
}

fun MoviesResponseTopRatedAndPopular.toDomainModelList(): List<MovieHome> {
    return results.toDomainModelList()
}

// Mapper para convertir MovieEntity a MovieHome
fun MovieEntity.toDomainModel(): MovieHome {
    return MovieHome(
        id = this.id,
        title = this.title,
        rating = this.rating,
        posterPath = this.posterPath ?: "uknown"
    )
}


fun MovieHome.toMovieEntityDomain(): MovieEntityDomain {
    return MovieEntityDomain(
        id = this.id,
        title = this.title,
        rating = this.rating,
        posterPath = this.posterPath )
}




fun MovieEntityDomain.toDataBaseEntity() : MovieEntity {
    return MovieEntity(
        id = this.id,
        title = this.title,
        rating = this.rating,
        posterPath = this.posterPath )
}











