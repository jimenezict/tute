package com.dataontheroad.tute.juego.service.jugador.helper;

import com.dataontheroad.tute.juego.domain.cartas.Carta;
import com.dataontheroad.tute.juego.domain.cartas.CartaEnum;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.dataontheroad.tute.juego.service.cartas.CartaService.crearCarta;
import static com.dataontheroad.tute.juego.service.jugador.helper.StrategyHelper.cartaMenorPeso;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StrategyHelperTest {

    @Test
    void cartaMedioMenorPesoMismoPaloDiferenteMuestra() {
        List<Carta> cartaMano = new ArrayList<>();
        cartaMano.add(crearCarta(CartaEnum.ESPADA, 4));
        cartaMano.add(crearCarta(CartaEnum.ESPADA, 2));
        cartaMano.add(crearCarta(CartaEnum.ESPADA, 1));

        assertEquals(cartaMenorPeso(crearCarta(CartaEnum.ORO,6), cartaMano), crearCarta(CartaEnum.ESPADA, 2));
    }

    @Test
    void cartaMedioMenorPesoMismoPaloIgualMuestra() {
        List<Carta> cartaMano = new ArrayList<>();
        cartaMano.add(crearCarta(CartaEnum.ESPADA, 4));
        cartaMano.add(crearCarta(CartaEnum.ESPADA, 2));
        cartaMano.add(crearCarta(CartaEnum.ESPADA, 1));

        assertEquals(cartaMenorPeso(crearCarta(CartaEnum.ESPADA,6), cartaMano), crearCarta(CartaEnum.ESPADA, 2));
    }

    @Test
    void test1_1() {
        List<Carta> cartaMano = new ArrayList<>();
        cartaMano.add(crearCarta(CartaEnum.ESPADA, 6));
        cartaMano.add(crearCarta(CartaEnum.ORO, 2));
        cartaMano.add(crearCarta(CartaEnum.ESPADA, 2));

        assertEquals(cartaMenorPeso(crearCarta(CartaEnum.ESPADA,2), cartaMano), crearCarta(CartaEnum.ESPADA, 2));
    }

    @Test
    void test1_2() {
        List<Carta> cartaMano = new ArrayList<>();
        cartaMano.add(crearCarta(CartaEnum.ESPADA, 6));
        cartaMano.add(crearCarta(CartaEnum.ESPADA, 2));
        cartaMano.add(crearCarta(CartaEnum.ORO, 2));

        assertEquals(cartaMenorPeso(crearCarta(CartaEnum.ESPADA,2), cartaMano), crearCarta(CartaEnum.ESPADA, 2));
    }

    @Test
    void test1_3() {
        List<Carta> cartaMano = new ArrayList<>();
        cartaMano.add(crearCarta(CartaEnum.ORO, 2));
        cartaMano.add(crearCarta(CartaEnum.ESPADA, 6));
        cartaMano.add(crearCarta(CartaEnum.ESPADA, 2));

        assertEquals(cartaMenorPeso(crearCarta(CartaEnum.ESPADA,2), cartaMano), crearCarta(CartaEnum.ESPADA, 2));
    }


}