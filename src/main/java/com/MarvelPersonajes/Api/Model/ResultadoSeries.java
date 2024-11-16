package com.MarvelPersonajes.Api.Model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public record ResultadoSeries(
        @JsonAlias("items") List<DatosSeries> itemSeries
) {
}
