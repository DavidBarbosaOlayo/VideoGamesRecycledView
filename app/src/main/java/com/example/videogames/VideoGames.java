package com.example.videogames;

import java.time.LocalDate;

public class VideoGames {
    String nombre;
    String genero;
    LocalDate anyo;
    float valoracion;

    public VideoGames(String nombre, String genero, LocalDate anyo, float valoracion) {
        this.nombre = nombre;
        this.genero = genero;
        this.anyo = anyo;
        this.valoracion = valoracion;

    }


}
