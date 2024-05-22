package data.org.kmm.themoviesapp.mapper

import domain.org.kmm.themoviesapp.entites.MovieDetails

fun toMovieDetails(
    id: Long,
    title: String,
    backdropPath : String,
    releaseDate: String,
    adult:Boolean?
): MovieDetails{
    return MovieDetails(
        id = id.toInt(),
        title = title,
        backdropPath = backdropPath,
        adult = adult ?: false,
        releaseDate = releaseDate

    )

}