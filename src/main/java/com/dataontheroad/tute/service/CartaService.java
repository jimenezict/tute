package com.dataontheroad.tute.service;

import com.dataontheroad.tute.domain.Carta;
import com.dataontheroad.tute.domain.CartaEnum;

public interface CartaService {

    Carta crearCarta(CartaEnum palo, Integer numero);
}
