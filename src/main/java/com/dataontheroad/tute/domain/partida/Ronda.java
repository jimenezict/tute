package com.dataontheroad.tute.domain.partida;

import com.dataontheroad.tute.domain.cartas.Carta;
import com.dataontheroad.tute.domain.jugador.Jugador;

import java.util.ArrayList;
import java.util.List;

public class Ronda {

    private List<Carta> cartaMesaList;
    private Jugador jugadorInicial;
    private Carta cartaMasAlta;
    private Jugador jugadorGanador;

    public Ronda() {
        cartaMesaList = new ArrayList<>();
    }

    public List<Carta> getCartaMesaList() {
        return cartaMesaList;
    }

    public void setCartaMesaList(List<Carta> cartaMesaList) {
        this.cartaMesaList = cartaMesaList;
    }

    public Jugador getJugadorInicial() {
        return jugadorInicial;
    }

    public void setJugadorInicial(Jugador jugadorInicial) {
        this.jugadorInicial = jugadorInicial;
    }

    public Carta getCartaMasAlta() {
        return cartaMasAlta;
    }

    public void setCartaMasAlta(Carta cartaMasAlta) {
        this.cartaMasAlta = cartaMasAlta;
    }

    public Jugador getJugadorGanador() {
        return jugadorGanador;
    }

    public void setJugadorGanador(Jugador jugadorGanador) {
        this.jugadorGanador = jugadorGanador;
    }
}
