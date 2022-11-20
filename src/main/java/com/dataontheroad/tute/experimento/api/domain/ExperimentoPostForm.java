package com.dataontheroad.tute.experimento.api.domain;

import java.util.List;

public class ExperimentoPostForm {

    private List<Integer> strategyList;

    private int numExperimentos;


    public List<Integer> getStrategyList() {
        return strategyList;
    }

    public void setStrategyList(List<Integer> strategyList) {
        this.strategyList = strategyList;
    }


    public int getNumExperimentos() {
        return numExperimentos;
    }

    public void setNumExperimentos(int numExperimentos) {
        this.numExperimentos = numExperimentos;
    }
}
