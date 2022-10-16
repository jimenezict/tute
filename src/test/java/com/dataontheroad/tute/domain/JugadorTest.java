package com.dataontheroad.tute.domain;

import com.dataontheroad.tute.domain.jugador.Jugador;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JugadorTest {

    @Test
    void jugadorInicializado() {
        Jugador jugador = new Jugador();
        assertTrue(jugador.getMano().isEmpty());
        assertTrue(jugador.getDescartes().isEmpty());
        assertEquals(0, jugador.getPuntuacion());
    }

    @Test
    void jugadoresNoTienenMismoId() {
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        assertNotEquals(jugador1.getId(), jugador2.getId());
    }

}