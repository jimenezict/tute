package com.dataontheroad.tute.domain.jugador;

import com.dataontheroad.tute.domain.cartas.Carta;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Jugador {

    private List<Carta> mano;
    private List<Carta> descartes;
    private int puntuacion;
    private int id;
    private StrategyAbstract strategy;

    public Jugador() {
        mano = new ArrayList<>();
        descartes = new ArrayList<>();
        puntuacion = 0;
        id = ThreadLocalRandom.current().nextInt(0, 10000);
    }

    public Jugador(StrategyAbstract strategy) {
        mano = new ArrayList<>();
        descartes = new ArrayList<>();
        puntuacion = 0;
        id = ThreadLocalRandom.current().nextInt(0, 10000);
        this.strategy = strategy;
    }

    public List<Carta> getMano() {
        return mano;
    }

    public void setMano(List<Carta> mano) {
        this.mano = mano;
    }

    public List<Carta> getDescartes() {
        return descartes;
    }

    public void setDescartes(List<Carta> descartes) {
        this.descartes = descartes;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public StrategyAbstract getStrategy() {
        return strategy;
    }
}
