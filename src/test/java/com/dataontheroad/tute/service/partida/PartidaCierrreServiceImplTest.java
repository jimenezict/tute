package com.dataontheroad.tute.service.partida;

import com.dataontheroad.tute.domain.jugador.Jugador;
import com.dataontheroad.tute.domain.partida.EstadoPartidaEnum;
import com.dataontheroad.tute.domain.partida.Partida;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PartidaCierrreServiceImplTest {

    ArrayList<Jugador> listJugadores;

    @BeforeEach
    public void setUp() {
        listJugadores = new ArrayList();
    }

    @Test
    public void pruebaCierrePartidaDosJugadoresSegundoGanador() {

        listJugadores.add(new Jugador());
        listJugadores.add(new Jugador());

        Partida partida = (new PartidaServiceImpl()).crearPartida(listJugadores);

        partida.getMesa().getJugadorList().get(0).setPuntuacion(50);
        partida.getMesa().getJugadorList().get(1).setPuntuacion(70);

        (new PartidaServiceImpl()).cierrePartida(partida);

        assertEquals(EstadoPartidaEnum.FINALIZADA, partida.getEstadoPartida());
        assertEquals(partida.getMesa().getJugadorList().get(1), partida.getJugadorGanador());
        assertTrue(partida.getResumenPartida().contains("Baraja"));
    }

    @Test
    public void pruebaCierrePartidaDosJugadoresPrimerGanador() {

        listJugadores.add(new Jugador());
        listJugadores.add(new Jugador());

        Partida partida = (new PartidaServiceImpl()).crearPartida(listJugadores);

        partida.getMesa().getJugadorList().get(0).setPuntuacion(70);
        partida.getMesa().getJugadorList().get(1).setPuntuacion(50);

        (new PartidaServiceImpl()).cierrePartida(partida);

        assertEquals(EstadoPartidaEnum.FINALIZADA, partida.getEstadoPartida());
        assertEquals(partida.getMesa().getJugadorList().get(0), partida.getJugadorGanador());
    }

}