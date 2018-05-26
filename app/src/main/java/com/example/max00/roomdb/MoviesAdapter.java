package com.example.max00.roomdb;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.PeliculasViewHolder> {
    private List<Movie> movies;

    public static class PeliculasViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        TextView name,category,studio;

        public PeliculasViewHolder(View view){
            super(view);
            cardView = view.findViewById(R.id.card_view);
            name = view.findViewById(R.id.nombre_pelicula_cardview);
            category = view.findViewById(R.id.categoria_pelicula_cardview);
            studio = view.findViewById(R.id.estudio_pelicula_cardview);
        }
    }

    public MoviesAdapter(List<Movie> movies){
        this.movies = movies;
    }

    @NonNull
    @Override
    public PeliculasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_cardview,parent,false);
        return (new PeliculasViewHolder(v));
    }

    @Override
    public void onBindViewHolder(@NonNull PeliculasViewHolder holder, int position) {
        final Movie movie = movies.get(position);

        holder.name.setText(movie.getNomMovie());
        holder.category.setText(movie.getNomCategory());
        holder.studio.setText(movie.getNomEstudio());
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
}
