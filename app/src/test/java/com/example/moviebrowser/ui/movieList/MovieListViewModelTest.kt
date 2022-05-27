package com.example.moviebrowser.ui.movieList

import android.util.Log
import com.example.moviebrowser.dataModels.TopRatedMovies
import com.example.moviebrowser.dataSource.FakeDataSource
import com.example.moviebrowser.dataSource.MoviesDataSource
import com.example.moviebrowser.dataSource.repository.FakeRepository
import com.example.moviebrowser.repository.MovieRepository
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class MovieListViewModelTest{
    private val fakeMovieList:MutableList<TopRatedMovies> = mutableListOf()
    private lateinit var movieRepository: MovieRepository
    private lateinit var movieListViewModel:MovieListViewModel

    private val dispatcher = TestCoroutineDispatcher()


    @Before
    fun setUpViewModel(){
        Dispatchers.setMain(dispatcher)

        val movie1= TopRatedMovies(
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

        val dataSource:MoviesDataSource=FakeDataSource()
        movieRepository= FakeRepository(dataSource)
        movieListViewModel=MovieListViewModel(movieRepository)

    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }



    @Test

    fun testViewModel()= runBlockingTest{
        val list= movieListViewModel.topRatedMoviesList.first()
        assertThat(list?.size).isEqualTo(10)
        assertThat(list).isEqualTo(fakeMovieList)
    }




}