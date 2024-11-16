package com.MarvelPersonajes.Api.service;

public class KeyHash{
    public String CalculoHash(String busqueda){
        final String privateKey = "118e87140c8382ffbd7d11e553e7dc3bf9d8a950";
        final String publicKey = "9a8e6f7ebecf70c43114c1e1568018eb";
        String hash = CalculoMD5.generateMD5Hash(busqueda.replace(" ","") + privateKey + publicKey);
        String URLhash = "&hash=" + hash;
        return URLhash;
    }
}
