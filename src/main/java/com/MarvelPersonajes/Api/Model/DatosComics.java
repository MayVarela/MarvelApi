package com.MarvelPersonajes.Api.Model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosComics(
        @JsonAlias("name") String nombreComic
) {
}