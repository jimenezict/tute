package com.dataontheroad.tute.juego.service.jugador.strategy;

import com.dataontheroad.tute.juego.domain.cartas.Carta;
import com.dataontheroad.tute.juego.domain.jugador.Jugador;
import com.dataontheroad.tute.juego.domain.partida.Ronda;

import java.util.Random;

public class CualquierCartaDeLaManoAleatoriamenteStrategy extends StrategyAbstract {

    @Override
    public Carta jugarCarta(Ronda ronda, Carta cartaMuestra, Jugador jugador) {
        Random r = new Random();
        return jugador.getMano().get(r.nextInt(jugador.getMano().size()));
    }
}
