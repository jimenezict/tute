package com.dataontheroad.tute;

import com.dataontheroad.tute.juego.domain.cartas.Baraja;
import com.dataontheroad.tute.juego.domain.cartas.Carta;
import com.dataontheroad.tute.juego.domain.jugador.Jugador;
import com.dataontheroad.tute.juego.service.jugador.StrategyAbstract;

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

}
