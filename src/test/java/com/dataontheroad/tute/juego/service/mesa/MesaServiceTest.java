package com.dataontheroad.tute.juego.service.mesa;

import com.dataontheroad.tute.juego.domain.jugador.Jugador;
import com.dataontheroad.tute.juego.domain.mesa.Mesa;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.dataontheroad.tute.juego.service.mesa.MesaService.crearMesa;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class MesaServiceTest {

    @Test
    void alCrearMesaDeTresJugadoresTodoEsCorrecto() {
        List<Jugador> jugadorList = new ArrayList<>();
        jugadorList.add(new Jugador());
        jugadorList.add(new Jugador());
        jugadorList.add(new Jugador());

        Mesa mesa = crearMesa(jugadorList);
        assertNotNull(mesa.getCartaMuestra());
        assertEquals(30, mesa.getBaraja().getListaCartasBaraja().size());
        assertEquals(3, mesa.getJugadorList().size());

        assertEquals(3, mesa.getJugadorList().get(0).getMano().size());
        assertEquals(3, mesa.getJugadorList().get(1).getMano().size());
        assertEquals(3, mesa.getJugadorList().get(2).getMano().size());
    }

}