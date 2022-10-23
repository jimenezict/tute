package com.dataontheroad.tute.domain.jugador;

import com.dataontheroad.tute.domain.cartas.Carta;
import com.dataontheroad.tute.domain.mesa.Mesa;

public abstract class StrategyAbstract  {

    public abstract Carta jugarCarta(Mesa mesa, Jugador jugador);

}
