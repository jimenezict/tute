package com.dataontheroad.tute.juego.service.cartas;

import com.dataontheroad.tute.juego.domain.cartas.Carta;
import com.dataontheroad.tute.juego.domain.cartas.CartaEnum;
import org.junit.jupiter.api.Test;

import static com.dataontheroad.tute.juego.service.cartas.CartaService.crearCarta;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class CartaServiceImplTest {

    @Test
    void numeroNegativoEsCartaNoValida() {
        assertNull(crearCarta(CartaEnum.BASTO, -3));
    }

    @Test
    void numeroGrandeEsCartaNoValida() {
        assertNull(crearCarta(CartaEnum.BASTO, 13));
    }

    @Test
    void paloNuloEsCartaNoValida() {
        assertNull(crearCarta(null, 4));
    }

    @Test
    void paloEspadaNumero3EsCartaValida() {
        Carta carta = crearCarta(CartaEnum.ESPADA, 3);
        assertEquals(3, carta.getNumero());
        assertEquals(CartaEnum.ESPADA, carta.getPalo());
    }

}