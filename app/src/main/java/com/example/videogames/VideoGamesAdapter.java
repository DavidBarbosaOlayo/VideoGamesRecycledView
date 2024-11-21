package com.example.videogames;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class VideoGamesAdapter extends RecyclerView.Adapter<VideoGamesAdapter.VideoGameViewHolder> {

    private List<VideoGames> games;

    public VideoGamesAdapter(List<VideoGames> games) {
        this.games = games;
    }

    @NonNull
    @Override
    public VideoGameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_video_games, parent, false);
        return new VideoGameViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoGameViewHolder holder, int position) {
        VideoGames game = games.get(position);
        holder.txtNombre.setText(game.nombre);
        holder.txtGenero.setText(game.genero);
        holder.txtFecha.setText(game.anyo.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        holder.txtValoracion.setText(String.valueOf(game.valoracion));
    }

    @Override
    public int getItemCount() {
        return games != null ? games.size() : 0;
    }

    public void actualizarLista(List<VideoGames> games) {
        this.games = games;
        notifyDataSetChanged();
    }

    static class VideoGameViewHolder extends RecyclerView.ViewHolder {
        TextView txtNombre, txtGenero, txtFecha, txtValoracion;

        public VideoGameViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNombre = itemView.findViewById(R.id.txtNombre);
            txtGenero = itemView.findViewById(R.id.txtGenero);
            txtFecha = itemView.findViewById(R.id.txtFecha);
            txtValoracion = itemView.findViewById(R.id.txtValoracion);
        }
    }
}
