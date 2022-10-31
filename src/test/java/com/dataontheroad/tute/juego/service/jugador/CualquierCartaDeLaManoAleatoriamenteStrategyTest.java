package com.dataontheroad.tute.juego.service.jugador;

import com.dataontheroad.tute.juego.domain.cartas.Carta;
import com.dataontheroad.tute.juego.domain.jugador.Jugador;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.dataontheroad.tute.ObjectCreationHelper.creadorCartaAleatorias;
import static org.junit.jupiter.api.Assertions.*;

class CualquierCartaDeLaManoAleatoriamenteStrategyTest {

    StrategyAbstract strategy = new CualquierCartaDeLaManoAleatoriamenteStrategy();

    @Test
    void retornaCualquierCartaQueEstabaPreviamenteEnManoCuandoHayTresCartas() {
        List<Carta> cartas = creadorCartaAleatorias(3);
        verificarCartaJugadaEstabaEnMano(cartas);
    }

    @Test
    void retornaCualquierCartaQueEstabaPreviamenteEnManoCuandoHayDosCartas() {
        List<Carta> cartas = creadorCartaAleatorias(2);
        verificarCartaJugadaEstabaEnMano(cartas);
    }

    @Test
    void retornaCualquierCartaQueEstabaPreviamenteEnManoCuandoHayUnaCarta() {
        List<Carta> cartas = creadorCartaAleatorias(1);
        verificarCartaJugadaEstabaEnMano(cartas);
    }

    private void verificarCartaJugadaEstabaEnMano(List<Carta> cartas) {
        Jugador jugador = new Jugador();
        jugador.setMano(cartas);
        Carta carta =strategy.jugarCarta(null, jugador);
        assertTrue(cartas.contains(carta));
    }

}