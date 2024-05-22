package domain.org.kmm.themoviesapp.entites

data class Movie(
    val isLoading: Boolean = false,
    var moviesList: List<MovieDetails> = emptyList()
)