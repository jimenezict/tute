package com.dataontheroad.tute.juego.service.jugador;

import com.dataontheroad.tute.juego.domain.cartas.Carta;
import com.dataontheroad.tute.juego.domain.jugador.Jugador;
import com.dataontheroad.tute.juego.domain.mesa.Mesa;

import java.util.Random;

public class CualquierCartaDeLaManoAleatoriamenteStrategy extends StrategyAbstract {

    @Override
    public Carta jugarCarta(Mesa mesa, Jugador jugador) {
        Random r = new Random();
        return jugador.getMano().get(r.nextInt(jugador.getMano().size()));
    }
}
