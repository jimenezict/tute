package com.dataontheroad.tute.experimento.api.service;

import com.dataontheroad.tute.experimento.domain.ExperimentoColectivo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperimentoServiceImpl implements ExperimentoService {
    @Override
    public ExperimentoColectivo ejecutarExperimento(List<Integer> strategyList, int numExperimentos) {
        return null;
    }
}
