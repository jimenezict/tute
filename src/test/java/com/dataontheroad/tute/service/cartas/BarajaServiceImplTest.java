package com.dataontheroad.tute.service.cartas;

import com.dataontheroad.tute.domain.cartas.Baraja;
import com.dataontheroad.tute.domain.cartas.Carta;
import com.dataontheroad.tute.domain.cartas.CartaEnum;
import com.dataontheroad.tute.service.cartas.BarajaService;
import com.dataontheroad.tute.service.cartas.BarajaServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BarajaServiceImplTest {

    private BarajaService barajaService;
    private Baraja baraja;

    @BeforeEach
    public void setUp() {
        barajaService = new BarajaServiceImpl();
        baraja = barajaService.crear();
        barajaService.mezclar(baraja);
    }

    @Test
    public void seHaMezcladoLaBaraja() {
        Carta carta1 = new Carta(CartaEnum.ESPADA, 1);
        Carta carta40 = new Carta(CartaEnum.ORO, 12);

        assertEquals(baraja.getBaraja().size(), 40);
        assertFalse(carta1.equals(baraja.getBaraja().get(0)) && carta40.equals(baraja.getBaraja().get(39)));
    }

    @Test
    public void cogerUnaCarta() {
        Carta carta1 = barajaService.cogerCarta(baraja);

        assertTrue(carta1.getNumero() <= 12);
        assertTrue(carta1.getNumero() >= 1);
        assertNotNull(carta1.getPalo());
        assertEquals(baraja.getBaraja().size(), 39);

        Carta carta2 = barajaService.cogerCarta(baraja);

        assertTrue(carta2.getNumero() <= 12);
        assertTrue(carta2.getNumero() >= 1);
        assertNotNull(carta2.getPalo());
        assertEquals(baraja.getBaraja().size(), 38);
    }

}