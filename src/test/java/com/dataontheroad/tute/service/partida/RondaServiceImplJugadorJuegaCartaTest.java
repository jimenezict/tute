package com.dataontheroad.tute.service.partida;

import com.dataontheroad.tute.domain.cartas.Carta;
import com.dataontheroad.tute.domain.cartas.CartaEnum;
import com.dataontheroad.tute.domain.jugador.Jugador;
import com.dataontheroad.tute.domain.mesa.Mesa;
import com.dataontheroad.tute.domain.partida.Ronda;
import com.dataontheroad.tute.service.cartas.BarajaService;
import com.dataontheroad.tute.service.cartas.BarajaServiceImpl;
import com.dataontheroad.tute.service.jugador.JugadorService;
import com.dataontheroad.tute.service.jugador.JugadorServiceImpl;
import com.dataontheroad.tute.service.mesa.MesaService;
import com.dataontheroad.tute.service.mesa.MesaServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RondaServiceImplJugadorJuegaCartaTest {

    Mesa mesa;
    Ronda ronda;
    RondaService rondaService;
    BarajaService barajaService;
    JugadorService jugadorService;
    MesaService mesaService;
    Carta cartaMuestra;

    @BeforeEach
    public void setUp() {
        rondaService = new RondaServiceImpl();
        barajaService = new BarajaServiceImpl();
        jugadorService = new JugadorServiceImpl();
        mesaService = new MesaServiceImpl();

        List<Jugador> jugadorList = new ArrayList<>();
        jugadorList.add(new Jugador());
        jugadorList.add(new Jugador());
        jugadorList.add(new Jugador());

        mesa = mesaService.crearMesa(barajaService, jugadorList);
        cartaMuestra = new Carta(CartaEnum.ORO, 3);
        mesa.setCartaMuestra(cartaMuestra);

        ronda = new Ronda();
        ronda.setJugadorInicial(mesa.getJugadorList().get(0));
    }

    @Test
    public void cadaJugadorJuegaUnaCarta() {
        rondaService.jugadorJuegaCarta(ronda, mesa.getJugadorList().get(0), mesa.getJugadorList().get(0).getMano().get(0), cartaMuestra);

        assertEquals(mesa.getJugadorList().get(0).getMano().size(), 2);
        assertEquals(mesa.getJugadorList().get(1).getMano().size(), 3);
        assertEquals(mesa.getJugadorList().get(2).getMano().size(), 3);

        assertEquals(ronda.getCartaMesaList().size(), 1);
        assertNotNull(ronda.getCartaMasAlta());
        assertNotNull(ronda.getJugadorGanador());
        assertEquals(ronda.getCartaMesaList().size(), 1);

        rondaService.jugadorJuegaCarta(ronda, mesa.getJugadorList().get(1), mesa.getJugadorList().get(1).getMano().get(0), cartaMuestra);

        assertEquals(mesa.getJugadorList().get(0).getMano().size(), 2);
        assertEquals(mesa.getJugadorList().get(1).getMano().size(), 2);
        assertEquals(mesa.getJugadorList().get(2).getMano().size(), 3);

        rondaService.jugadorJuegaCarta(ronda, mesa.getJugadorList().get(2), mesa.getJugadorList().get(2).getMano().get(0), cartaMuestra);

        assertEquals(mesa.getJugadorList().get(0).getMano().size(), 2);
        assertEquals(mesa.getJugadorList().get(1).getMano().size(), 2);
        assertEquals(mesa.getJugadorList().get(2).getMano().size(), 2);
    }



}