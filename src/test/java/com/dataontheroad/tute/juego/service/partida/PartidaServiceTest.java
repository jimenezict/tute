package com.dataontheroad.tute.juego.service.partida;

import com.dataontheroad.tute.juego.domain.jugador.Jugador;
import com.dataontheroad.tute.juego.service.jugador.PrimeraCartaDeLaManoStrategy;
import com.dataontheroad.tute.juego.domain.partida.Partida;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static com.dataontheroad.tute.ObjectCreationHelper.creadorListaJugardoresPartidaConLaMismaEstrategia;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PartidaServiceTest {

    ArrayList<Jugador> listJugadores;

    @BeforeEach
    public void setUp() {
        listJugadores = new ArrayList();
    }

    @Test
    public void pruebaPartidaDosJugadores() {

        listJugadores = creadorListaJugardoresPartidaConLaMismaEstrategia(2, (new PrimeraCartaDeLaManoStrategy()));

                Partida partida = (new PartidaService()).crearPartida(listJugadores);
        (new PartidaService()).ejecutarPartida(partida);

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

        listJugadores = creadorListaJugardoresPartidaConLaMismaEstrategia(3, (new PrimeraCartaDeLaManoStrategy()));

        Partida partida = (new PartidaService()).crearPartida(listJugadores);
        (new PartidaService()).ejecutarPartida(partida);

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

        listJugadores = creadorListaJugardoresPartidaConLaMismaEstrategia(4, (new PrimeraCartaDeLaManoStrategy()));

        Partida partida = (new PartidaService()).crearPartida(listJugadores);
        (new PartidaService()).ejecutarPartida(partida);

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

        listJugadores = creadorListaJugardoresPartidaConLaMismaEstrategia(5, (new PrimeraCartaDeLaManoStrategy()));

        Partida partida = (new PartidaService()).crearPartida(listJugadores);
        (new PartidaService()).ejecutarPartida(partida);

        for(int i= 0; i < listJugadores.size(); i++) {
            assertEquals(0, partida.getMesa().getJugadorList().get(i).getMano().size());
        }

        int cartasTotales = partida.getMesa().getBaraja().getListaCartasBaraja().size()
                + partida.getMesa().getJugadorList().stream().mapToInt(jugador -> jugador.getDescartes().size()).sum();


        assertEquals(40/listJugadores.size(), partida.getNumRonda());
        assertEquals(40, cartasTotales);
    }


}