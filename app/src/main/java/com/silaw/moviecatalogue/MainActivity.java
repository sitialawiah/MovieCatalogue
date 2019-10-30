package com.silaw.moviecatalogue;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private String[] dataTitle;
    private String[] dataDescription;
    private String[] dataGenre;
    private TypedArray dataPhoto;
    private MovieAdapter adapter;
    private ArrayList<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = new MovieAdapter(this);

        ListView listView = findViewById(R.id.lv_list);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent moveIntent = new Intent(MainActivity.this, DetailMovie.class);
                    moveIntent.putExtra(DetailMovie.EXTRA, movies.get(i));
                    startActivity(moveIntent);
                }
        });
    }

        private void addItem() {
        movies = new ArrayList<>();

        for (int i = 0; i < dataTitle.length; i++) {
            Movie movie = new Movie();
            movie.setPhoto(dataPhoto.getResourceId(i, -1));
            movie.setTitle(dataTitle[i]);
            movie.setDescription(dataDescription[i]);
            movie.setGenre(dataGenre[i]);
            movies.add(movie);
        }
        adapter.setMovies(movies);
    }

    private void prepare() {
        dataTitle = getResources().getStringArray(R.array.data_title);
        dataDescription = getResources().getStringArray(R.array.data_description);
        dataGenre = getResources().getStringArray(R.array.data_genre);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_photo:
                Intent moveIntent = new Intent(MainActivity.this, DetailMovie.class);
                startActivity(moveIntent);
                break;
        }
    }
}
