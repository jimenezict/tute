package com.dataontheroad.tute.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BarajaTest {

    @Test
    public void seCreaBienLaBaraja() {
        Baraja baraja = new Baraja();
        assertEquals( 40, baraja.getBaraja().size());
        assertEquals(new Carta(CartaEnum.ESPADA, 1),baraja.getBaraja().get(0));
        assertEquals(new Carta(CartaEnum.ORO, 12),baraja.getBaraja().get(39));
    }

}