package com.dataontheroad.tute.service.partida;

import com.dataontheroad.tute.domain.cartas.Carta;
import com.dataontheroad.tute.domain.jugador.Jugador;
import com.dataontheroad.tute.domain.mesa.Mesa;
import com.dataontheroad.tute.domain.partida.Ronda;
import com.dataontheroad.tute.service.cartas.BarajaService;
import com.dataontheroad.tute.service.jugador.JugadorService;

public interface RondaService {

    boolean iniciarRonda(Mesa mesa, Ronda ronda, BarajaService barajaService, JugadorService jugadorService);

    Jugador finalizarRonda(Mesa mesa, Ronda ronda);

    void jugadorJuegaCarta(Ronda ronda, Jugador jugador, Carta carta, Carta cartaMuestra);
}
