package com.dataontheroad.tute.juego.service.jugador;

import com.dataontheroad.tute.juego.domain.cartas.Carta;
import com.dataontheroad.tute.juego.domain.jugador.Jugador;

import java.util.List;

public interface JugadorService {

    public void ganarMano(Jugador jugador, List<Carta> cartaList);

    public boolean robarCarta(Jugador jugador, Carta carta);

    public boolean tirarCarta(Jugador jugador, Carta carta);

    public void inicializarJugadorPartida(Jugador jugador);
}
