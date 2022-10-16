package com.dataontheroad.tute.service.partida;

import com.dataontheroad.tute.domain.cartas.Carta;
import com.dataontheroad.tute.domain.jugador.Jugador;
import com.dataontheroad.tute.domain.mesa.Mesa;
import com.dataontheroad.tute.service.cartas.BarajaService;
import com.dataontheroad.tute.service.cartas.BarajaServiceImpl;
import com.dataontheroad.tute.service.jugador.JugadorService;
import com.dataontheroad.tute.service.jugador.JugadorServiceImpl;
import com.dataontheroad.tute.service.mesa.MesaService;
import com.dataontheroad.tute.service.mesa.MesaServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

class RondaServiceImplTest {

    Mesa mesa;
    RondaService rondaService;
    BarajaService barajaService;
    JugadorService jugadorService;
    MesaService mesaService;

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

    }

    @Test
    public void seEjecutaRondaInicialConTresJugadores() {
        Carta muestraInicial = mesa.getCartaMuestra();
        int tamanoBarajaInicial = mesa.getBaraja().getBaraja().size();
        boolean exito = rondaService.iniciarRonda(mesa, barajaService, jugadorService);
        int tamanoBarajaFinal = mesa.getBaraja().getBaraja().size();
        Carta muestraFinal = mesa.getCartaMuestra();
        assertTrue(muestraInicial.equals(muestraFinal));

        assertTrue(exito);
        assertEquals(mesa.getJugadorList().get(0).getMano().size(), 3);
        assertEquals(mesa.getJugadorList().get(1).getMano().size(), 3);
        assertEquals(mesa.getJugadorList().get(2).getMano().size(), 3);
        assertEquals(tamanoBarajaInicial - 3, tamanoBarajaFinal);
    }

    @Test
    public void seEjecutaRondaFinalConTresJugadores3CartasEnMesa() {
        mesa.getBaraja().setBaraja(mesa.getBaraja().getBaraja().subList(0,2));
        boolean exito = rondaService.iniciarRonda(mesa, barajaService, jugadorService);
        int tamanoBarajaFinal = mesa.getBaraja().getBaraja().size();
        Carta muestraFinal = mesa.getCartaMuestra();

        assertTrue(exito);
        assertEquals(mesa.getJugadorList().get(0).getMano().size(), 3);
        assertEquals(mesa.getJugadorList().get(1).getMano().size(), 3);
        assertEquals(mesa.getJugadorList().get(2).getMano().size(), 3);
        assertEquals(0, tamanoBarajaFinal);
        assertNull(muestraFinal);
    }

    @Test
    public void seEjecutaRondaFinalConTresJugadores2CartasEnMesa() {
        mesa.getBaraja().setBaraja(mesa.getBaraja().getBaraja().subList(0,1));
        boolean exito = rondaService.iniciarRonda(mesa, barajaService, jugadorService);
        int tamanoBarajaFinal = mesa.getBaraja().getBaraja().size();
        Carta muestraFinal = mesa.getCartaMuestra();

        assertFalse(exito);
        assertEquals(mesa.getJugadorList().get(0).getMano().size(), 3);
        assertEquals(mesa.getJugadorList().get(1).getMano().size(), 3);
        assertEquals(mesa.getJugadorList().get(2).getMano().size(), 3);
        assertEquals(0, tamanoBarajaFinal);
        assertNull(muestraFinal);
    }

}