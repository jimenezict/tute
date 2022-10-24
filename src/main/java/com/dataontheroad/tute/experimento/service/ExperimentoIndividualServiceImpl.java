package com.dataontheroad.tute.experimento.service;

import com.dataontheroad.tute.domain.jugador.Jugador;
import com.dataontheroad.tute.domain.partida.Partida;
import com.dataontheroad.tute.experimento.domain.ExperimentoIndividual;
import com.dataontheroad.tute.service.partida.PartidaService;
import com.dataontheroad.tute.service.partida.PartidaServiceImpl;

import java.util.List;

public class ExperimentoIndividualServiceImpl implements ExperimentoIndividualService {

    @Override
    public ExperimentoIndividual creaExperimentoIndividual(List<Jugador> jugadorList) {
        PartidaService partidaService = new PartidaServiceImpl();
        ExperimentoIndividual experimentoIndividual = new ExperimentoIndividual();

        Partida partida = partidaService.crearPartida(jugadorList);
        partidaService.ejecutarPartida(partida);
        partidaService.cierrePartida(partida);

        experimentoIndividual.setJugadorGanador(partida.getJugadorGanador());
        experimentoIndividual.setNumeroJugador(jugadorList.size());
        experimentoIndividual.setResultados(partida.getMesa().getJugadorList().stream().mapToInt(jugador -> jugador.getPuntuacion()).toArray());
        experimentoIndividual.setOrdenJugadorGanador(jugadorList.indexOf(partida.getJugadorGanador()));

        return experimentoIndividual;
    }

}
