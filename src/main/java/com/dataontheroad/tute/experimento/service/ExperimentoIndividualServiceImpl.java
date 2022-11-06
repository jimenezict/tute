package com.dataontheroad.tute.experimento.service;

import com.dataontheroad.tute.juego.domain.jugador.Jugador;
import com.dataontheroad.tute.juego.domain.partida.Partida;
import com.dataontheroad.tute.experimento.domain.ExperimentoIndividual;

import java.util.List;

import static com.dataontheroad.tute.juego.service.partida.PartidaService.*;

public class ExperimentoIndividualServiceImpl implements ExperimentoIndividualService {

    @Override
    public ExperimentoIndividual creaExperimentoIndividual(List<Jugador> jugadorList) {
        ExperimentoIndividual experimentoIndividual = new ExperimentoIndividual();

        Partida partida = crearPartida(jugadorList);
        ejecutarPartida(partida);
        cierrePartida(partida);

        experimentoIndividual.setJugadorGanador(partida.getJugadorGanador());
        experimentoIndividual.setNumeroJugador(jugadorList.size());
        experimentoIndividual.setResultados(partida.getMesa().getJugadorList().stream().mapToInt(jugador -> jugador.getPuntuacion()).toArray());
        experimentoIndividual.setOrdenJugadorGanador(jugadorList.indexOf(partida.getJugadorGanador()));

        return experimentoIndividual;
    }

}
