package data.org.kmm.themoviesapp.repository

import data.org.kmm.themoviesapp.database.Database
import data.org.kmm.themoviesapp.network.MoviesApi
import domain.org.kmm.themoviesapp.entites.Movie
import domain.org.kmm.themoviesapp.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

class DefaultMovieRepository : MovieRepository {
    private val remoteData = MoviesApi()
    private val localData = Database()

    override suspend fun getMovies(forceReload: Boolean): Flow<Movie> {
        val localMovies = localData.getMovies().first()
        return if (localMovies.isEmpty()) {
            try {
                localData.insertMovies(remoteData.getMovieListApi().results)
                localData.getMovies().map { Movie(isLoading = false, moviesList = it) }
            } catch (e: Exception) {
                localData.getMovies().map { Movie(isLoading = true) }
            }
        } else {
            localData.getMovies().map { Movie(isLoading = false, moviesList = it) }

        }

    }
}
