package com.ronlu.mvvm_movie.viewModels.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.ronlu.mvvm_movie.R;
import com.ronlu.mvvm_movie.models.Movie;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<ViewHolder> {
    private List<Movie> movies;
    private Context context;
    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public RecyclerViewAdapter(List<Movie> movies, Context context) {
        this.movies = movies;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.recyclerview_movies, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int pos) {
        // set Title, Rating and Year
        holder.recyclerview_LBL_title.setText(movies.get(pos).getTitle());
        holder.recyclerview_LBL_rate.setText(movies.get(pos).getRating());
        holder.recyclerview_LBL_year.setText(String.valueOf(movies.get(pos).getYear()));
        // set Poster
        Glide.with(context)
                .setDefaultRequestOptions(new RequestOptions().error(R.drawable.ic_launcher_background))
                .load(movies.get(pos).getImagePath())
                .fitCenter()
                .into(holder.recyclerview_IMG_poster);
        // set genre
        StringBuilder genreStr = new StringBuilder();
        for (int i = 0; i < movies.get(pos).getGenre().size(); i++) {
            genreStr.append(movies.get(pos).getGenre().get(i)).append(", ");
        }
        genreStr.delete(genreStr.length()-2, genreStr.length());
        holder.recyclerview_LBL_genre.setText(genreStr);
        // open description fragment
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(movies.get(holder.getAdapterPosition()).getTitle(), movies.get(holder.getAdapterPosition()).getDescription());
            }
        });
    }

    @Override
    public int getItemCount() {
        return movies != null? movies.size() : 0;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
        notifyDataSetChanged();
    }

    public interface OnItemClickListener {
        void onItemClick(String title, String description);
    }
}
