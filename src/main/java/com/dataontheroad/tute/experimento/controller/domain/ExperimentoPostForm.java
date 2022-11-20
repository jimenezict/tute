package com.dataontheroad.tute.experimento.controller.domain;

import com.dataontheroad.tute.juego.domain.jugador.Jugador;
import java.util.List;

public class ExperimentoPostForm {

    private List<Integer> strategyList;


    public List<Integer> getStrategyList() {
        return strategyList;
    }

    public void setStrategyList(List<Integer> strategyList) {
        this.strategyList = strategyList;
    }
}
