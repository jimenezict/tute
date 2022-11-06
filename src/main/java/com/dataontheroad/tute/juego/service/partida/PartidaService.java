package com.dataontheroad.tute.juego.service.partida;

import com.dataontheroad.tute.juego.domain.cartas.Carta;
import com.dataontheroad.tute.juego.domain.jugador.Jugador;
import com.dataontheroad.tute.juego.domain.partida.EstadoPartidaEnum;
import com.dataontheroad.tute.juego.domain.partida.Partida;
import com.dataontheroad.tute.juego.domain.partida.Ronda;
import com.google.gson.Gson;

import java.util.Comparator;
import java.util.List;

import static com.dataontheroad.tute.juego.service.jugador.JugadorService.inicializarJugadorPartida;
import static com.dataontheroad.tute.juego.service.partida.RondaService.jugadorJuegaCarta;

public class PartidaService {

    public static Partida crearPartida(List<Jugador> jugadorList) {
        inicializarJugadores(jugadorList);
        Partida partida = new Partida(jugadorList);
        partida.setEstadoPartida(EstadoPartidaEnum.INICIALIZADA);
        return partida;
    }

    public static void ejecutarPartida(Partida partida) {
        RondaService rondaService = new RondaService();
        Ronda ronda;
        int numRonda = 0;
        Jugador jugadorActivo = generarJugadorInicialDeLaPrimeraRonda(partida);
        Carta cartaMuestra = partida.getMesa().getCartaMuestra();
        partida.setEstadoPartida(EstadoPartidaEnum.EN_CURSO);

        do {
            int jugadorCount = 0;
            ronda = new Ronda();
            ronda.setJugadorInicial(jugadorActivo);

            do {
                jugadorJuegaCarta(ronda, jugadorActivo, jugadorActivo.getStrategy().jugarCarta(partida.getMesa(), jugadorActivo), cartaMuestra);
                jugadorActivo = getSiguienteJugadorActivo(partida, jugadorActivo);
                jugadorCount++;
            } while (hanJugadoTodosLosJugadoresEnEstaRonda(partida, jugadorCount));

            jugadorActivo = rondaService.finalizarRonda(partida.getMesa(), ronda);
            esLaUltimaRonda(partida, rondaService, ronda);
            numRonda++;
        } while (aunTienenLosJugadoresCartaEnLaMano(partida));

        partida.setNumRonda(numRonda);
    }

    private static boolean hanJugadoTodosLosJugadoresEnEstaRonda(Partida partida, int jugadorCount) {
        return jugadorCount < partida.getMesa().getJugadorList().size();
    }

    private static boolean aunTienenLosJugadoresCartaEnLaMano(Partida partida) {
        return !partida.getMesa().getJugadorList().get(0).getMano().isEmpty();
    }

    public static void cierrePartida(Partida partida) {
        partida.setEstadoPartida(EstadoPartidaEnum.FINALIZADA);
        partida.setJugadorGanador(getJugadorGanador(partida));
        partida.setResumenPartida((new Gson()).toJson(partida));
    }



    private static void inicializarJugadores(List<Jugador> jugadorList) {
        jugadorList.forEach(jugador -> inicializarJugadorPartida(jugador));
    }

    private static Jugador getJugadorGanador(Partida partida) {
        return partida.getMesa().getJugadorList().stream().max(Comparator.comparing(Jugador::getPuntuacion)).get();
    }

    private static boolean esLaUltimaRonda(Partida partida, RondaService rondaService, Ronda ronda) {
        if (hanJugadoTodosLosJugadoresEnEstaRonda(partida, partida.getMesa().getBaraja().getListaCartasBaraja().size() + 1))
            return true;
        return rondaService.iniciarRonda(partida.getMesa(), ronda)
                || aunTienenLosJugadoresCartaEnLaMano(partida);
    }

    private static Jugador getSiguienteJugadorActivo(Partida partida, Jugador jugadorActivo) {
        return partida.getMesa().getJugadorList().get((partida.getMesa().getJugadorList().indexOf(jugadorActivo) + 1) % partida.getMesa().getJugadorList().size());
    }

    private static Jugador generarJugadorInicialDeLaPrimeraRonda(Partida partida) {
        return partida.getMesa().getJugadorList().get((int) (Math.random() * partida.getMesa().getJugadorList().size()));
    }
}
