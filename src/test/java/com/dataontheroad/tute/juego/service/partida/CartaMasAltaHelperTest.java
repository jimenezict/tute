package com.dataontheroad.tute.juego.service.partida;

import com.dataontheroad.tute.juego.domain.cartas.Carta;
import com.dataontheroad.tute.juego.domain.cartas.CartaEnum;
import org.junit.jupiter.api.Test;

import static com.dataontheroad.tute.juego.service.cartas.CartaService.crearCarta;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CartaMasAltaHelperTest {

    Carta basto1 = new Carta(CartaEnum.BASTO, 1);
    Carta basto2 = new Carta(CartaEnum.BASTO, 2);
    Carta basto3 = new Carta(CartaEnum.BASTO, 3);
    Carta basto4 = new Carta(CartaEnum.BASTO, 4);

    Carta espada1 = new Carta(CartaEnum.ESPADA, 1);
    Carta espada2 = new Carta(CartaEnum.ESPADA, 2);
    Carta espada5 = crearCarta(CartaEnum.ESPADA, 5);

    @Test
    void noHayCartaMasAltaEsCierto() {
        assertTrue(CartaMasAltaHelper.cartaMasAlta(null, basto1, basto2));
    }

    @Test
    void paloDeMuestraSuperaNumero() {
        assertTrue(CartaMasAltaHelper.cartaMasAlta(basto2, basto1, basto3));
    }

    @Test
    void paloDeMuestraNoSuperaNumero() {
        assertFalse(CartaMasAltaHelper.cartaMasAlta(basto3, basto1, basto2));
    }

    @Test
    void cartaDeMuestraEsBastoCartaMasAltaEsBastoYTiroEspadaMasBaja() {
        assertFalse(CartaMasAltaHelper.cartaMasAlta(basto3, basto2, espada2));
    }

    @Test
    void cartaDeMuestraEsBastoCartaMasAltaEsBastoYTiroEspadaMasAlta() {
        assertFalse(CartaMasAltaHelper.cartaMasAlta(basto3, basto2, espada1));
    }

    @Test
    void cartaDeMuestraEsBastoCartaMasAltaEsBastoYTiroBastoMasAlto() {
        assertTrue(CartaMasAltaHelper.cartaMasAlta(basto2, basto1, basto4));
    }

    @Test
    void cartaDeMuestraEsBastoCartaMasAltaEsBastoYTiroBastoMasBajo() {
        assertFalse(CartaMasAltaHelper.cartaMasAlta(basto4, basto1, basto2));
    }

    @Test
    void cartaDeMuestraEsEspadaCartaMasAltaEsBastoYTiroBastoMasAlto() {
        assertTrue(CartaMasAltaHelper.cartaMasAlta(basto2, espada1, basto4));
    }

    @Test
    void cartaDeMuestraEsEspadaCartaMasAltaEsBastoYTiroBastoMasBajo() {
        assertFalse(CartaMasAltaHelper.cartaMasAlta(basto4, espada1, basto2));
    }

    @Test
    void cartaPaloDeMuestraPeroMenorValorQueCartaMuestra() {
        assertTrue(CartaMasAltaHelper.cartaMasAlta(espada5, basto3, basto4));
    }

}