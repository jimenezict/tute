package com.dataontheroad.tute.service.partida;

import com.dataontheroad.tute.domain.jugador.Jugador;
import com.dataontheroad.tute.service.jugador.PrimeraCartaDeLaManoStrategy;
import com.dataontheroad.tute.domain.partida.Partida;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static com.dataontheroad.tute.ObjectCreationHelper.creadorJugardor;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PartidaServiceImplTest {

    ArrayList<Jugador> listJugadores;

    @BeforeEach
    public void setUp() {
        listJugadores = new ArrayList();
    }

    @Test
    public void pruebaPartidaDosJugadores() {

        listJugadores = creadorJugardor(2, (new PrimeraCartaDeLaManoStrategy()));

                Partida partida = (new PartidaServiceImpl()).crearPartida(listJugadores);
        (new PartidaServiceImpl()).ejecutarPartida(partida);

        for(int i= 0; i < listJugadores.size(); i++) {
            assertEquals(0, partida.getMesa().getJugadorList().get(i).getMano().size());
        }

        int cartasTotales = partida.getMesa().getBaraja().getListaCartasBaraja().size()
                + partida.getMesa().getJugadorList().stream().mapToInt(jugador -> jugador.getDescartes().size()).sum();


        assertEquals(40/listJugadores.size(), partida.getNumRonda());
        assertEquals(120, partida.getMesa().getJugadorList().stream().mapToInt(jugador -> jugador.getPuntuacion()).sum());
        assertEquals(40, cartasTotales);
    }

    @Test
    public void pruebaPartidaTresJugadores() {

        listJugadores = creadorJugardor(3, (new PrimeraCartaDeLaManoStrategy()));

        Partida partida = (new PartidaServiceImpl()).crearPartida(listJugadores);
        (new PartidaServiceImpl()).ejecutarPartida(partida);

        for(int i= 0; i < listJugadores.size(); i++) {
            assertEquals(0, partida.getMesa().getJugadorList().get(i).getMano().size());
        }

        int cartasTotales = partida.getMesa().getBaraja().getListaCartasBaraja().size()
                + partida.getMesa().getJugadorList().stream().mapToInt(jugador -> jugador.getDescartes().size()).sum();


        assertEquals(40/listJugadores.size(), partida.getNumRonda());
        assertEquals(39, cartasTotales);
    }

    @Test
    public void pruebaPartidaCuatroJugadores() {

        listJugadores = creadorJugardor(4, (new PrimeraCartaDeLaManoStrategy()));

        Partida partida = (new PartidaServiceImpl()).crearPartida(listJugadores);
        (new PartidaServiceImpl()).ejecutarPartida(partida);

        for(int i= 0; i < listJugadores.size(); i++) {
            assertEquals(0, partida.getMesa().getJugadorList().get(i).getMano().size());
        }

        int cartasTotales = partida.getMesa().getBaraja().getListaCartasBaraja().size()
                + partida.getMesa().getJugadorList().stream().mapToInt(jugador -> jugador.getDescartes().size()).sum();


        assertEquals(40/listJugadores.size(), partida.getNumRonda());
        assertEquals(120, partida.getMesa().getJugadorList().stream().mapToInt(jugador -> jugador.getPuntuacion()).sum());
        assertEquals(40, cartasTotales);
    }

    @Test
    public void pruebaPartidaCincoJugadores() {

        listJugadores = creadorJugardor(5, (new PrimeraCartaDeLaManoStrategy()));

        Partida partida = (new PartidaServiceImpl()).crearPartida(listJugadores);
        (new PartidaServiceImpl()).ejecutarPartida(partida);

        for(int i= 0; i < listJugadores.size(); i++) {
            assertEquals(0, partida.getMesa().getJugadorList().get(i).getMano().size());
        }

        int cartasTotales = partida.getMesa().getBaraja().getListaCartasBaraja().size()
                + partida.getMesa().getJugadorList().stream().mapToInt(jugador -> jugador.getDescartes().size()).sum();


        assertEquals(40/listJugadores.size(), partida.getNumRonda());
        assertEquals(40, cartasTotales);
    }


}