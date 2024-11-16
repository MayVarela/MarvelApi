package com.MarvelPersonajes.Api.Principal;

import com.MarvelPersonajes.Api.Model.DatosComics;
import com.MarvelPersonajes.Api.Model.DatosPersonaje;
import com.MarvelPersonajes.Api.Model.ResultadoComics;
import com.MarvelPersonajes.Api.Model.ObjetoData;
import com.MarvelPersonajes.Api.service.ConsumoApi;
import com.MarvelPersonajes.Api.service.ConvierteDatos;
import com.MarvelPersonajes.Api.service.KeyHash;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {
    private ConsumoApi consumoApi = new ConsumoApi();
    private KeyHash keyHash = new KeyHash();
    private ConvierteDatos conversor = new ConvierteDatos();

    private final String URLbase = "https://gateway.marvel.com/v1/public/characters?name=";
    private final String URLpublickey = "&apikey=9a8e6f7ebecf70c43114c1e1568018eb";

    public void muestraElMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Cual es tu personaje de Marvel");
        String busqueda = scanner.nextLine();

        String ts = "&ts=" + busqueda.replace(" ", "");
        String URLhash = keyHash.CalculoHash(busqueda);
        String URLCompleta = URLbase + busqueda.replace(" ", "%20") + ts +
                URLpublickey + URLhash;
        var json = consumoApi.obtenerDatos(URLCompleta);
        System.out.println(URLCompleta);
        var datos = conversor.obtenerDatos(json, ObjetoData.class);
        var datosPersonaje = conversor.obtenerDatos(json, DatosPersonaje.class);
        System.out.println(datos);

        System.out.println("********************************************");
        System.out.println("Estos son 20 de los commics en los que aparece " + busqueda);
        datos.resultadoGeneral().resultados().stream()
                        .flatMap(c->c.Comics().itemComics().stream()
                                .map(n->n.nombreComic().toUpperCase()))
                .forEach(System.out::println);
        System.out.println("********************************************");
        System.out.println("Estas son 20 de las series en las que aparece " + busqueda);
        datos.resultadoGeneral().resultados().stream()
                .flatMap(s->s.Series().itemSeries().stream()
                        .map(n->n.nombreSerie().toUpperCase()))
                .forEach(System.out::println);

    }
}