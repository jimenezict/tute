package com.dataontheroad.tute.service.partida;

import com.dataontheroad.tute.domain.cartas.Baraja;
import com.dataontheroad.tute.domain.cartas.Carta;
import com.dataontheroad.tute.domain.jugador.Jugador;
import com.dataontheroad.tute.domain.mesa.Mesa;
import com.dataontheroad.tute.service.cartas.BarajaService;
import com.dataontheroad.tute.service.jugador.JugadorService;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;

@Component
public class RondaServiceImpl implements RondaService {

    @Override
    public boolean iniciarRonda(Mesa mesa, BarajaService barajaService, JugadorService jugadorService) {
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

        return true;
    }

    @Override
    public void finalizarRonda(Mesa mesa) {

    }

    @Override
    public Carta jugadorJuegaCarta(Mesa mesa, Jugador jugador, Carta carta) {
        return null;
    }
}
