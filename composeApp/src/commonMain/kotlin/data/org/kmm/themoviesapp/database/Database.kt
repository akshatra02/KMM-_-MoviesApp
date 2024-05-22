package data.org.kmm.themoviesapp.database

import data.MovieDto
import data.org.kmm.themoviesapp.mapper.toMovieDetails
import databaseDriver
import domain.org.kmm.themoviesapp.entites.MovieDetails
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.kmm.themoviesapp.AppDatabase


class Database {
    private val databaseDriver = databaseDriver().driver
    private val appDatabase = AppDatabase(databaseDriver)

    private val dbQuery = appDatabase.movieEntityQueries

    fun getMovies(): Flow<List<MovieDetails>> = flow {
        emit(dbQuery.getAllMovies(::toMovieDetails).executeAsList())
    }

    fun insertMovies(movies: List<MovieDto>) {
        movies.forEach { movie ->
            dbQuery.insertMovie(
                id = movie.id.toLong(),
                title = movie.title,
                adult = movie.adult,
                backdropPath = movie.backdropPath,
                releaseDate = movie.releaseDate  ,

            )

        }
    }

}