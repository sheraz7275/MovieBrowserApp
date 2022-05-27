package com.example.moviebrowser.ui.movieList

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import com.example.moviebrowser.R
import org.junit.Test
import org.junit.runner.RunWith


@MediumTest
@RunWith(AndroidJUnit4::class)
class MovieListFragmentTest{


    @Test
    fun activeTaskDetails_DisplayedInUi() {
        // GIVEN - Add active (incomplete) task to the DB

        // WHEN - Details fragment launched to display task



        launchFragmentInContainer<MovieListFragment>(null, R.style.Theme_MovieBrowser)

    }

    
}