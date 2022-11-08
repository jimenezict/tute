package com.dataontheroad.tute.experimento.service;

import com.dataontheroad.tute.juego.domain.jugador.Jugador;
import com.dataontheroad.tute.juego.domain.partida.Partida;
import com.dataontheroad.tute.experimento.domain.ExperimentoIndividual;

import java.util.List;

import static com.dataontheroad.tute.juego.service.partida.PartidaService.*;

public class ExperimentoIndividualService {

    private ExperimentoIndividualService() {
        throw new IllegalStateException("Utility class");
    }

    public static ExperimentoIndividual creaExperimentoIndividual(List<Jugador> jugadorList) {
        Partida partida = crearPartida(jugadorList);
        ejecutarPartida(partida);
        cierrePartida(partida);
        return setearExperimento(jugadorList, partida);
    }

    private static ExperimentoIndividual setearExperimento(List<Jugador> jugadorList, Partida partida) {
        ExperimentoIndividual experimentoIndividual = new ExperimentoIndividual();
        experimentoIndividual.setJugadorGanador(partida.getJugadorGanador());
        experimentoIndividual.setNumeroJugador(jugadorList.size());
        experimentoIndividual.setResultados(partida.getMesa().getJugadorList().stream().mapToInt(Jugador::getPuntuacion).toArray());
        experimentoIndividual.setOrdenJugadorGanador(jugadorList.indexOf(partida.getJugadorGanador()));
        return experimentoIndividual;
    }

}
