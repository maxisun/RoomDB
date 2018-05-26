package com.example.max00.roomdb;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.example.max00.roomdb.MoviesAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;
    private MoviesAdapter adapter;
    private List<Movie> movies;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv =findViewById(R.id.recicladorpene);
        adapter = new MoviesAdapter(movies);
        rv.setLayoutManager(new LinearLayoutManager(this));
        AppDatabase db = AppDatabase.getAppDatabase(getApplicationContext());
        movies = db.moviesDAO().getAll();

        new Thread(movies,rv,adapter,db).execute();
        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),CreateMovie.class));
            }
        });
    }
}
