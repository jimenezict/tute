package com.dataontheroad.tute.service;

import com.dataontheroad.tute.domain.Baraja;
import com.dataontheroad.tute.domain.Carta;

public interface BarajaService {

    Baraja crear();

    void mezclar(Baraja baraja);

    Carta cogerCarta(Baraja baraja);
}
