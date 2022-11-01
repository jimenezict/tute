package com.dataontheroad.tute.juego.domain.partida;

import com.dataontheroad.tute.juego.domain.jugador.Jugador;
import com.dataontheroad.tute.juego.domain.mesa.Mesa;
import com.dataontheroad.tute.juego.service.mesa.MesaService;
import java.util.List;

import java.time.LocalDateTime;

public class Partida {

    private Mesa mesa;
    private Ronda ronda;
    private LocalDateTime inicioPartida;
    private int numRonda;
    private EstadoPartidaEnum estadoPartida;
    private Jugador jugadorGanador;
    private String resumenPartida;

    public Partida(List<Jugador> jugadorList) {
        mesa = (new MesaService()).crearMesa(jugadorList);
        inicioPartida = LocalDateTime.now();
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public Ronda getRonda() {
        return ronda;
    }

    public void setRonda(Ronda ronda) {
        this.ronda = ronda;
    }

    public LocalDateTime getInicioPartida() {
        return inicioPartida;
    }

    public void setInicioPartida(LocalDateTime inicioPartida) {
        this.inicioPartida = inicioPartida;
    }

    public int getNumRonda() {
        return numRonda;
    }

    public void setNumRonda(int numRonda) {
        this.numRonda = numRonda;
    }

    public EstadoPartidaEnum getEstadoPartida() {
        return estadoPartida;
    }

    public void setEstadoPartida(EstadoPartidaEnum estadoPartida) {
        this.estadoPartida = estadoPartida;
    }

    public Jugador getJugadorGanador() {
        return jugadorGanador;
    }

    public void setJugadorGanador(Jugador jugadorGanador) {
        this.jugadorGanador = jugadorGanador;
    }

    public String getResumenPartida() {
        return resumenPartida;
    }

    public void setResumenPartida(String resumenPartida) {
        this.resumenPartida = resumenPartida;
    }
}
