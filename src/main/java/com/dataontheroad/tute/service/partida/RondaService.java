package com.dataontheroad.tute.service.partida;

import com.dataontheroad.tute.domain.cartas.Carta;
import com.dataontheroad.tute.domain.jugador.Jugador;
import com.dataontheroad.tute.domain.mesa.Mesa;
import com.dataontheroad.tute.service.cartas.BarajaService;
import com.dataontheroad.tute.service.jugador.JugadorService;

public interface RondaService {

    boolean iniciarRonda(Mesa mesa, BarajaService barajaService, JugadorService jugadorService);

    void finalizarRonda(Mesa mesa);

    Carta jugadorJuegaCarta(Mesa mesa, Jugador jugador, Carta carta);
}
