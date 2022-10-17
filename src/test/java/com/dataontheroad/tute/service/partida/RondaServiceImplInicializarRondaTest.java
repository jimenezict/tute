package com.dataontheroad.tute.service.partida;

import com.dataontheroad.tute.domain.cartas.Carta;
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

class RondaServiceImplInicializarRondaTest {

    Mesa mesa;
    Ronda ronda;
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

        mesa = mesaService.crearMesa(jugadorList);
        ronda = new Ronda();

    }

    @Test
    void seEjecutaRondaInicialConTresJugadores() {
        Carta muestraInicial = mesa.getCartaMuestra();
        int tamanoBarajaInicial = mesa.getBaraja().getListaCartasBaraja().size();
        boolean exito = rondaService.iniciarRonda(mesa, ronda, barajaService, jugadorService);
        int tamanoBarajaFinal = mesa.getBaraja().getListaCartasBaraja().size();
        Carta muestraFinal = mesa.getCartaMuestra();
        assertEquals(muestraInicial, muestraFinal);

        assertTrue(exito);
        assertTodosLosJugadoresTienenTresCartas();
        assertEquals(tamanoBarajaInicial - 3, tamanoBarajaFinal);

        assertNull(ronda.getCartaMasAlta());
        assertNull(ronda.getJugadorGanador());
        assertEquals(0, ronda.getCartaMesaList().size());
    }

    @Test
    void seEjecutaRondaFinalConTresJugadores3CartasEnMesa() {
        mesa.getBaraja().setListaCartasBaraja(mesa.getBaraja().getListaCartasBaraja().subList(0,2));
        boolean exito = rondaService.iniciarRonda(mesa, ronda, barajaService, jugadorService);
        int tamanoBarajaFinal = mesa.getBaraja().getListaCartasBaraja().size();
        Carta muestraFinal = mesa.getCartaMuestra();

        assertTrue(exito);
        assertTodosLosJugadoresTienenTresCartas();
        assertEquals(0, tamanoBarajaFinal);
        assertNull(muestraFinal);
    }

    @Test
    void seEjecutaRondaFinalConTresJugadores2CartasEnMesa() {
        mesa.getBaraja().setListaCartasBaraja(mesa.getBaraja().getListaCartasBaraja().subList(0,1));
        boolean exito = rondaService.iniciarRonda(mesa, ronda, barajaService, jugadorService);
        int tamanoBarajaFinal = mesa.getBaraja().getListaCartasBaraja().size();
        Carta muestraFinal = mesa.getCartaMuestra();

        assertFalse(exito);
        assertTodosLosJugadoresTienenTresCartas();
        assertEquals(0, tamanoBarajaFinal);
        assertNull(muestraFinal);
    }

    private void assertTodosLosJugadoresTienenTresCartas() {
        assertEquals(3, mesa.getJugadorList().get(0).getMano().size());
        assertEquals(3, mesa.getJugadorList().get(1).getMano().size());
        assertEquals(3, mesa.getJugadorList().get(2).getMano().size());
    }
}