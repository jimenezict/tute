package com.dataontheroad.tute.juego.service.cartas;

import com.dataontheroad.tute.juego.domain.cartas.Baraja;
import com.dataontheroad.tute.juego.domain.cartas.Carta;
import com.dataontheroad.tute.juego.domain.cartas.CartaEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.dataontheroad.tute.juego.service.cartas.BarajaService.*;
import static org.junit.jupiter.api.Assertions.*;

class BarajaServiceImplTest {

    private Baraja baraja;

    @BeforeEach
    public void setUp() {
        baraja = crearBaraja();
        mezclarBaraja(baraja);
    }

    @Test
    void seHaMezcladoLaBaraja() {
        Carta carta1 = new Carta(CartaEnum.ESPADA, 1);
        Carta carta40 = new Carta(CartaEnum.ORO, 12);

        assertEquals(40, baraja.getListaCartasBaraja().size());
        assertFalse(carta1.equals(baraja.getListaCartasBaraja().get(0)) && carta40.equals(baraja.getListaCartasBaraja().get(39)));
    }

    @Test
    void cogerUnaCarta() {
        Carta carta1 = cogerCartaBaraja(baraja);

        assertTrue(carta1.getNumero() <= 12);
        assertTrue(carta1.getNumero() >= 1);
        assertNotNull(carta1.getPalo());
        assertEquals(39, baraja.getListaCartasBaraja().size());

        Carta carta2 = cogerCartaBaraja(baraja);

        assertTrue(carta2.getNumero() <= 12);
        assertTrue(carta2.getNumero() >= 1);
        assertNotNull(carta2.getPalo());
        assertEquals(38, baraja.getListaCartasBaraja().size());
    }

}