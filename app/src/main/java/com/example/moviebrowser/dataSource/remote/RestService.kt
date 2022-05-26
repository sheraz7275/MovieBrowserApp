package com.example.moviebrowser.dataSource.remote

import com.example.moviebrowser.dataModels.TopRatedMovies
import com.example.moviebrowser.dataModels.TopRatedMoviesList
import kotlinx.coroutines.Deferred
import retrofit2.http.*

interface RestApi {
    @GET("top_rated")
    fun getTopRatedMoviesListAsync(@Query("api_key") apiKey:String)
    :Deferred<TopRatedMoviesList>
}

