package com.dataontheroad.tute.juego.service.cartas;

import com.dataontheroad.tute.juego.domain.cartas.Baraja;
import com.dataontheroad.tute.juego.domain.cartas.Carta;

public interface BarajaService {

    Baraja crear();

    void mezclar(Baraja baraja);

    Carta cogerCarta(Baraja baraja);
}
