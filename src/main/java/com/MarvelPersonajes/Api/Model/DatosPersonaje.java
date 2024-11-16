package com.MarvelPersonajes.Api.Model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosPersonaje(
        @JsonAlias("name") String nombre,
        @JsonAlias("description") String descripcion,
        @JsonAlias("comics") ResultadoComics Comics,
        @JsonAlias("series") ResultadoSeries Series
) {
}
