package com.dataontheroad.tute.juego.service.jugador.strategy;

import com.dataontheroad.tute.juego.domain.cartas.Carta;
import com.dataontheroad.tute.juego.domain.jugador.Jugador;
import com.dataontheroad.tute.juego.domain.partida.Ronda;

public abstract class StrategyAbstract  {

    public abstract Carta jugarCarta(Ronda ronda, Carta cartaMuestra, Jugador jugador);

}
