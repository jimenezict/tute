package com.dataontheroad.tute.juego.service.mesa;

import com.dataontheroad.tute.juego.domain.cartas.Baraja;
import com.dataontheroad.tute.juego.domain.cartas.Carta;
import com.dataontheroad.tute.juego.domain.jugador.Jugador;
import com.dataontheroad.tute.juego.domain.mesa.Mesa;
import com.dataontheroad.tute.juego.service.cartas.BarajaService;
import com.dataontheroad.tute.juego.service.cartas.BarajaServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class MesaServiceImpl implements MesaService {

    @Override
    public Mesa crearMesa(List<Jugador> listaJugadores) {
        Mesa mesa = new Mesa();
        BarajaService barajaService = new BarajaServiceImpl();

        crearJugadores(listaJugadores, mesa);
        crearBaraja(mesa);
        cogerCartaMuestra(mesa);

        for(Jugador jugador: listaJugadores) {
            List<Carta> cartasIniciales = new ArrayList<>();
            cartasIniciales.add(barajaService.cogerCarta(mesa.getBaraja()));
            cartasIniciales.add(barajaService.cogerCarta(mesa.getBaraja()));
            cartasIniciales.add(barajaService.cogerCarta(mesa.getBaraja()));
            jugador.setMano(cartasIniciales);
        }

        return mesa;
    }

    private void cogerCartaMuestra(Mesa mesa) {
        BarajaService barajaService = new BarajaServiceImpl();
        mesa.setCartaMuestra(barajaService.cogerCarta(mesa.getBaraja()));
    }

    private void crearJugadores(List<Jugador> listaJugadores, Mesa mesa) {
        mesa.setJugadorList(listaJugadores);
    }

    private void crearBaraja(Mesa mesa) {
        BarajaService barajaService = new BarajaServiceImpl();
        Baraja baraja = new Baraja();
        barajaService.mezclar(baraja);
        mesa.setBaraja(baraja);
    }
}
