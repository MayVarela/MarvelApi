package com.MarvelPersonajes.Api.Model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public record ResultadoComics(
        @JsonAlias("items") List<DatosComics> itemComics,
        @JsonAlias("returned") Integer numero
) {
}
