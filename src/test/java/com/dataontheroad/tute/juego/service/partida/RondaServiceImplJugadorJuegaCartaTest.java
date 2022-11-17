package com.dataontheroad.tute.juego.service.partida;

import com.dataontheroad.tute.juego.domain.cartas.Carta;
import com.dataontheroad.tute.juego.domain.cartas.CartaEnum;
import com.dataontheroad.tute.juego.domain.jugador.Jugador;
import com.dataontheroad.tute.juego.domain.mesa.Mesa;
import com.dataontheroad.tute.juego.domain.partida.Ronda;
import com.dataontheroad.tute.juego.service.jugador.strategy.PrimeraCartaDeLaManoStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.dataontheroad.tute.ObjectCreationHelper.creadorListaJugardoresPartidaConLaMismaEstrategia;
import static com.dataontheroad.tute.juego.service.mesa.MesaService.crearMesa;
import static com.dataontheroad.tute.juego.service.partida.RondaService.jugadorJuegaCarta;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class RondaServiceImplJugadorJuegaCartaTest {

    Mesa mesa;
    Ronda ronda;
    Carta cartaMuestra;

    @BeforeEach
    public void setUp() {

        List<Jugador> jugadorList = creadorListaJugardoresPartidaConLaMismaEstrategia(3, (new PrimeraCartaDeLaManoStrategy()));

        mesa = crearMesa(jugadorList);
        cartaMuestra = new Carta(CartaEnum.ORO, 3);
        mesa.setCartaMuestra(cartaMuestra);

        ronda = new Ronda();
        ronda.setJugadorInicial(mesa.getJugadorList().get(0));
    }

    @Test
    void cadaJugadorJuegaUnaCarta() {
        jugadorJuegaCarta(ronda, mesa.getJugadorList().get(0), mesa.getJugadorList().get(0).getMano().get(0), cartaMuestra);

        assertEquals(2, mesa.getJugadorList().get(0).getMano().size());
        assertEquals(3, mesa.getJugadorList().get(1).getMano().size());
        assertEquals(3, mesa.getJugadorList().get(2).getMano().size());

        assertEquals(1, ronda.getCartaMesaList().size());
        assertNotNull(ronda.getCartaMasAlta());
        assertNotNull(ronda.getJugadorGanador());
        assertEquals(1, ronda.getCartaMesaList().size());

        jugadorJuegaCarta(ronda, mesa.getJugadorList().get(1), mesa.getJugadorList().get(1).getMano().get(0), cartaMuestra);

        assertEquals(2, mesa.getJugadorList().get(0).getMano().size());
        assertEquals(2, mesa.getJugadorList().get(1).getMano().size());
        assertEquals(3, mesa.getJugadorList().get(2).getMano().size());

        jugadorJuegaCarta(ronda, mesa.getJugadorList().get(2), mesa.getJugadorList().get(2).getMano().get(0), cartaMuestra);

        assertEquals(2, mesa.getJugadorList().get(0).getMano().size());
        assertEquals(2, mesa.getJugadorList().get(1).getMano().size());
        assertEquals(2, mesa.getJugadorList().get(2).getMano().size());
    }



}