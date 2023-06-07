package com.ronlu.mvvm_movie.requests;

import com.ronlu.mvvm_movie.models.Movie;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface MovieService {

    @Headers({
            "X-RapidAPI-Key: b30c4ce83emsh97f224ff974aa50p1d499ejsn66e31aca884b",
            "X-RapidAPI-Host: imdb-top-100-movies1.p.rapidapi.com"
    })
    @GET(" ")
    Call<List<Movie>> getMovies();
}
