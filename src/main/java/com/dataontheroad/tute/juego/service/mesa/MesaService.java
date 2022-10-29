package com.dataontheroad.tute.juego.service.mesa;

import com.dataontheroad.tute.juego.domain.jugador.Jugador;
import com.dataontheroad.tute.juego.domain.mesa.Mesa;

import java.util.List;

public interface MesaService {

    Mesa crearMesa( List<Jugador> listaJugadores);
}
