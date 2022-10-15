package com.dataontheroad.tute.service.cartas;

import com.dataontheroad.tute.domain.cartas.Carta;
import com.dataontheroad.tute.domain.cartas.CartaEnum;

public interface CartaService {

    Carta crearCarta(CartaEnum palo, Integer numero);
}
