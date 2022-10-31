package com.dataontheroad.tute;

import com.dataontheroad.tute.juego.domain.cartas.Baraja;
import com.dataontheroad.tute.juego.domain.cartas.Carta;
import com.dataontheroad.tute.juego.domain.jugador.Jugador;
import com.dataontheroad.tute.juego.service.cartas.BarajaService;
import com.dataontheroad.tute.juego.service.cartas.BarajaServiceImpl;
import com.dataontheroad.tute.juego.service.jugador.StrategyAbstract;

import java.util.ArrayList;
import java.util.List;

public class ObjectCreationHelper {

    public static ArrayList<Jugador> creadorListaJugardoresPartidaConLaMismaEstrategia(int numeroJugadores, StrategyAbstract strategyAbstract) {
        ArrayList<Jugador> listJugador = new ArrayList<>();
        for(int i=0; i < numeroJugadores; i++) {
            listJugador.add(new Jugador(strategyAbstract));
        }
        return listJugador;
    }

    public static List<Carta> creadorCartaAleatorias(int numeroCartas) {

        BarajaService barajaService = new BarajaServiceImpl();
        Baraja baraja = barajaService.crear();
        barajaService.mezclar(baraja);

        return baraja.getListaCartasBaraja().subList(0, numeroCartas);
    }

}
