package com.dataontheroad.tute.service;

import com.dataontheroad.tute.domain.cartas.Carta;
import com.dataontheroad.tute.domain.cartas.CartaEnum;
import com.dataontheroad.tute.domain.jugador.Jugador;
import com.dataontheroad.tute.service.jugador.JugadorService;
import com.dataontheroad.tute.service.jugador.JugadorServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JugadorServiceImplTest {

    Jugador jugador;
    JugadorService jugadorService;

    @BeforeEach
    public void setUp() {
        jugador = new Jugador();
        jugadorService = new JugadorServiceImpl();
    }

    @Test
    public void cuandoJugadorTieneTresCartasNoPuedeRobarMas() {
        List<Carta> mano1 = new ArrayList<Carta>();
        mano1.add(new Carta(CartaEnum.ESPADA, 1));
        mano1.add(new Carta(CartaEnum.ESPADA, 2));
        mano1.add(new Carta(CartaEnum.ESPADA, 3));
        jugador.setMano(mano1);
        boolean exito = jugadorService.robarCarta(jugador, new Carta(CartaEnum.ESPADA, 4));
        assertFalse(exito);
        assertEquals(jugador.getMano().size(), 3);
        assertFalse(jugador.getMano().contains(new Carta(CartaEnum.ESPADA, 4)));
    }

    @Test
    public void cuandoJugadorTieneDosCartasPuedeRobarMas() {
        List<Carta> mano1 = new ArrayList<Carta>();
        mano1.add(new Carta(CartaEnum.ESPADA, 1));
        mano1.add(new Carta(CartaEnum.ESPADA, 2));
        jugador.setMano(mano1);
        boolean exito = jugadorService.robarCarta(jugador, new Carta(CartaEnum.ESPADA, 4));
        assertTrue(exito);
        assertEquals(jugador.getMano().size(), 3);
        assertTrue(jugador.getMano().contains(new Carta(CartaEnum.ESPADA, 4)));
    }

    @Test
    public void jugadorHaGanadoVariasManos() {
        List<Carta> mano1 = new ArrayList<Carta>();
        mano1.add(new Carta(CartaEnum.ESPADA, 1));
        mano1.add(new Carta(CartaEnum.ESPADA, 2));
        mano1.add(new Carta(CartaEnum.ESPADA, 3));

        jugadorService.ganarMano(jugador, mano1);

        assertEquals(jugador.getPuntuacion(), 21);
        assertEquals(jugador.getDescartes().size(), 3);

        List<Carta> mano2 = new ArrayList<Carta>();
        mano2.add(new Carta(CartaEnum.ESPADA, 4));
        mano2.add(new Carta(CartaEnum.ESPADA, 5));
        mano2.add(new Carta(CartaEnum.ESPADA, 6));

        jugadorService.ganarMano(jugador, mano2);

        assertEquals(jugador.getPuntuacion(), 21);
        assertEquals(jugador.getDescartes().size(), 6);

        List<Carta> mano3 = new ArrayList<Carta>();
        mano3.add(new Carta(CartaEnum.ESPADA, 10));
        mano3.add(new Carta(CartaEnum.ESPADA, 11));
        mano3.add(new Carta(CartaEnum.ESPADA, 12));

        jugadorService.ganarMano(jugador, mano3);

        assertEquals(jugador.getPuntuacion(), 30);
        assertEquals(jugador.getDescartes().size(), 9);
    }

    @Test
    public void cuandoElJugadorTieneLaCartaTirarla() {
        List<Carta> mano1 = new ArrayList<Carta>();
        mano1.add(new Carta(CartaEnum.ESPADA, 1));
        Carta cartaMuestra = new Carta(CartaEnum.ESPADA, 2);
        mano1.add(cartaMuestra);
        mano1.add(new Carta(CartaEnum.ESPADA, 3));
        jugador.setMano(mano1);

        boolean exito = jugadorService.tirarCarta(jugador, cartaMuestra);

        assertTrue(exito);
        assertEquals(jugador.getMano().size(), 2);
        assertFalse(jugador.getMano().contains(cartaMuestra));

    }

    @Test
    public void cuandoElJugadorNoTieneLaCartaErrorAlTirarla() {
        List<Carta> mano1 = new ArrayList<Carta>();
        mano1.add(new Carta(CartaEnum.ESPADA, 1));
        mano1.add(new Carta(CartaEnum.ESPADA, 2));
        mano1.add(new Carta(CartaEnum.ESPADA, 3));

        Carta cartaMuestra = new Carta(CartaEnum.ESPADA, 4);
        jugador.setMano(mano1);

        boolean exito = jugadorService.tirarCarta(jugador, cartaMuestra);

        assertFalse(exito);
        assertEquals(jugador.getMano().size(), 3);
        assertFalse(jugador.getMano().contains(cartaMuestra));
    }

}