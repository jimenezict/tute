package com.dataontheroad.tute.juego.service.jugador;

import com.dataontheroad.tute.juego.domain.cartas.Carta;
import com.dataontheroad.tute.juego.domain.jugador.Jugador;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static com.dataontheroad.tute.ObjectCreationHelper.creadorCartaAleatorias;
import static org.junit.jupiter.api.Assertions.*;

class CualquierCartaDeLaManoAleatoriamenteStrategyTest {

    StrategyAbstract strategy = new CualquierCartaDeLaManoAleatoriamenteStrategy();

    @ParameterizedTest
    @ValueSource(ints = {3, 2, 1})
    void retornaCualquierCartaQueEstabaPreviamenteEnManoCuandoHayNCartas(int numeroCartas) {
        List<Carta> cartas = creadorCartaAleatorias(numeroCartas);
        verificarCartaJugadaEstabaEnMano(cartas);
    }

    private void verificarCartaJugadaEstabaEnMano(List<Carta> cartas) {
        Jugador jugador = new Jugador();
        jugador.setMano(cartas);
        Carta carta =strategy.jugarCarta(null, jugador);
        assertTrue(cartas.contains(carta));
    }

}