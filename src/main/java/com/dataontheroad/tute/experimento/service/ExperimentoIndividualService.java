package com.dataontheroad.tute.experimento.service;

import com.dataontheroad.tute.juego.domain.jugador.Jugador;
import com.dataontheroad.tute.experimento.domain.ExperimentoIndividual;

import java.util.List;

public interface ExperimentoIndividualService {

    ExperimentoIndividual creaExperimentoIndividual(List<Jugador> jugadorList);

}
