package com.dataontheroad.tute.domain;

import com.dataontheroad.tute.domain.cartas.Carta;
import com.dataontheroad.tute.domain.cartas.CartaEnum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CartaTest {

    @Test
    public void dosCartasIgualesRetornanTrue(){
        Carta carta1 = new Carta(CartaEnum.COPA,3);
        Carta carta2 = new Carta(CartaEnum.COPA, 3);

        assertTrue(carta1.equals(carta2));
        assertTrue(carta2.equals(carta1));
    }

    @Test
    public void dosCartasDiferentesRetornanFalso(){
        Carta carta1 = new Carta(CartaEnum.COPA,3);
        Carta carta2 = new Carta(CartaEnum.ORO, 3);

        assertFalse(carta1.equals(carta2));
        assertFalse(carta2.equals(carta1));
    }

}