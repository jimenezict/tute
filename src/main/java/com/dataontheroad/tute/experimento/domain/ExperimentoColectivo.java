package com.dataontheroad.tute.experimento.domain;

import java.util.ArrayList;
import java.util.List;

public class ExperimentoColectivo {

    private List<List<Integer>> listaDeResultados;
    private List<Integer> listaGanadores;
    private int numeroDeJugadores;
    private int numeroDeExperimentos;

    public ExperimentoColectivo(int numeroDeJugadores, int numeroDeExperimentos) {
        this.numeroDeJugadores = numeroDeJugadores;
        this.numeroDeExperimentos = numeroDeExperimentos;
        listaDeResultados = new ArrayList<>();
        listaGanadores = new ArrayList<>();

        for(int i =0; i< numeroDeJugadores; i++) {
            listaGanadores.add(0);
            listaDeResultados.add(new ArrayList<>());
        }
    }

    public int getNumeroDeJugadores() {
        return numeroDeJugadores;
    }

    public int getNumeroDeExperimentos() {
        return numeroDeExperimentos;
    }

    public void setNumeroDeExperimentos(int numeroDeExperimentos) {
        this.numeroDeExperimentos = numeroDeExperimentos;
    }

    public List<List<Integer>> getListaDeResultados() {
        return listaDeResultados;
    }

    public List<Integer> getListaGanadores() {
        return listaGanadores;
    }
}
