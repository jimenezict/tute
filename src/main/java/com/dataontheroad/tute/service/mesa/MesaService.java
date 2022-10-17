package com.dataontheroad.tute.service.mesa;

import com.dataontheroad.tute.domain.jugador.Jugador;
import com.dataontheroad.tute.domain.mesa.Mesa;
import com.dataontheroad.tute.service.cartas.BarajaService;

import java.util.List;

public interface MesaService {

    Mesa crearMesa( List<Jugador> listaJugadores);
}
