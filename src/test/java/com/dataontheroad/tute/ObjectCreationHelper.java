package com.dataontheroad.tute;

import com.dataontheroad.tute.experimento.api.domain.ExperimentoPostForm;
import com.dataontheroad.tute.experimento.domain.ExperimentoColectivo;
import com.dataontheroad.tute.juego.domain.cartas.Baraja;
import com.dataontheroad.tute.juego.domain.cartas.Carta;
import com.dataontheroad.tute.juego.domain.jugador.Jugador;
import com.dataontheroad.tute.juego.service.jugador.strategy.StrategyAbstract;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

import static com.dataontheroad.tute.juego.service.cartas.BarajaService.crearBaraja;
import static com.dataontheroad.tute.juego.service.cartas.BarajaService.mezclarBaraja;

public class ObjectCreationHelper {

    public static ArrayList<Jugador> creadorListaJugardoresPartidaConLaMismaEstrategia(int numeroJugadores, StrategyAbstract strategyAbstract) {
        ArrayList<Jugador> listJugador = new ArrayList<>();
        for(int i=0; i < numeroJugadores; i++) {
            listJugador.add(new Jugador(strategyAbstract));
        }
        return listJugador;
    }

    public static List<Carta> creadorCartaAleatorias(int numeroCartas) {

        Baraja baraja = crearBaraja();
        mezclarBaraja(crearBaraja());

        return baraja.getListaCartasBaraja().subList(0, numeroCartas);
    }

    public static ExperimentoPostForm creadorExperimentoPostForm(int numeroExperimentos) {
        ExperimentoPostForm experimentoPostForm = new ExperimentoPostForm();
        experimentoPostForm.setNumExperimentos(numeroExperimentos);
        List<Integer> strategyList = new ArrayList<>();
        strategyList.add(5);
        strategyList.add(8);
        experimentoPostForm.setStrategyList(strategyList);
        return experimentoPostForm;
    }

    public static ExperimentoColectivo experimentoColectivo(int numExperimento) {
        ExperimentoColectivo experimentoColectivo = new ExperimentoColectivo(4, numExperimento);
        return experimentoColectivo;
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
