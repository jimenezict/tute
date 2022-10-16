package com.dataontheroad.tute.service.partida;

import com.dataontheroad.tute.domain.cartas.Baraja;
import com.dataontheroad.tute.domain.cartas.Carta;
import com.dataontheroad.tute.domain.jugador.Jugador;
import com.dataontheroad.tute.domain.mesa.Mesa;
import com.dataontheroad.tute.domain.partida.Ronda;
import com.dataontheroad.tute.service.cartas.BarajaService;
import com.dataontheroad.tute.service.jugador.JugadorService;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;

@Component
public class RondaServiceImpl implements RondaService {

    @Override
    public boolean iniciarRonda(Mesa mesa, Ronda ronda, BarajaService barajaService, JugadorService jugadorService) {
        Baraja baraja = mesa.getBaraja();

        for (Jugador jugador: mesa.getJugadorList()) {
            Carta carta = barajaService.cogerCarta(baraja);
            if(isNull(carta)) {
                if(!isNull(mesa.getCartaMuestra())) {
                    carta = mesa.getCartaMuestra();
                    mesa.setCartaMuestra(null);
                } else {
                    return false;
                }
            }
            jugadorService.robarCarta(jugador, carta);
        }

        actualizaRondaConNuevoJugadorGanadorAndCartaMasAlta(ronda, null, null);

        return true;
    }

    @Override
    public void finalizarRonda(Mesa mesa, Ronda ronda) {
        Jugador jugadorGanador = obtenJugadorGanadorDeLaRonda(mesa, ronda);
        jugadorGanadorTomaLasCartasDeLaMesa(ronda, jugadorGanador);
    }

    @Override
    public void jugadorJuegaCarta(Ronda ronda, Jugador jugador, Carta carta, Carta cartaMuestra) {
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
        // TODO: method to be implemented
        return false;
    }

    private static Jugador obtenJugadorGanadorDeLaRonda(Mesa mesa, Ronda ronda) {
        return mesa.getJugadorList().get(mesa.getJugadorList().indexOf(ronda.getJugadorGanador()));
    }

    private static void jugadorGanadorTomaLasCartasDeLaMesa(Ronda ronda, Jugador jugadorGanador) {
        jugadorGanador.getDescartes().addAll(ronda.getCartaMesaList());
    }

}
