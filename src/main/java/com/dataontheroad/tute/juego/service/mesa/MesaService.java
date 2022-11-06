package com.dataontheroad.tute.juego.service.mesa;

import com.dataontheroad.tute.juego.domain.cartas.Baraja;
import com.dataontheroad.tute.juego.domain.cartas.Carta;
import com.dataontheroad.tute.juego.domain.jugador.Jugador;
import com.dataontheroad.tute.juego.domain.mesa.Mesa;
import com.dataontheroad.tute.juego.service.cartas.BarajaService;

import java.util.ArrayList;
import java.util.List;

import static com.dataontheroad.tute.juego.service.cartas.BarajaService.*;

public class MesaService {

    public static Mesa crearMesa(List<Jugador> listaJugadores) {
        Mesa mesa = new Mesa();

        crearJugadores(listaJugadores, mesa);
        crearBaraja(mesa);
        cogerCartaMuestra(mesa);

        for(Jugador jugador: listaJugadores) {
            List<Carta> cartasIniciales = new ArrayList<>();
            cartasIniciales.add(cogerCartaBaraja(mesa.getBaraja()));
            cartasIniciales.add(cogerCartaBaraja(mesa.getBaraja()));
            cartasIniciales.add(cogerCartaBaraja(mesa.getBaraja()));
            jugador.setMano(cartasIniciales);
        }

        return mesa;
    }

    private static void cogerCartaMuestra(Mesa mesa) {
        mesa.setCartaMuestra(cogerCartaBaraja(mesa.getBaraja()));
    }

    private static void crearJugadores(List<Jugador> listaJugadores, Mesa mesa) {
        mesa.setJugadorList(listaJugadores);
    }

    private static void crearBaraja(Mesa mesa) {
        Baraja baraja = BarajaService.crearBaraja();
        mezclarBaraja(baraja);
        mesa.setBaraja(baraja);
    }
}
