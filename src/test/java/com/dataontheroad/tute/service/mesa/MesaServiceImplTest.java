package com.dataontheroad.tute.service.mesa;

import com.dataontheroad.tute.domain.jugador.Jugador;
import java.util.List;

import com.dataontheroad.tute.domain.mesa.Mesa;
import com.dataontheroad.tute.service.cartas.BarajaService;
import com.dataontheroad.tute.service.cartas.BarajaServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class MesaServiceImplTest {

    MesaService mesaService;
    BarajaService barajaService;

    @BeforeEach
    public void setUp() {
        mesaService = new MesaServiceImpl();
        barajaService = new BarajaServiceImpl();
    }

    @Test
    public void alCrearMesaDeTresJugadoresTodoEsCorrecto() {
        List<Jugador> jugadorList = new ArrayList<>();
        jugadorList.add(new Jugador());
        jugadorList.add(new Jugador());
        jugadorList.add(new Jugador());

        Mesa mesa = mesaService.crearMesa(barajaService, jugadorList);
        assertNotNull(mesa.getCartaMuestra());
        assertEquals(mesa.getBaraja().getBaraja().size(), 30);
        assertEquals(mesa.getJugadorList().size(), 3);

        assertEquals(mesa.getJugadorList().get(0).getMano().size(), 3);
        assertEquals(mesa.getJugadorList().get(1).getMano().size(), 3);
        assertEquals(mesa.getJugadorList().get(2).getMano().size(), 3);
    }

}