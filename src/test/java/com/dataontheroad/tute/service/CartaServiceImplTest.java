package com.dataontheroad.tute.service;

import com.dataontheroad.tute.domain.Carta;
import com.dataontheroad.tute.domain.CartaEnum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CartaServiceImplTest {

    @Test
    public void numeroNegativoEsCartaNoValida() {
        CartaService cartaService = new CartaServiceImpl();
        assertNull(cartaService.crearCarta(CartaEnum.BASTO, -3));
    }

    @Test
    public void numeroGrandeEsCartaNoValida() {
        CartaService cartaService = new CartaServiceImpl();
        assertNull(cartaService.crearCarta(CartaEnum.BASTO, 13));
    }

    @Test
    public void paloNuloEsCartaNoValida() {
        CartaService cartaService = new CartaServiceImpl();
        assertNull(cartaService.crearCarta(null, 4));
    }

    @Test
    public void paloEspadaNumero3EsCartaValida() {
        CartaService cartaService = new CartaServiceImpl();
        Carta carta = cartaService.crearCarta(CartaEnum.ESPADA, 3);
        assertEquals(3, carta.getNumero());
        assertEquals(CartaEnum.ESPADA, carta.getPalo());
    }

}