package com.dataontheroad.tute.juego.service.jugador.strategy;

import com.dataontheroad.tute.juego.domain.cartas.Carta;
import com.dataontheroad.tute.juego.domain.jugador.Jugador;
import com.dataontheroad.tute.juego.domain.partida.Ronda;
import com.dataontheroad.tute.juego.service.partida.CartaMasAltaHelper;

import static com.dataontheroad.tute.juego.service.jugador.helper.StrategyHelper.cartaMenorPeso;
import static java.util.Objects.isNull;

public class UltimaCartaQuePuedeGanarSinoMenorValorStrategy extends StrategyAbstract {

    @Override
    public Carta jugarCarta(Ronda ronda, Carta cartaMuestra, Jugador jugador) {
        Carta cartaJugada = null;
        for (Carta carta : jugador.getMano()) {
            if (CartaMasAltaHelper.cartaMasAlta(ronda.getCartaMasAlta(), cartaMuestra, carta)) {
                cartaJugada = carta;
            }
        }
        if(isNull(cartaJugada)) {
            return cartaMenorPeso(cartaMuestra,jugador.getMano());
        }

        return cartaJugada;
    }

}
