package com.dataontheroad.tute.service.partida;

import com.dataontheroad.tute.domain.jugador.Jugador;
import com.dataontheroad.tute.domain.partida.Partida;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.slf4j.LoggerFactory.getLogger;

class PartidaServicePartidasCompletasImplTest {

    ArrayList<Jugador> listJugadores;
    Logger logger = getLogger(PartidaCierrreServiceImplTest.class);

    @BeforeEach
    public void setUp() {
        listJugadores = new ArrayList();
    }

    @Test
    public void pruebaPartidaDosJugadores() {

        listJugadores.add(new Jugador());
        listJugadores.add(new Jugador());

        Partida partida = (new PartidaServiceImpl()).crearPartida(listJugadores);
        (new PartidaServiceImpl()).ejecutarPartida(partida);
        (new PartidaServiceImpl()).cierrePartida(partida);
        logger.info(String.valueOf(partida.getMesa().getJugadorList().indexOf(partida.getJugadorGanador())));
    }


}