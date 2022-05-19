package com.arcode.eamovies.ui.top

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arcode.eamovies.domain.GetTopRatedMoviesUseCase
import com.arcode.eamovies.domain.models.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TopMovieViewModel @Inject constructor(
    private val getTopRatedMoviesUseCase: GetTopRatedMoviesUseCase,
) : ViewModel() {
    val topRatedMovies = MutableLiveData<List<Movie>>()
    private val error = MutableLiveData<String>()
    val isLoading = MutableLiveData<Boolean>()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getTopRatedMoviesUseCase()
            if (result.isNotEmpty()) {
                topRatedMovies.postValue(result)
                isLoading.postValue(false)
            } else {
                error.postValue("No movies found")
                isLoading.postValue(false)
            }
        }
    }
}