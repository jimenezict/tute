package com.dataontheroad.tute.juego.service.partida;

import com.dataontheroad.tute.juego.domain.cartas.Carta;
import com.dataontheroad.tute.juego.domain.cartas.CartaEnum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class cartaMasAltaHelperTest {

    Carta basto1 = new Carta(CartaEnum.BASTO, 1);
    Carta basto2 = new Carta(CartaEnum.BASTO, 2);
    Carta basto3 = new Carta(CartaEnum.BASTO, 3);
    Carta basto4 = new Carta(CartaEnum.BASTO, 4);

    Carta espada1 = new Carta(CartaEnum.ESPADA, 1);
    Carta espada2 = new Carta(CartaEnum.ESPADA, 2);

    @Test
    public void noHayCartaMasAltaEsCierto() {
        assertTrue(CartaMasAltaHelper.cartaMasAlta(null, basto1, basto2));
    }

    @Test
    public void paloDeMuestraSuperaNumero() {
        assertTrue(CartaMasAltaHelper.cartaMasAlta(basto2, basto1, basto3));
    }

    @Test
    public void paloDeMuestraNoSuperaNumero() {
        assertFalse(CartaMasAltaHelper.cartaMasAlta(basto3, basto1, basto2));
    }

    @Test
    public void cartaDeMuestraEsBastoCartaMasAltaEsBastoYTiroEspadaMasBaja() {
        assertFalse(CartaMasAltaHelper.cartaMasAlta(basto3, basto2, espada2));
    }

    @Test
    public void cartaDeMuestraEsBastoCartaMasAltaEsBastoYTiroEspadaMasAlta() {
        assertFalse(CartaMasAltaHelper.cartaMasAlta(basto3, basto2, espada1));
    }
}