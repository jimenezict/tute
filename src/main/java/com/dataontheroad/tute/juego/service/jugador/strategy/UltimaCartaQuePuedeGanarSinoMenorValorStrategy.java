package com.dataontheroad.tute.juego.service.jugador.strategy;

import com.dataontheroad.tute.juego.domain.cartas.Carta;
import com.dataontheroad.tute.juego.domain.jugador.Jugador;
import com.dataontheroad.tute.juego.domain.partida.Ronda;
import com.dataontheroad.tute.juego.service.partida.CartaMasAltaHelper;

import static com.dataontheroad.tute.juego.service.jugador.helper.StrategyHelper.cartaMenorPeso;

public class UltimaCartaQuePuedeGanarSinoMenorValorStrategy extends StrategyAbstract {

    @Override
    public Carta jugarCarta(Ronda ronda, Carta cartaMuestra, Jugador jugador) {
        Carta cartaJugada = ronda.getCartaMasAlta();
        for (Carta carta : jugador.getMano()) {
            if (CartaMasAltaHelper.cartaMasAlta(cartaJugada, cartaMuestra, carta)) {
                cartaJugada = carta;
            }
        }

        if(cartaJugada.equals(ronda.getCartaMasAlta())) {
            return cartaMenorPeso(cartaMuestra,jugador.getMano());
        }

        return cartaJugada;
    }

}
