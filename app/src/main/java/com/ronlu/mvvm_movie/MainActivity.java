package com.ronlu.mvvm_movie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import com.ronlu.mvvm_movie.models.Movie;
import com.ronlu.mvvm_movie.viewModels.MainActivityViewModel;
import com.ronlu.mvvm_movie.viewModels.adapters.RecyclerViewAdapter;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private MainActivityViewModel mViewModel;
    private RecyclerViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.mRecyclerView);
        //set ViewModelProvider, init and observe changes from mViewModel
        mViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        mViewModel.init();
        initRecyclerView();
        mViewModel.getMovies().observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(List<Movie> movies) {
                mAdapter.setMovies(movies);
            }
        });
        mAdapter.setOnItemClickListener(new RecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(String title, String description) {
                showMovieDescription(title, description);
            }
        });

    }

    public void initRecyclerView(){
        mAdapter = new RecyclerViewAdapter(mViewModel.getMovies().getValue(), this);
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void showMovieDescription(String title, String description){
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(description)
                .setCancelable(false)
                .setNeutralButton("Return", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}