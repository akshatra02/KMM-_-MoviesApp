package data.org.kmm.themoviesapp.network

import data.Movies
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class MoviesApi{
    val httpClient = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                ignoreUnknownKeys = true
                useAlternativeNames = false
            })
        }
    }
    suspend fun getMovieListApi(): Movies {
        return httpClient.get("https://api.themoviedb.org/3/movie/popular?page=1&api_key=5905390db2e077b3848f6f28672ae83a")
            .body()
    }
}