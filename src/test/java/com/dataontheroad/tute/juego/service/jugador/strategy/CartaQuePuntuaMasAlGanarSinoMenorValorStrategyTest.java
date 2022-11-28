package com.dataontheroad.tute.juego.service.jugador.strategy;

import com.dataontheroad.tute.juego.domain.cartas.Carta;
import com.dataontheroad.tute.juego.domain.cartas.CartaEnum;
import com.dataontheroad.tute.juego.domain.jugador.Jugador;
import com.dataontheroad.tute.juego.domain.partida.Ronda;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.dataontheroad.tute.juego.service.cartas.CartaService.crearCarta;
import static org.junit.jupiter.api.Assertions.*;

class CartaQuePuntuaMasAlGanarSinoMenorValorStrategyTest {
    Ronda ronda;
    CartaQuePuntuaMasAlGanarSinoMenorValorStrategy strategy = new CartaQuePuntuaMasAlGanarSinoMenorValorStrategy();
    Jugador jugador;
    Carta cartaMuestra;

    @BeforeEach
    public void setUp() {
        ronda = new Ronda();
        ronda.setCartaMasAlta(crearCarta(CartaEnum.ESPADA, 1));
        cartaMuestra = crearCarta(CartaEnum.ESPADA, 2);
        jugador = new Jugador();
    }

    @Test
    public void ningunaCartaSuperaMesaYEntregaLaPeor_1() {
        List<Carta> mano = new ArrayList<>();
        mano.add(crearCarta(CartaEnum.ESPADA,5));
        mano.add(crearCarta(CartaEnum.ORO, 3));
        mano.add(crearCarta(CartaEnum.ORO, 7));
        jugador.setMano(mano);

        assertEquals(strategy.jugarCarta(ronda, cartaMuestra, jugador), crearCarta(CartaEnum.ORO, 7));
    }

    @Test
    public void ningunaCartaSuperaMesaYEntregaLaPeor_2() {
        List<Carta> mano = new ArrayList<>();
        mano.add(crearCarta(CartaEnum.ORO, 7));
        mano.add(crearCarta(CartaEnum.ESPADA,5));
        mano.add(crearCarta(CartaEnum.ORO, 3));
        jugador.setMano(mano);

        assertEquals(strategy.jugarCarta(ronda, cartaMuestra, jugador), crearCarta(CartaEnum.ORO, 7));
    }

    @Test
    public void ningunaCartaSuperaMesaYEntregaLaPeor_3() {
        List<Carta> mano = new ArrayList<>();
        mano.add(crearCarta(CartaEnum.ESPADA,5));
        mano.add(crearCarta(CartaEnum.ORO, 7));
        mano.add(crearCarta(CartaEnum.ORO, 3));
        jugador.setMano(mano);

        assertEquals(strategy.jugarCarta(ronda, cartaMuestra, jugador), crearCarta(CartaEnum.ORO, 7));
    }

}