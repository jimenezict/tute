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
import static org.springframework.util.ObjectUtils.isEmpty;

class RondaServiceImplFinalizarRondaTest {

    Mesa mesa;
    Ronda ronda;
    RondaService rondaService;
    JugadorService jugadorService;
    MesaService mesaService;

    @BeforeEach
    public void setUp() {
        rondaService = new RondaServiceImpl();
        jugadorService = new JugadorServiceImpl();
        mesaService = new MesaServiceImpl();

        List<Jugador> jugadorList = new ArrayList<>();
        jugadorList.add(new Jugador());
        jugadorList.add(new Jugador());
        jugadorList.add(new Jugador());

        mesa = mesaService.crearMesa(jugadorList);
        ronda = new Ronda();
        ronda.setJugadorGanador(mesa.getJugadorList().get(2));
        List<Carta> cartaMesa = new ArrayList<>();
        cartaMesa.add(new Carta(CartaEnum.ESPADA, 1));
        cartaMesa.add(new Carta(CartaEnum.ESPADA, 2));
        cartaMesa.add(new Carta(CartaEnum.ESPADA, 3));
        ronda.setCartaMesaList(cartaMesa);
    }

    @Test
    void alAcabarRondaJugadorDosTieneTresCartasEnDescartes() {
        Jugador jugador = rondaService.finalizarRonda(mesa, ronda);

        assertTrue(isEmpty(mesa.getJugadorList().get(0).getDescartes()));
        assertTrue(isEmpty(mesa.getJugadorList().get(1).getDescartes()));
        assertFalse(isEmpty(mesa.getJugadorList().get(2).getDescartes()));
        assertNotNull(jugador);
    }

}