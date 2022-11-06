package com.dataontheroad.tute.juego.service.jugador;

import com.dataontheroad.tute.juego.domain.cartas.Carta;
import com.dataontheroad.tute.juego.domain.cartas.CartaEnum;
import com.dataontheroad.tute.juego.domain.jugador.Jugador;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.dataontheroad.tute.juego.service.jugador.JugadorService.*;
import static org.junit.jupiter.api.Assertions.*;

class JugadorServiceImplTest {

    Jugador jugador;

    @BeforeEach
    public void setUp() {
        jugador = new Jugador();
    }

    @Test
    void cuandoJugadorTieneTresCartasNoPuedeRobarMas() {
        List<Carta> mano1 = new ArrayList<Carta>();
        mano1.add(new Carta(CartaEnum.ESPADA, 1));
        mano1.add(new Carta(CartaEnum.ESPADA, 2));
        mano1.add(new Carta(CartaEnum.ESPADA, 3));
        jugador.setMano(mano1);
        boolean exito = robarCarta(jugador, new Carta(CartaEnum.ESPADA, 4));
        assertFalse(exito);
        assertEquals(3, jugador.getMano().size());
        assertFalse(jugador.getMano().contains(new Carta(CartaEnum.ESPADA, 4)));
    }

    @Test
    void cuandoJugadorTieneDosCartasPuedeRobarMas() {
        List<Carta> mano1 = new ArrayList<Carta>();
        mano1.add(new Carta(CartaEnum.ESPADA, 1));
        mano1.add(new Carta(CartaEnum.ESPADA, 2));
        jugador.setMano(mano1);
        boolean exito = robarCarta(jugador, new Carta(CartaEnum.ESPADA, 4));
        assertTrue(exito);
        assertEquals(3, jugador.getMano().size());
        assertTrue(jugador.getMano().contains(new Carta(CartaEnum.ESPADA, 4)));
    }

    @Test
    void jugadorHaGanadoVariasManos() {
        List<Carta> mano1 = new ArrayList<Carta>();
        mano1.add(new Carta(CartaEnum.ESPADA, 1));
        mano1.add(new Carta(CartaEnum.ESPADA, 2));
        mano1.add(new Carta(CartaEnum.ESPADA, 3));

        ganarMano(jugador, mano1);

        assertEquals(21, jugador.getPuntuacion());
        assertEquals(3,jugador.getDescartes().size());

        List<Carta> mano2 = new ArrayList<Carta>();
        mano2.add(new Carta(CartaEnum.ESPADA, 4));
        mano2.add(new Carta(CartaEnum.ESPADA, 5));
        mano2.add(new Carta(CartaEnum.ESPADA, 6));

        ganarMano(jugador, mano2);

        assertEquals(21, jugador.getPuntuacion());
        assertEquals(6,jugador.getDescartes().size());

        List<Carta> mano3 = new ArrayList<Carta>();
        mano3.add(new Carta(CartaEnum.ESPADA, 10));
        mano3.add(new Carta(CartaEnum.ESPADA, 11));
        mano3.add(new Carta(CartaEnum.ESPADA, 12));

        ganarMano(jugador, mano3);

        assertEquals(30, jugador.getPuntuacion());
        assertEquals(9, jugador.getDescartes().size());
    }

    @Test
    void cuandoElJugadorTieneLaCartaTirarla() {
        List<Carta> mano1 = new ArrayList<Carta>();
        mano1.add(new Carta(CartaEnum.ESPADA, 1));
        Carta cartaMuestra = new Carta(CartaEnum.ESPADA, 2);
        mano1.add(cartaMuestra);
        mano1.add(new Carta(CartaEnum.ESPADA, 3));
        jugador.setMano(mano1);

        boolean exito = tirarCarta(jugador, cartaMuestra);

        assertTrue(exito);
        assertEquals(2, jugador.getMano().size());
        assertFalse(jugador.getMano().contains(cartaMuestra));

    }

    @Test
    void cuandoElJugadorNoTieneLaCartaErrorAlTirarla() {
        List<Carta> mano1 = new ArrayList<Carta>();
        mano1.add(new Carta(CartaEnum.ESPADA, 1));
        mano1.add(new Carta(CartaEnum.ESPADA, 2));
        mano1.add(new Carta(CartaEnum.ESPADA, 3));

        Carta cartaMuestra = new Carta(CartaEnum.ESPADA, 4);
        jugador.setMano(mano1);

        boolean exito = tirarCarta(jugador, cartaMuestra);

        assertFalse(exito);
        assertEquals(3, jugador.getMano().size());
        assertFalse(jugador.getMano().contains(cartaMuestra));
    }

    @Test
    void jugadorSeInicializaCorrectamente() {
        List<Carta> descartes = new ArrayList<Carta>();
        descartes.add(new Carta(CartaEnum.ESPADA, 1));
        descartes.add(new Carta(CartaEnum.ESPADA, 2));
        descartes.add(new Carta(CartaEnum.ESPADA, 3));

        List<Carta> mano = new ArrayList<Carta>();
        mano.add(new Carta(CartaEnum.ORO, 1));
        mano.add(new Carta(CartaEnum.ORO, 2));
        mano.add(new Carta(CartaEnum.ORO, 3));

        jugador.setPuntuacion(100);
        jugador.setDescartes(descartes);
        jugador.setMano(mano);

        inicializarJugadorPartida(jugador);

        assertEquals(0, jugador.getPuntuacion());
        assertEquals(0, jugador.getMano().size());
        assertEquals(0, jugador.getDescartes().size());
    }

}