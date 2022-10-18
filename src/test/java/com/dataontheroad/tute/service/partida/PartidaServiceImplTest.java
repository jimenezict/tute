package com.dataontheroad.tute.service.partida;

import com.dataontheroad.tute.domain.jugador.Jugador;
import com.dataontheroad.tute.domain.partida.Partida;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class PartidaServiceImplTest {

    ArrayList<Jugador> listJugadores;

    @BeforeEach
    public void setUp() {
        listJugadores = new ArrayList();
        listJugadores.add(new Jugador());
        listJugadores.add(new Jugador());
        listJugadores.add(new Jugador());
        listJugadores.add(new Jugador());
    }

    @Test
    public void pruebaParaBorrarDespues() {
        Partida partida = (new PartidaServiceImpl()).crearPartida(listJugadores);
        (new PartidaServiceImpl()).ejecutarPartida(partida);
    }


}