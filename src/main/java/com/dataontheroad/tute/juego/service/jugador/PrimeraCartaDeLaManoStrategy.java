package com.dataontheroad.tute.juego.service.jugador;

import com.dataontheroad.tute.juego.domain.cartas.Carta;
import com.dataontheroad.tute.juego.domain.jugador.Jugador;
import com.dataontheroad.tute.juego.domain.mesa.Mesa;

public class PrimeraCartaDeLaManoStrategy extends StrategyAbstract {

    @Override
    public Carta jugarCarta(Mesa mesa, Jugador jugador) {
        return jugador.getMano().get(0);
    }

}
