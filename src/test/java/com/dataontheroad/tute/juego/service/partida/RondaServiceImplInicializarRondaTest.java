package com.dataontheroad.tute.juego.service.partida;

import com.dataontheroad.tute.juego.domain.cartas.Carta;
import com.dataontheroad.tute.juego.domain.jugador.Jugador;
import com.dataontheroad.tute.juego.domain.mesa.Mesa;
import com.dataontheroad.tute.juego.domain.partida.Ronda;
import com.dataontheroad.tute.juego.service.jugador.strategy.PrimeraCartaDeLaManoStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.dataontheroad.tute.ObjectCreationHelper.creadorListaJugardoresPartidaConLaMismaEstrategia;
import static com.dataontheroad.tute.juego.service.mesa.MesaService.crearMesa;
import static com.dataontheroad.tute.juego.service.partida.RondaService.iniciarRonda;
import static org.junit.jupiter.api.Assertions.*;

class RondaServiceImplInicializarRondaTest {

    Mesa mesa;
    Ronda ronda;

    @BeforeEach
    public void setUp() {

        List<Jugador> jugadorList = creadorListaJugardoresPartidaConLaMismaEstrategia(3, (new PrimeraCartaDeLaManoStrategy()));

        mesa = crearMesa(jugadorList);
        ronda = new Ronda();

    }

    @Test
    void seEjecutaRondaInicialConTresJugadores() {
        Carta muestraInicial = mesa.getCartaMuestra();
        int tamanoBarajaInicial = mesa.getBaraja().getListaCartasBaraja().size();
        boolean exito = iniciarRonda(mesa, ronda);
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
        boolean exito = iniciarRonda(mesa, ronda);
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
        boolean exito = iniciarRonda(mesa, ronda);
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