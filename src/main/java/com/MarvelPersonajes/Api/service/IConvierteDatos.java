package com.MarvelPersonajes.Api.service;

public interface IConvierteDatos {
    <T> T obtenerDatos (String json, Class<T> clase);
}
