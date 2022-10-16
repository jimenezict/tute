package com.dataontheroad.tute.service.mesa;

import com.dataontheroad.tute.domain.jugador.Jugador;
import com.dataontheroad.tute.domain.mesa.Mesa;
import com.dataontheroad.tute.service.cartas.BarajaService;
import com.dataontheroad.tute.service.cartas.BarajaServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class MesaServiceImplTest {

    MesaService mesaService;
    BarajaService barajaService;

    @BeforeEach
    public void setUp() {
        mesaService = new MesaServiceImpl();
        barajaService = new BarajaServiceImpl();
    }

    @Test
    void alCrearMesaDeTresJugadoresTodoEsCorrecto() {
        List<Jugador> jugadorList = new ArrayList<>();
        jugadorList.add(new Jugador());
        jugadorList.add(new Jugador());
        jugadorList.add(new Jugador());

        Mesa mesa = mesaService.crearMesa(barajaService, jugadorList);
        assertNotNull(mesa.getCartaMuestra());
        assertEquals(30, mesa.getBaraja().getListaCartasBaraja().size());
        assertEquals(3, mesa.getJugadorList().size());

        assertEquals(3, mesa.getJugadorList().get(0).getMano().size());
        assertEquals(3, mesa.getJugadorList().get(1).getMano().size());
        assertEquals(3, mesa.getJugadorList().get(2).getMano().size());
    }

}