package com.dataontheroad.tute.experimento.service;

import com.dataontheroad.tute.juego.domain.jugador.Jugador;
import com.dataontheroad.tute.experimento.domain.ExperimentoColectivo;
import com.dataontheroad.tute.experimento.domain.ExperimentoIndividual;

import java.util.ArrayList;
import java.util.List;

import static com.dataontheroad.tute.experimento.service.ExperimentoIndividualService.creaExperimentoIndividual;
import static java.lang.Integer.valueOf;

public class ExperimentoColectivoExecutor {

    private ExperimentoColectivoExecutor() {
        throw new IllegalStateException("Utility class");
    }

    public static ExperimentoColectivo executar(int numeroDePartidas, List<Jugador> jugadorList) {

        ExperimentoColectivo experimentoColectivo = new ExperimentoColectivo(jugadorList.size(), numeroDePartidas);

        for(int i= 0; i < numeroDePartidas; i++) {
            ExperimentoIndividual experimentoIndividual = creaExperimentoIndividual(jugadorList);
            actualizaNumeroDePartidasGanadasDelJugadorGanador(experimentoColectivo, posicionJugadorGanadorDelExperimentoIndividual(jugadorList, experimentoIndividual));
            actualizaResultadosDePartidaParaTodosLosJugadores(jugadorList, experimentoColectivo, experimentoIndividual.getResultados());
        }
        rellenaListaDeMedias(jugadorList.size(), experimentoColectivo);
        return experimentoColectivo;

    }

    private static int posicionJugadorGanadorDelExperimentoIndividual(List<Jugador> jugadorList, ExperimentoIndividual experimentoIndividual) {
        return jugadorList.indexOf(experimentoIndividual.getJugadorGanador());
    }

    private static void actualizaResultadosDePartidaParaTodosLosJugadores(List<Jugador> jugadorList, ExperimentoColectivo experimentoColectivo, int[] resultados) {
        for(int j = 0; j < jugadorList.size(); j++) {
            experimentoColectivo.getListaDeResultados().get(j).add(resultados[j]);
        }
    }

    private static void actualizaNumeroDePartidasGanadasDelJugadorGanador(ExperimentoColectivo experimentoColectivo, int posicionJugadorGanador) {
        experimentoColectivo.getListaGanadores().set(posicionJugadorGanador, experimentoColectivo.getListaGanadores().get(posicionJugadorGanador) + 1);
    }

    private static void rellenaListaDeMedias(int numeroJugadores, ExperimentoColectivo experimentoColectivo) {
        List<Double> listaMedias = new ArrayList<>();
        for(int i = 0; i < numeroJugadores; i++) {
            listaMedias.add(experimentoColectivo.getListaDeResultados().get(i).stream().mapToInt(x -> x).average().getAsDouble());
        }
        experimentoColectivo.setListaMedias(listaMedias);
    }
}
