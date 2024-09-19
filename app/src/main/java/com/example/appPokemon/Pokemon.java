package com.example.appPokemon;

import java.io.Serializable;

public class Pokemon implements Serializable {
    private String nome;
    private String imageUrl;
    private int level;
    private String tipo1;
    private String tipo2;

    public Pokemon(String nome, String imageUrl, int level, String tipo1, String tipo2) {
        this.nome = nome;
        this.imageUrl = imageUrl;
        this.level = level;
        this.tipo1 = tipo1;
        this.tipo2 = tipo2;
    }

    public String getName() {
        return nome;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public int getLevel() {
        return level;
    }

    public String getType1() {
        return tipo1;
    }

    public String getType2() {
        return tipo2;
    }
}
