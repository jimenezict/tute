package com.dataontheroad.tute.domain.partida;

import com.dataontheroad.tute.domain.jugador.Jugador;
import com.dataontheroad.tute.domain.mesa.Mesa;
import com.dataontheroad.tute.service.mesa.MesaServiceImpl;
import java.util.List;

import java.time.LocalDateTime;

public class Partida {

    private Mesa mesa;
    private Ronda ronda;
    private LocalDateTime inicioPartida;

    public Partida(List<Jugador> jugadorList) {
        mesa = (new MesaServiceImpl()).crearMesa(jugadorList);
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
}
