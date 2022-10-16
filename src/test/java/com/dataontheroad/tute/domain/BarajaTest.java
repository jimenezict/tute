package com.dataontheroad.tute.domain;

import com.dataontheroad.tute.domain.cartas.Baraja;
import com.dataontheroad.tute.domain.cartas.Carta;
import com.dataontheroad.tute.domain.cartas.CartaEnum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BarajaTest {

    @Test
    void seCreaBienLaBaraja() {
        Baraja baraja = new Baraja();
        assertEquals( 40, baraja.getListaCartasBaraja().size());
        assertEquals(new Carta(CartaEnum.ESPADA, 1),baraja.getListaCartasBaraja().get(0));
        assertEquals(new Carta(CartaEnum.ORO, 12),baraja.getListaCartasBaraja().get(39));
    }

}