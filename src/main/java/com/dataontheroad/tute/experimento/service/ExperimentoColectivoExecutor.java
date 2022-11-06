package com.dataontheroad.tute.experimento.service;

import com.dataontheroad.tute.juego.domain.jugador.Jugador;
import com.dataontheroad.tute.experimento.domain.ExperimentoColectivo;
import com.dataontheroad.tute.experimento.domain.ExperimentoIndividual;

import java.util.ArrayList;
import java.util.List;

import static com.dataontheroad.tute.experimento.service.ExperimentoIndividualServiceImpl.creaExperimentoIndividual;

public class ExperimentoColectivoExecutor {

    public static ExperimentoColectivo executar(int numeroDePartidas, List<Jugador> jugadorList) {

        ExperimentoColectivo experimentoColectivo = new ExperimentoColectivo(jugadorList.size(), numeroDePartidas);

        for(int i= 0; i < numeroDePartidas; i++) {
            ExperimentoIndividual experimentoIndividual = creaExperimentoIndividual(jugadorList);
            int posicionJugadorGanador = jugadorList.indexOf(experimentoIndividual.getJugadorGanador());
            Integer valor = Integer.valueOf(experimentoColectivo.getListaGanadores().get(posicionJugadorGanador)) + 1;
            experimentoColectivo.getListaGanadores().set(posicionJugadorGanador, valor);
            int[] resultados = experimentoIndividual.getResultados();
            for(int j = 0; j < jugadorList.size(); j++) {
                experimentoColectivo.getListaDeResultados().get(j).add(resultados[j]);
            }
        }

        rellenaListaDeMedias(jugadorList.size(), experimentoColectivo);

        experimentoColectivo.setNumeroDeExperimentos(numeroDePartidas);
        return experimentoColectivo;

    }

    private static void rellenaListaDeMedias(int numeroJugadores, ExperimentoColectivo experimentoColectivo) {
        List<Double> listaMedias = new ArrayList<>();
        for(int i = 0; i < numeroJugadores; i++) {
            listaMedias.add(experimentoColectivo.getListaDeResultados().get(i).stream().mapToInt(x -> x).average().getAsDouble());
        }
        experimentoColectivo.setListaMedias(listaMedias);
    }
}
