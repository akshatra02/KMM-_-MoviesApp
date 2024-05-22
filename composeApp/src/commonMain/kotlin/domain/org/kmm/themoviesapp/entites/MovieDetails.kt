package domain.org.kmm.themoviesapp.entites

data class MovieDetails(
    val adult: Boolean,
    val id: Int,
    val title: String,
    val backdropPath: String,
    val releaseDate: String,
)