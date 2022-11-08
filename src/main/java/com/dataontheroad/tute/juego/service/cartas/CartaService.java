package com.dataontheroad.tute.juego.service.cartas;

import com.dataontheroad.tute.juego.domain.cartas.Carta;
import com.dataontheroad.tute.juego.domain.cartas.CartaEnum;
import org.slf4j.Logger;

import static java.util.Objects.isNull;
import static org.slf4j.LoggerFactory.getLogger;

public class CartaService {

    private static final Logger logger = getLogger(CartaService.class);

    private CartaService() {
        throw new IllegalStateException("Utility class");
    }

    public static Carta crearCarta(CartaEnum palo, Integer numero) {
        if (isNull(palo) || numero < 1 || numero > 12) {
            logger.warn("Error al crear la carta: {} - {}", numero, palo);
            return null;
        }
        return new Carta(palo, numero);
    }
}
