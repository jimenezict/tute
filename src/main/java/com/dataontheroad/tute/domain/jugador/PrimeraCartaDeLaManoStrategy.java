package com.dataontheroad.tute.domain.jugador;

import com.dataontheroad.tute.domain.cartas.Carta;
import com.dataontheroad.tute.domain.mesa.Mesa;

public class PrimeraCartaDeLaManoStrategy extends StrategyAbstract {

    @Override
    public Carta jugarCarta(Mesa mesa, Jugador jugador) {
        return jugador.getMano().get(0);
    }

}
