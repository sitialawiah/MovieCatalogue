package com.silaw.moviecatalogue;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailMovie extends AppCompatActivity {

    public static final String EXTRA = "extra";

    TextView judul;
    TextView deskripsi;
    TextView genre;
    ImageView poster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_detail);

        judul = findViewById(R.id.txt_detail_title);
        deskripsi = findViewById(R.id.txt_desc);
        genre = findViewById(R.id.txt_genre);
        poster = findViewById(R.id.image_poster);

        Movie movie = getIntent().getParcelableExtra(EXTRA);

        judul.setText(movie.getTitle());
        deskripsi.setText(movie.getDescription());
        genre.setText(movie.getGenre());
        poster.setImageResource(movie.getPhoto());

        //back
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
