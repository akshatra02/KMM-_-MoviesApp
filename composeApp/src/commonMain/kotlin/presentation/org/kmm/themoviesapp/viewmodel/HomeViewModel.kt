package presentation.org.kmm.themoviesapp.viewmodel

import androidx.compose.runtime.mutableStateOf
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import domain.org.kmm.themoviesapp.entites.Movie
import domain.org.kmm.themoviesapp.usecase.GetMovieUseCase
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val getMovieUseCase = GetMovieUseCase()
    var movieState = mutableStateOf(Movie())
        private set

    init {
        getMovies()
    }

    private fun getMovies() {
        viewModelScope.launch {
            getMovieUseCase(forceReload = false).collect { movie ->
                movieState.value = movie
            }

        }
    }
}
