package com.dataontheroad.tute.service.partida;

import com.dataontheroad.tute.domain.jugador.Jugador;
import com.dataontheroad.tute.domain.partida.Partida;

import java.util.List;


public interface PartidaService {

    Partida crearPartida(List<Jugador> jugadorList);

    void ejecutarPartida(Partida partida);

    void cierrePartida(Partida partida);
}
