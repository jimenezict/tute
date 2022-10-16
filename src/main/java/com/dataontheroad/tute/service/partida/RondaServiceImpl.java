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

        ronda.setCartaMasAlta(null);
        ronda.setJugadorGanador(null);
        ronda.setCartaMasAlta(null);

        return true;
    }

    @Override
    public void finalizarRonda(Mesa mesa, Ronda ronda) {
        Jugador jugadorGanador = obtenJugadorGanadorDeLaRonda(mesa, ronda);
        jugadorGanadorTomaLasCartasDeLaMesa(ronda, jugadorGanador);
    }

    @Override
    public Carta jugadorJuegaCarta(Mesa mesa, Ronda ronda, Jugador jugador, Carta carta) {
        ronda.getCartaMesaList().add(carta);
        if(ronda.getJugadorInicial().equals(jugador)) {
            ronda.setCartaMasAlta(carta);
            ronda.setJugadorGanador(jugador);
        }
        return null;
    }

    private static Jugador obtenJugadorGanadorDeLaRonda(Mesa mesa, Ronda ronda) {
        return mesa.getJugadorList().get(mesa.getJugadorList().indexOf(ronda.getJugadorGanador()));
    }

    private static void jugadorGanadorTomaLasCartasDeLaMesa(Ronda ronda, Jugador jugadorGanador) {
        jugadorGanador.getDescartes().addAll(ronda.getCartaMesaList());
    }

}
