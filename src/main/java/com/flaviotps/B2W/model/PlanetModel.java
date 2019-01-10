package com.flaviotps.B2W.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;


@Document
public class PlanetModel implements Serializable {


    @Id
    private String id;
    private String nome;
    private String clima;
    private String terreno;
    private String aparicoes;

    public String getAparicoes() {
        return aparicoes;
    }

    public void setAparicoes(String aparicoes) {
        this.aparicoes = aparicoes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }

    public String getTerreno() {
        return terreno;
    }

    public void setTerreno(String terreno) {
        this.terreno = terreno;
    }

    ;


}
