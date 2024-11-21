package com.example.videogames;

import android.os.Build;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.callback.Callback;

public class RepoVideoGames {
    List<VideoGames> games;

    public RepoVideoGames() {
        games = new ArrayList<>();

        games.add(new VideoGames("Dead Space", "Horror", LocalDate.of(2016, 10, 10), 7.5f));
        games.add(new VideoGames("Uncharted", "Adventure", LocalDate.of(2014, 11, 14), 8.5f));
        games.add(new VideoGames("The Last of Us", "Action-Adventure", LocalDate.of(2013, 6, 14), 9.7f));
        games.add(new VideoGames("God of War", "Action", LocalDate.of(2018, 4, 20), 9.8f));
        games.add(new VideoGames("Minecraft", "Sandbox", LocalDate.of(2011, 11, 18), 9.0f));
        games.add(new VideoGames("Celeste", "Platformer", LocalDate.of(2018, 1, 25), 8.5f));
        games.add(new VideoGames("Stardew Valley", "Simulation", LocalDate.of(2016, 2, 26), 8.9f));
        games.add(new VideoGames("Cyberpunk 2077", "RPG", LocalDate.of(2020, 12, 10), 7.8f));
        games.add(new VideoGames("Hades", "Rogue-like", LocalDate.of(2020, 9, 17), 9.2f));
        games.add(new VideoGames("Overwatch", "Shooter", LocalDate.of(2016, 5, 24), 8.4f));

    }
    interface Callback {
        void cuandoFinalice(List<VideoGames> elementos);
    }

    public List<VideoGames> obtener() {
        return games;
    }

    void insertar(VideoGames elemento, Callback callback){
        games.add(elemento);
        callback.cuandoFinalice(games);
    }

    void eliminar(VideoGames elemento, Callback callback) {
        games.remove(elemento);
        callback.cuandoFinalice(games);
    }

    void actualizar(VideoGames elemento, float valoracion, Callback callback) {
        elemento.valoracion = valoracion;
        callback.cuandoFinalice(games);
    }
}

