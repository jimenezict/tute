package com.dataontheroad.tute.experimento.service;

import com.dataontheroad.tute.domain.jugador.Jugador;
import com.dataontheroad.tute.experimento.domain.ExperimentoColectivo;
import com.dataontheroad.tute.experimento.domain.ExperimentoIndividual;

import java.util.List;

public class ExperimentoColectivoExecutor {

    public static void executar(int numeroDePartidas, List<Jugador> jugadorList) {

        ExperimentoColectivo experimentoColectivo = new ExperimentoColectivo(jugadorList.size(), numeroDePartidas);
        ExperimentoIndividualService experimentoIndividualService = new ExperimentoIndividualServiceImpl();

        for(int i= 0; i < numeroDePartidas; i++) {
            ExperimentoIndividual experimentoIndividual = experimentoIndividualService.creaExperimentoIndividual(jugadorList);
            int posicionJugadorGanador = jugadorList.indexOf(experimentoIndividual.getJugadorGanador());
            Integer valor = Integer.valueOf(experimentoColectivo.getListaGanadores().get(posicionJugadorGanador)) + 1;
            experimentoColectivo.getListaGanadores().set(posicionJugadorGanador, valor);
            int[] resultados = experimentoIndividual.getResultados();
            for(int j = 0; j < jugadorList.size(); j++) {
                experimentoColectivo.getListaDeResultados().get(j).add(resultados[j]);
            }
        }

        experimentoColectivo.setNumeroDeExperimentos(numeroDePartidas);

    }
}
