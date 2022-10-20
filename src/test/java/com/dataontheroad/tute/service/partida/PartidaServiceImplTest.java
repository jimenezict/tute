package com.dataontheroad.tute.service.partida;

import com.dataontheroad.tute.domain.jugador.Jugador;
import com.dataontheroad.tute.domain.partida.Partida;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

        for(int i= 0; i < 4; i++) {
            assertEquals(0, partida.getMesa().getJugadorList().get(i).getMano().size());
        }

        int cartasTotales = partida.getMesa().getBaraja().getListaCartasBaraja().size()
                + partida.getMesa().getJugadorList().stream().mapToInt(jugador -> jugador.getDescartes().size()).sum();


        assertEquals(10, partida.getNumRonda());
        assertEquals(120, partida.getMesa().getJugadorList().stream().mapToInt(jugador -> jugador.getPuntuacion()).sum());
        assertEquals(40, cartasTotales);
    }


}