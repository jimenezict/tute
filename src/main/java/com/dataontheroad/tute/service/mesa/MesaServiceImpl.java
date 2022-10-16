package com.dataontheroad.tute.service.mesa;

import com.dataontheroad.tute.domain.cartas.Baraja;
import com.dataontheroad.tute.domain.cartas.Carta;
import com.dataontheroad.tute.domain.jugador.Jugador;
import com.dataontheroad.tute.domain.mesa.Mesa;
import com.dataontheroad.tute.service.cartas.BarajaService;

import java.util.ArrayList;
import java.util.List;

public class MesaServiceImpl implements MesaService {

    BarajaService barajaService;

    @Override
    public Mesa crearMesa(BarajaService barajaService, List<Jugador> listaJugadores) {
        Mesa mesa = new Mesa();
        this.barajaService = barajaService;

        crearJugadores(listaJugadores, mesa);
        crearBaraja(mesa);
        cogerCartaMuestra(mesa);

        for(Jugador jugador: listaJugadores) {
            List<Carta> cartasIniciales = new ArrayList<>();
            cartasIniciales.add(this.barajaService.cogerCarta(mesa.getBaraja()));
            cartasIniciales.add(this.barajaService.cogerCarta(mesa.getBaraja()));
            cartasIniciales.add(this.barajaService.cogerCarta(mesa.getBaraja()));
            jugador.setMano(cartasIniciales);
        }

        return mesa;
    }

    private void cogerCartaMuestra(Mesa mesa) {
        mesa.setCartaMuestra(barajaService.cogerCarta(mesa.getBaraja()));
    }

    private void crearJugadores(List<Jugador> listaJugadores, Mesa mesa) {
        mesa.setJugadorList(listaJugadores);
    }

    private void crearBaraja(Mesa mesa) {
        Baraja baraja = new Baraja();
        barajaService.mezclar(baraja);
        mesa.setBaraja(baraja);
    }
}
