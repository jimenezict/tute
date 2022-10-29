package com.dataontheroad.tute.juego.domain;

import com.dataontheroad.tute.juego.domain.cartas.Carta;
import com.dataontheroad.tute.juego.domain.cartas.CartaEnum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CartaTest {

    @Test
    void dosCartasIgualesRetornanTrue(){
        Carta carta1 = new Carta(CartaEnum.COPA,3);
        Carta carta2 = new Carta(CartaEnum.COPA, 3);

        assertEquals(carta1,carta2);
    }

    @Test
    void dosCartasDiferentesRetornanFalso(){
        Carta carta1 = new Carta(CartaEnum.COPA,3);
        Carta carta2 = new Carta(CartaEnum.ORO, 3);

        assertNotEquals(carta1,carta2);
    }

}