package domain.org.kmm.themoviesapp.usecase

import MovieApp
import domain.org.kmm.themoviesapp.entites.Movie
import kotlinx.coroutines.flow.Flow

class GetMovieUseCase {
    private val movieRepository = MovieApp().movieRepository
    suspend operator fun invoke(forceReload: Boolean): Flow<Movie> {
        return movieRepository.getMovies(forceReload)
    }
}