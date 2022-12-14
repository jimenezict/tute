package com.dataontheroad.tute.juego.service.partida;

import com.dataontheroad.tute.juego.domain.jugador.Jugador;
import com.dataontheroad.tute.juego.domain.partida.EstadoPartidaEnum;
import com.dataontheroad.tute.juego.domain.partida.Partida;
import com.dataontheroad.tute.juego.service.jugador.strategy.PrimeraCartaDeLaManoStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static com.dataontheroad.tute.ObjectCreationHelper.creadorListaJugardoresPartidaConLaMismaEstrategia;
import static com.dataontheroad.tute.juego.service.partida.PartidaService.cierrePartida;
import static com.dataontheroad.tute.juego.service.partida.PartidaService.crearPartida;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PartidaCierrreServiceImplTest {

    ArrayList<Jugador> listJugadores;

    @BeforeEach
    public void setUp() {
        listJugadores = new ArrayList();
    }

    @Test
    void pruebaCierrePartidaDosJugadoresSegundoGanador() {

        listJugadores = creadorListaJugardoresPartidaConLaMismaEstrategia(2, (new PrimeraCartaDeLaManoStrategy()));

        Partida partida = crearPartida(listJugadores);

        partida.getMesa().getJugadorList().get(0).setPuntuacion(50);
        partida.getMesa().getJugadorList().get(1).setPuntuacion(70);

        cierrePartida(partida);

        assertEquals(EstadoPartidaEnum.FINALIZADA, partida.getEstadoPartida());
        assertEquals(partida.getMesa().getJugadorList().get(1), partida.getJugadorGanador());
        assertTrue(partida.getResumenPartida().contains("Baraja"));
    }

    @Test
    void pruebaCierrePartidaDosJugadoresPrimerGanador() {

        listJugadores = creadorListaJugardoresPartidaConLaMismaEstrategia(2, (new PrimeraCartaDeLaManoStrategy()));

        Partida partida = crearPartida(listJugadores);

        partida.getMesa().getJugadorList().get(0).setPuntuacion(70);
        partida.getMesa().getJugadorList().get(1).setPuntuacion(50);

        cierrePartida(partida);

        assertEquals(EstadoPartidaEnum.FINALIZADA, partida.getEstadoPartida());
        assertEquals(partida.getMesa().getJugadorList().get(0), partida.getJugadorGanador());
    }

}