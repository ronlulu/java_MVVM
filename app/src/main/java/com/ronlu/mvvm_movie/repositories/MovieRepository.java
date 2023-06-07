package com.ronlu.mvvm_movie.repositories;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import com.ronlu.mvvm_movie.models.Movie;
import com.ronlu.mvvm_movie.requests.MovieService;
import com.ronlu.mvvm_movie.requests.RetrofitClient;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository {
    private static MovieRepository instance;
    private final MovieService movieService;
    private ArrayList<Movie> dataset = new ArrayList<>();

    public static MovieRepository getInstance(){
        if(instance == null)
            instance = new MovieRepository();
        return instance;
    }
    private MovieRepository(){
        movieService = RetrofitClient.getService();
    }

    public MutableLiveData<List<Movie>> getMovies(){
        MutableLiveData<List<Movie>> data = new MutableLiveData<>();
        movieService.getMovies().enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                if (response.isSuccessful()) {
                    data.setValue(response.body());
                    Log.d("pttt", "MovieRepository: " + data.getValue().toString());
                }
            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {
                Log.d("pttt", "failed");
            }
        });
        data.setValue(dataset);
        return data;
    }

}
