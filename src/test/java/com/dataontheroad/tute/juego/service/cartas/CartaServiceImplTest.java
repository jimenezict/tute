package com.dataontheroad.tute.juego.service.cartas;

import com.dataontheroad.tute.juego.domain.cartas.Carta;
import com.dataontheroad.tute.juego.domain.cartas.CartaEnum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class CartaServiceImplTest {

    @Test
    void numeroNegativoEsCartaNoValida() {
        CartaService cartaService = new CartaServiceImpl();
        assertNull(cartaService.crearCarta(CartaEnum.BASTO, -3));
    }

    @Test
    void numeroGrandeEsCartaNoValida() {
        CartaService cartaService = new CartaServiceImpl();
        assertNull(cartaService.crearCarta(CartaEnum.BASTO, 13));
    }

    @Test
    void paloNuloEsCartaNoValida() {
        CartaService cartaService = new CartaServiceImpl();
        assertNull(cartaService.crearCarta(null, 4));
    }

    @Test
    void paloEspadaNumero3EsCartaValida() {
        CartaService cartaService = new CartaServiceImpl();
        Carta carta = cartaService.crearCarta(CartaEnum.ESPADA, 3);
        assertEquals(3, carta.getNumero());
        assertEquals(CartaEnum.ESPADA, carta.getPalo());
    }

}