package com.ronlu.mvvm_movie.viewModels;

import android.util.Log;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.MutableLiveData;
import com.ronlu.mvvm_movie.models.Movie;
import com.ronlu.mvvm_movie.repositories.MovieRepository;

import java.util.List;

public class MainActivityViewModel extends ViewModel {
    private MovieRepository moviesRepository;
    private MutableLiveData<List<Movie>> mMovies;

    public void init(){
        if(mMovies != null)
            return;
        moviesRepository = MovieRepository.getInstance();
        mMovies = moviesRepository.getMovies();
    }
    public MutableLiveData<List<Movie>> getMovies() {
        return mMovies;
    }
}
