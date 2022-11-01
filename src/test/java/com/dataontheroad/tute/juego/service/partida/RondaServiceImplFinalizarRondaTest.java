package com.dataontheroad.tute.juego.service.partida;

import com.dataontheroad.tute.juego.domain.cartas.Carta;
import com.dataontheroad.tute.juego.domain.cartas.CartaEnum;
import com.dataontheroad.tute.juego.domain.jugador.Jugador;
import com.dataontheroad.tute.juego.domain.mesa.Mesa;
import com.dataontheroad.tute.juego.domain.partida.Ronda;
import com.dataontheroad.tute.juego.service.mesa.MesaService;
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
    MesaService mesaService;

    @BeforeEach
    public void setUp() {
        rondaService = new RondaService();
        mesaService = new MesaService();

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