package com.dataontheroad.tute.experimento.domain;

import com.dataontheroad.tute.juego.domain.jugador.Jugador;



public class ExperimentoIndividual {

    private int numeroJugador;
    private int ordenJugadorGanador;
    private int[] resultados;
    private Jugador jugadorGanador;

    public int getNumeroJugador() {
        return numeroJugador;
    }

    public void setNumeroJugador(int numeroJugador) {
        this.numeroJugador = numeroJugador;
    }

    public int[] getResultados() {
        return resultados;
    }

    public void setResultados(int[] resultados) {
        this.resultados = resultados;
    }

    public Jugador getJugadorGanador() {
        return jugadorGanador;
    }

    public void setJugadorGanador(Jugador jugadorGanador) {
        this.jugadorGanador = jugadorGanador;
    }

    public void setOrdenJugadorGanador(int ordenJugadorGanador) {
        this.ordenJugadorGanador = ordenJugadorGanador;
    }
}
