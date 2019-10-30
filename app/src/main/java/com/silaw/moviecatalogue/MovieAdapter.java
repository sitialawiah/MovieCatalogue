package com.silaw.moviecatalogue;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter {
    private final Context context;
    private ArrayList<Movie> movies;


    MovieAdapter(Context context) {
        this.context = context;
        movies = new ArrayList<>();
    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }


    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int i) {
        return movies.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.movie_list, viewGroup, false);
        }
        ViewHolder viewHolder = new ViewHolder(view);
        Movie movie = (Movie) getItem(i);
        viewHolder.bind(movie);
        return view;
    }

    private class ViewHolder {
        private TextView txtTitle;
        private TextView txtDescription;
        private TextView txtGenre;
        private ImageView imgPhoto;

        ViewHolder(View view) {
            txtTitle = view.findViewById(R.id.tvTitleMovie);
            txtDescription = view.findViewById(R.id.tvMovieDescription);
            txtGenre = view.findViewById(R.id.tvMovieGenres);
            imgPhoto = view.findViewById(R.id.img_photo);
        }
        void bind(Movie movie) {
            txtTitle.setText(movie.getTitle());
            txtDescription.setText(movie.getDescription());
            txtGenre.setText(movie.getGenre());
            imgPhoto.setImageResource(movie.getPhoto());
        }
    }
}
