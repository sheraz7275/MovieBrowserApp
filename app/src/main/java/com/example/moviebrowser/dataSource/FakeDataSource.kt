package com.example.moviebrowser.dataSource

import com.example.moviebrowser.dataModels.TopRatedMovies
import com.example.moviebrowser.dataModels.TopRatedMoviesList
import com.example.moviebrowser.dataSource.MoviesDataSource

 class FakeDataSource:MoviesDataSource {

    override suspend fun getMoviesData(): List<TopRatedMovies>? {
        val fakeMovieList:MutableList<TopRatedMovies> = mutableListOf()

        val movie1=TopRatedMovies(
            adult = false,
            backdrop_path = null,
            genre_ids = null,
            id = 1234,
            original_language = "English",
            overview = "Hello",
            original_title = "300",
            popularity = 10.0,
            poster_path = null,
            release_date ="01.01.2022",
            title = "300",
            video = null,
            vote_average = null,
            vote_count = 10
        )

        for (x in 1..10){
            fakeMovieList.add(movie1)
        }

        return fakeMovieList
    }


}