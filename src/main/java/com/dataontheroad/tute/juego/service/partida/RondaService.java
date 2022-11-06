package com.dataontheroad.tute.juego.service.partida;

import com.dataontheroad.tute.juego.domain.cartas.Baraja;
import com.dataontheroad.tute.juego.domain.cartas.Carta;
import com.dataontheroad.tute.juego.domain.jugador.Jugador;
import com.dataontheroad.tute.juego.domain.mesa.Mesa;
import com.dataontheroad.tute.juego.domain.partida.Ronda;

import static com.dataontheroad.tute.juego.service.cartas.BarajaService.cogerCartaBaraja;
import static com.dataontheroad.tute.juego.service.jugador.JugadorService.ganarMano;
import static com.dataontheroad.tute.juego.service.jugador.JugadorService.robarCarta;
import static java.util.Objects.isNull;

public class RondaService {

    public static boolean iniciarRonda(Mesa mesa, Ronda ronda) {
        Baraja baraja = mesa.getBaraja();

        for (Jugador jugador: mesa.getJugadorList()) {
            Carta carta = cogerCartaBaraja(baraja);
            if(isNull(carta)) {
                if(!isNull(mesa.getCartaMuestra())) {
                    carta = mesa.getCartaMuestra();
                    mesa.setCartaMuestra(null);
                } else {
                    return false;
                }
            }
            robarCarta(jugador, carta);
        }

        actualizaRondaConNuevoJugadorGanadorAndCartaMasAlta(ronda, null, null);
        return true;
    }

    public static Jugador finalizarRonda(Mesa mesa, Ronda ronda) {
        Jugador jugadorGanador = obtenJugadorGanadorDeLaRonda(mesa, ronda);
        jugadorGanadorTomaLasCartasDeLaMesa(ronda, jugadorGanador);
        return jugadorGanador;
    }

    public static void jugadorJuegaCarta(Ronda ronda, Jugador jugador, Carta carta, Carta cartaMuestra) {
        jugadorTiraCartaAMesa(ronda, jugador, carta);

        if(esJugadorInicial(ronda, jugador)) {
            actualizaRondaConNuevoJugadorGanadorAndCartaMasAlta(ronda, jugador, carta);
        } else {
            if(ganaAcartaMasAlta(ronda.getCartaMasAlta(), cartaMuestra, carta)) {
                actualizaRondaConNuevoJugadorGanadorAndCartaMasAlta(ronda, jugador, carta);
            }
        }
    }

    private static void actualizaRondaConNuevoJugadorGanadorAndCartaMasAlta(Ronda ronda, Jugador jugador, Carta carta) {
        ronda.setCartaMasAlta(carta);
        ronda.setJugadorGanador(jugador);
    }

    private static boolean esJugadorInicial(Ronda ronda, Jugador jugador) {
        return ronda.getJugadorInicial().equals(jugador);
    }

    private static void jugadorTiraCartaAMesa(Ronda ronda, Jugador jugador, Carta carta) {
        ronda.getCartaMesaList().add(carta);
        jugador.getMano().remove(carta);
    }

    private static boolean ganaAcartaMasAlta(Carta cartaMasAlta, Carta cartaMuestra, Carta carta) {
        return CartaMasAltaHelper.cartaMasAlta(cartaMasAlta, cartaMuestra, carta);
    }

    private static Jugador obtenJugadorGanadorDeLaRonda(Mesa mesa, Ronda ronda) {
        return mesa.getJugadorList().get(mesa.getJugadorList().indexOf(ronda.getJugadorGanador()));
    }

    private static void jugadorGanadorTomaLasCartasDeLaMesa(Ronda ronda, Jugador jugadorGanador) {
        ganarMano(jugadorGanador, ronda.getCartaMesaList());
    }

}
