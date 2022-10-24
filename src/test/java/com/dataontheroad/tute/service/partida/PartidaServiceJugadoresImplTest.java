package com.dataontheroad.tute.service.partida;

import com.dataontheroad.tute.domain.jugador.Jugador;
import com.dataontheroad.tute.service.jugador.PrimeraCartaDeLaManoStrategy;
import com.dataontheroad.tute.domain.partida.Partida;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

import java.util.ArrayList;

import static com.dataontheroad.tute.ObjectCreationHelper.creadorJugardor;
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

        listJugadores = creadorJugardor(2, (new PrimeraCartaDeLaManoStrategy()));

        Partida partida = (new PartidaServiceImpl()).crearPartida(listJugadores);
        (new PartidaServiceImpl()).ejecutarPartida(partida);
        (new PartidaServiceImpl()).cierrePartida(partida);
        logger.info(String.valueOf(partida.getMesa().getJugadorList().indexOf(partida.getJugadorGanador())));
    }


}