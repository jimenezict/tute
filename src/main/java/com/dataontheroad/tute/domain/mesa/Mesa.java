package com.dataontheroad.tute.domain.mesa;

import com.dataontheroad.tute.domain.cartas.Baraja;
import com.dataontheroad.tute.domain.cartas.Carta;
import com.dataontheroad.tute.domain.jugador.Jugador;

import java.util.ArrayList;
import java.util.List;

public class Mesa {

    private List<Jugador> jugadorList;
    private Baraja baraja;
    private Carta cartaMuestra;

    public Mesa() {
        jugadorList = new ArrayList<>();
    }

    public List<Jugador> getJugadorList() {
        return jugadorList;
    }

    public void setJugadorList(List<Jugador> jugadorList) {
        this.jugadorList = jugadorList;
    }

    public Baraja getBaraja() {
        return baraja;
    }

    public void setBaraja(Baraja baraja) {
        this.baraja = baraja;
    }

    public Carta getCartaMuestra() {
        return cartaMuestra;
    }

    public void setCartaMuestra(Carta cartaMuestra) {
        this.cartaMuestra = cartaMuestra;
    }
}
