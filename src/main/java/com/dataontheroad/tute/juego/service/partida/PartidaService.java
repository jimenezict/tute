package com.dataontheroad.tute.juego.service.partida;

import com.dataontheroad.tute.juego.domain.cartas.Carta;
import com.dataontheroad.tute.juego.domain.jugador.Jugador;
import com.dataontheroad.tute.juego.domain.partida.EstadoPartidaEnum;
import com.dataontheroad.tute.juego.domain.partida.Partida;
import com.dataontheroad.tute.juego.domain.partida.Ronda;
import com.dataontheroad.tute.juego.service.jugador.JugadorService;
import com.google.gson.Gson;
import org.slf4j.Logger;

import java.util.Comparator;
import java.util.List;
import java.util.Random;

import static com.dataontheroad.tute.juego.service.partida.RondaService.*;
import static org.slf4j.LoggerFactory.getLogger;
import static org.springframework.util.Assert.notNull;

public class PartidaService {

    private static Logger logger = getLogger(PartidaService.class);

    private PartidaService() {
        throw new IllegalStateException("Utility class");
    }

    public static Partida crearPartida(List<Jugador> jugadorList) {
        inicializarJugadores(jugadorList);
        Partida partida = new Partida(jugadorList);
        partida.setEstadoPartida(EstadoPartidaEnum.INICIALIZADA);
        return partida;
    }

    public static void ejecutarPartida(Partida partida) {
        Ronda ronda;
        int numRonda = 0;
        Jugador jugadorActivo = generarJugadorInicialDeLaPrimeraRonda(partida);
        Carta cartaMuestra = partida.getMesa().getCartaMuestra();
        partida.setEstadoPartida(EstadoPartidaEnum.EN_CURSO);

        logger.info("Iniciando partida con {} jugadores y carta de muestra {{}}", partida.getMesa().getJugadorList().size(), cartaMuestra.toString());

        do {
            int jugadorCount = 0;
            ronda = new Ronda();
            ronda.setJugadorInicial(jugadorActivo);
            logger.info("Iniciando ronda {} con jugador inicial {}", numRonda, jugadorActivo);

            do {
                logger.info("\t Ronda {} - Orden Jugador {} - Jugador {}", numRonda, jugadorCount, jugadorActivo);
                Carta carta = jugadorActivo.getStrategy().jugarCarta(ronda, cartaMuestra, jugadorActivo);
                logger.info("\t\t Juega carta {}", carta.toString());
                if(ronda.getCartaMasAlta() != null) {
                    logger.info("\t\t Antes de jugar la carta mas alta es {}", ronda.getCartaMasAlta().toString());
                }
                jugadorJuegaCarta(ronda, jugadorActivo, carta, cartaMuestra);
                jugadorActivo = getSiguienteJugadorActivo(partida, jugadorActivo);
                jugadorCount++;
                logger.info("\t\t Despues de jugar la carta mas alta es {}", ronda.getCartaMasAlta().toString());

            } while (hanJugadoTodosLosJugadoresEnEstaRonda(partida, jugadorCount));

            jugadorActivo = finalizarRonda(partida.getMesa(), ronda);
            esLaUltimaRonda(partida, ronda);
            numRonda++;
            logger.info("\t Jugador {} ha ganado la ronda {}", jugadorActivo, numRonda);
            logger.info("------------------------------------------------------");
        } while (aunTienenLosJugadoresCartaEnLaMano(partida));

        partida.setNumRonda(numRonda);
        logger.info("Partida Finalizada");
        logger.info("********************************************************************************************");
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
        jugadorList.forEach(JugadorService::inicializarJugadorPartida);
    }

    private static Jugador getJugadorGanador(Partida partida) {
        return partida.getMesa().getJugadorList().stream().max(Comparator.comparing(Jugador::getPuntuacion)).get();
    }

    private static boolean esLaUltimaRonda(Partida partida, Ronda ronda) {
        if (hanJugadoTodosLosJugadoresEnEstaRonda(partida, partida.getMesa().getBaraja().getListaCartasBaraja().size() + 1))
            return true;
        return iniciarRonda(partida.getMesa(), ronda)
                || aunTienenLosJugadoresCartaEnLaMano(partida);
    }

    private static Jugador getSiguienteJugadorActivo(Partida partida, Jugador jugadorActivo) {
        return partida.getMesa().getJugadorList().get((partida.getMesa().getJugadorList().indexOf(jugadorActivo) + 1) % partida.getMesa().getJugadorList().size());
    }

    private static Jugador generarJugadorInicialDeLaPrimeraRonda(Partida partida) {
        Random r = new Random();
        return partida.getMesa().getJugadorList().get(r.nextInt(partida.getMesa().getJugadorList().size()));
    }
}
