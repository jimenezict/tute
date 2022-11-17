package com.dataontheroad.tute.juego.service.partida;

import com.dataontheroad.tute.juego.domain.jugador.Jugador;
import com.dataontheroad.tute.juego.domain.partida.EstadoPartidaEnum;
import com.dataontheroad.tute.juego.service.jugador.strategy.PrimeraCartaDeLaManoStrategy;
import com.dataontheroad.tute.juego.domain.partida.Partida;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

import java.util.ArrayList;

import static com.dataontheroad.tute.ObjectCreationHelper.creadorListaJugardoresPartidaConLaMismaEstrategia;
import static com.dataontheroad.tute.juego.service.partida.PartidaService.*;
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
    void pruebaPartidaDosJugadores() {

        listJugadores = creadorListaJugardoresPartidaConLaMismaEstrategia(2, (new PrimeraCartaDeLaManoStrategy()));

        Partida partida = crearPartida(listJugadores);
        ejecutarPartida(partida);
        cierrePartida(partida);
        logger.info(String.valueOf(partida.getMesa().getJugadorList().indexOf(partida.getJugadorGanador())));

        assertEquals(EstadoPartidaEnum.FINALIZADA, partida.getEstadoPartida());
    }


}