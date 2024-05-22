package data


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieDto(
    @SerialName("adult")
    val adult: Boolean,
    @SerialName("id")
    val id: Int,
    @SerialName("title")
    val title: String,
    @SerialName("backdrop_path")
    val backdropPath: String,
    @SerialName("release_date")
    val releaseDate: String,
//    @SerialName("original_language")
//    val originalLanguage: String,
//    @SerialName("overview")
//    val overview: String,
//    @SerialName("vote_average")
//    val voteAverage: Double,
//    @SerialName("vote_count")
//    val voteCount: Int
)