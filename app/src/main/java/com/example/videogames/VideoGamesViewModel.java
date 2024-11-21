package com.example.videogames;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class VideoGamesViewModel extends ViewModel {
    RepoVideoGames repositorio;
    MutableLiveData<List<VideoGames>> videoGamesList = new MutableLiveData<>();

    public VideoGamesViewModel() {
        repositorio = new RepoVideoGames();
        videoGamesList.setValue(repositorio.obtener());

    }

    void insertar(VideoGames elemento){
        repositorio.insertar(elemento, new RepoVideoGames.Callback() {
            @Override
            public void cuandoFinalice(List<VideoGames> elementos) {
                videoGamesList.setValue(elementos);
            }
        });
    }

    public MutableLiveData<List<VideoGames>> obtenerJuegos() {
        return videoGamesList;
    }
}

