package com.dataontheroad.tute.juego.service.partida;

import com.dataontheroad.tute.juego.domain.cartas.Carta;
import com.dataontheroad.tute.juego.domain.jugador.Jugador;
import com.dataontheroad.tute.juego.domain.mesa.Mesa;
import com.dataontheroad.tute.juego.domain.partida.Ronda;
import com.dataontheroad.tute.juego.service.jugador.JugadorService;

public interface RondaService {

    boolean iniciarRonda(Mesa mesa, Ronda ronda, JugadorService jugadorService);

    Jugador finalizarRonda(Mesa mesa, Ronda ronda);

    void jugadorJuegaCarta(Ronda ronda, Jugador jugador, Carta carta, Carta cartaMuestra);
}
