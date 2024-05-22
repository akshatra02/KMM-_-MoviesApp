package domain.org.kmm.themoviesapp.repository

import domain.org.kmm.themoviesapp.entites.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    suspend fun getMovies(forceReload: Boolean): Flow<Movie>
}