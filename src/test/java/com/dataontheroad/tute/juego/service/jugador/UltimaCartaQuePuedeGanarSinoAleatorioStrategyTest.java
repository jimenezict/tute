package com.dataontheroad.tute.juego.service.jugador;

import com.dataontheroad.tute.juego.domain.cartas.Carta;
import com.dataontheroad.tute.juego.domain.cartas.CartaEnum;
import com.dataontheroad.tute.juego.domain.jugador.Jugador;
import com.dataontheroad.tute.juego.domain.partida.Ronda;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.dataontheroad.tute.juego.service.cartas.CartaService.crearCarta;
import static org.junit.jupiter.api.Assertions.*;

class UltimaCartaQuePuedeGanarSinoAleatorioStrategyTest {

    StrategyAbstract strategy = new UltimaCartaQuePuedeGanarSinoAleatorioStrategy();

    @Test
    void soloPrimeraCartaEsMejor() {
        Ronda ronda = new Ronda();
        ronda.setCartaMasAlta(crearCarta(CartaEnum.ESPADA,5));
        Carta cartaMuestra = crearCarta(CartaEnum.BASTO, 3);
        Jugador jugador = new Jugador(strategy);
        List<Carta> cartas = new ArrayList<>();
        cartas.add(crearCarta(CartaEnum.ESPADA, 7));
        cartas.add(crearCarta(CartaEnum.ORO, 4));
        cartas.add(crearCarta(CartaEnum.ORO, 5));
        jugador.setMano(cartas);

        Carta cartaJugada = strategy.jugarCarta(ronda, cartaMuestra, jugador);
        assertEquals(cartaJugada, cartas.get(0));

        jugador.getMano().set(0, crearCarta(CartaEnum.ESPADA, 1));
        cartaJugada = strategy.jugarCarta(ronda, cartaMuestra, jugador);
        assertEquals(cartaJugada, cartas.get(0));

        jugador.getMano().set(0, crearCarta(CartaEnum.BASTO, 1));
        cartaJugada = strategy.jugarCarta(ronda, cartaMuestra, jugador);
        assertEquals(cartaJugada, cartas.get(0));

        jugador.getMano().set(0, crearCarta(CartaEnum.BASTO, 5));
        cartaJugada = strategy.jugarCarta(ronda, cartaMuestra, jugador);
        assertEquals(cartaJugada, cartas.get(0));
    }

    @Test
    void soloSegundaCartaEsMejor() {
        Ronda ronda = new Ronda();
        ronda.setCartaMasAlta(crearCarta(CartaEnum.ESPADA,5));
        Carta cartaMuestra = crearCarta(CartaEnum.BASTO, 3);
        Jugador jugador = new Jugador(strategy);
        List<Carta> cartas = new ArrayList<>();
        cartas.add(crearCarta(CartaEnum.ORO, 4));
        cartas.add(crearCarta(CartaEnum.ESPADA, 7));
        cartas.add(crearCarta(CartaEnum.ORO, 5));
        jugador.setMano(cartas);

        Carta cartaJugada = strategy.jugarCarta(ronda, cartaMuestra, jugador);
        assertEquals(cartaJugada, cartas.get(1));

        jugador.getMano().set(1, crearCarta(CartaEnum.ESPADA, 1));
        cartaJugada = strategy.jugarCarta(ronda, cartaMuestra, jugador);
        assertEquals(cartaJugada, cartas.get(1));

        jugador.getMano().set(1, crearCarta(CartaEnum.BASTO, 1));
        cartaJugada = strategy.jugarCarta(ronda, cartaMuestra, jugador);
        assertEquals(cartaJugada, cartas.get(1));

        jugador.getMano().set(1, crearCarta(CartaEnum.BASTO, 5));
        cartaJugada = strategy.jugarCarta(ronda, cartaMuestra, jugador);
        assertEquals(cartaJugada, cartas.get(1));
    }

}