package com.dataontheroad.tute;

import com.dataontheroad.tute.domain.jugador.Jugador;
import com.dataontheroad.tute.service.jugador.StrategyAbstract;

import java.util.ArrayList;

public class ObjectCreationHelper {

    public static ArrayList<Jugador> creadorListaJugardoresPartidaConLaMismaEstrategia(int numeroJugadores, StrategyAbstract strategyAbstract) {
        ArrayList<Jugador> listJugador = new ArrayList<>();
        for(int i=0; i < numeroJugadores; i++) {
            listJugador.add(new Jugador(strategyAbstract));
        }
        return listJugador;
    }
}
