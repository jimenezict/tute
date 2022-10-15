package com.dataontheroad.tute.service.cartas;

import com.dataontheroad.tute.domain.cartas.Baraja;
import com.dataontheroad.tute.domain.cartas.Carta;

public interface BarajaService {

    Baraja crear();

    void mezclar(Baraja baraja);

    Carta cogerCarta(Baraja baraja);
}
