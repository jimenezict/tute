package com.dataontheroad.tute.juego.service.partida;

import com.dataontheroad.tute.juego.domain.jugador.Jugador;
import com.dataontheroad.tute.juego.domain.partida.Partida;

import java.util.List;


public interface PartidaService {

    Partida crearPartida(List<Jugador> jugadorList);

    void ejecutarPartida(Partida partida);

    void cierrePartida(Partida partida);
}
