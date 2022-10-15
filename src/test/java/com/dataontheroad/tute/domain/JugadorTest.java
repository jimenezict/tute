package com.dataontheroad.tute.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JugadorTest {

    @Test
    public void jugadorInicializado() {
        Jugador jugador = new Jugador();
        assertTrue(jugador.getMano().isEmpty());
        assertTrue(jugador.getDescartes().isEmpty());
        assertEquals(jugador.getPuntuacion(), 0);
    }

    @Test
    public void jugadoresNoTienenMismoId() {
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        assertNotEquals(jugador1.getId(), jugador2.getId());
    }

}