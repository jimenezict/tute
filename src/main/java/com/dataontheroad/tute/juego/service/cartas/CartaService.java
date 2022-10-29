package com.dataontheroad.tute.juego.service.cartas;

import com.dataontheroad.tute.juego.domain.cartas.Carta;
import com.dataontheroad.tute.juego.domain.cartas.CartaEnum;

public interface CartaService {

    Carta crearCarta(CartaEnum palo, Integer numero);
}
