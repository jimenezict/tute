package com.dataontheroad.tute.experimento.api.service;

import com.dataontheroad.tute.experimento.domain.ExperimentoColectivo;
import com.dataontheroad.tute.juego.service.jugador.strategy.StrategyAbstract;

import java.util.List;

public interface ExperimentoService {

    ExperimentoColectivo ejecutarExperimento(List<Integer> strategyList, int numExperimentos);

    StrategyAbstract identificadorStrategyConverter(Integer identificador);
}
