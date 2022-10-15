package com.dataontheroad.tute.service;

import com.dataontheroad.tute.domain.Carta;
import com.dataontheroad.tute.domain.CartaEnum;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;
import static org.slf4j.LoggerFactory.getLogger;

@Component
public class CartaServiceImpl implements CartaService {

    private final Logger logger = getLogger(CartaServiceImpl.class);

    @Override
    public Carta crearCarta(CartaEnum palo, Integer numero) {
        if (isNull(palo) || numero < 1 || numero > 12) {
            logger.warn("Error al crear la carta: {} - {}", numero, palo);
            return null;
        }
        return new Carta(palo, numero);
    }
}
