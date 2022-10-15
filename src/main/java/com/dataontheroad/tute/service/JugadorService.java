package com.dataontheroad.tute.service;

import com.dataontheroad.tute.domain.Carta;
import com.dataontheroad.tute.domain.Jugador;

import java.util.List;

public interface JugadorService {

    public void ganarMano(Jugador jugador, List<Carta> cartaList);

    public boolean robarCarta(Jugador jugador, Carta carta);

    public boolean tirarCarta(Jugador jugador, Carta carta);
}
